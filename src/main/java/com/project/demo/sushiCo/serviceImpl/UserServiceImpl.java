package com.project.demo.sushiCo.serviceImpl;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.domain.dto.UserWithFileDto;
import com.project.demo.sushiCo.domain.mappers.UserMapper;
import com.project.demo.sushiCo.entity.User;
import com.project.demo.sushiCo.entity.UserRole;
import com.project.demo.sushiCo.repository.UserRepository;
import com.project.demo.sushiCo.service.FileSystemStorageService;
import com.project.demo.sushiCo.service.UserService;
import groovy.util.ResourceException;
import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	private final FileSystemStorageService storageService;

	public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, UserMapper userMapper,
			FileSystemStorageService storageService) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
		this.storageService = storageService;
	}

	@Override
	public UserDto registerUserForm(@Valid RegisterUserForm registerUserForm) throws Exception {
		var user = getUserById(registerUserForm.getId());
		user.setFirst_name(registerUserForm.getFirst_name());
		user.setLast_name(registerUserForm.getLast_name());
		user.setPassword(registerUserForm.getPassword());
		user.setEmail(registerUserForm.getEmail());
		user.setAddress(registerUserForm.getAddress());
		user.setPhoneNo(registerUserForm.getPhoneNo());
		user.setAge(registerUserForm.getAge());
		user.setPersonalIdentityNo(registerUserForm.getPersonalIdentityNo());
		user.setUserRole(UserRole.fromValue(registerUserForm.getUserRole()));
		return userMapper.toDto(repository.save(user));

	}

	@Override
	public UserDto registerNewUserAccount(@Valid UserDto userDto) throws UsernameNotFoundException {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		var result = userMapper.toEntity(userDto);
		return userMapper.toDto(repository.save(result));
	}

	private boolean emailExists(String email) {
		return repository.findByEmail(email) != null;
	}

	@Override
	public UserDto login(@Valid Login form) throws Exception {
		if (emailExists(form.getEmail())) {
			throw new UsernameNotFoundException("There is an account with that email address: " + form.getEmail());
		}
		var user = new User();
		user.setEmail(form.getEmail());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		user.setUserRole(UserRole.fromValue(form.getUserRole()));
		return userMapper.toDto(repository.save(user));
	}

	@Override
	public UserDto update(Integer id, @Valid UserDto userDto) throws Exception {
		User user = userMapper.toEntity(getUserById(id));
		var result = userMapper.toUpdate(userDto, user);
		return userMapper.toDto(repository.save(result));
	}

	@Override
	public List<UserDto> getAllUser() throws Exception {

		return repository.findAll().stream().map(m -> userMapper.toDto(m)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Integer id) throws Exception {
		return userMapper.toDto(
				repository.findById(id).orElseThrow(() -> new ResourceException(String.format("User not found!", id))));
	}

	@Override
	public void delete(Integer id) {
		var toDelete = repository.findById(id);
		toDelete.get().setDeleted(false);
		repository.save(toDelete.get());
	}

	@Override
	public UserDto addIdentification(Integer userId, UserWithFileDto reqDto) throws Exception {
		var user = getUserById(userId);

		String personalIdentityNo = UUID.randomUUID().toString().concat(".pdf");

		storageService.store(reqDto.getFile(), personalIdentityNo);
		user.setFirst_name(reqDto.getFirst_name());
		user.setLast_name(reqDto.getLast_name());
		user.setAddress(reqDto.getAddress());
		user.setAge(reqDto.getAge());
		user.setPersonalIdentityNo(personalIdentityNo);

		return userMapper.toDto(repository.save(user));
	}

	@Override
	public Resource downloadIdentitficationCard(Integer userId) throws Exception {
		var user = getUserById(userId);
		return (Resource) storageService.loadAsResource(user.getPersonalIdentityNo());
	}


	
	


}
