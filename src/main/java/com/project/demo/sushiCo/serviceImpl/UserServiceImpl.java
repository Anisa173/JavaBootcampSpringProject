package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.domain.dto.UserWithFileDto;
import com.project.demo.sushiCo.domain.mappers.LoginMapper;
import com.project.demo.sushiCo.domain.mappers.RegisterUserFormMapper;
import com.project.demo.sushiCo.domain.mappers.UserMapper;
import com.project.demo.sushiCo.entity.UserRole;
import com.project.demo.sushiCo.repository.UserRepository;
import com.project.demo.sushiCo.service.FileSystemStorageService;
import com.project.demo.sushiCo.service.UserService;
import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	private final RegisterUserFormMapper registerUserFormMapper;
	private final FileSystemStorageService storageService;
	private final LoginMapper loginMapper;

	public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, UserMapper userMapper,
			RegisterUserFormMapper registerUserFormMapper, FileSystemStorageService storageService,
			LoginMapper loginMapper) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
		this.registerUserFormMapper = registerUserFormMapper;
		this.storageService = storageService;
		this.loginMapper = loginMapper;
	}

	@Override
	public UserDto registerUserForm(@Valid RegisterUserForm registerUserForm) throws Exception {
		var userF = getUserById(registerUserForm.getIdRestorant(), registerUserForm.getUserId(),
				registerUserForm.getId());
		userF.setFirst_name(registerUserForm.getFirst_name());
		userF.setLast_name(registerUserForm.getLast_name());
		userF.setPassword(registerUserForm.getPassword());
		userF.setEmail(registerUserForm.getEmail());
		userF.setAddress(registerUserForm.getAddress());
		userF.setPhoneNo(registerUserForm.getPhoneNo());
		userF.setAge(registerUserForm.getAge());
		userF.setPersonalIdentityNo(registerUserForm.getPersonalIdentityNo());
		userF.setRestName(registerUserForm.getRestName());
		userF.setUserRole(UserRole.fromValue(registerUserForm.getUserRole()));
		return userMapper.toDto(repository.save(userF));

	}

	@Override
	public RegisterUserFormDto getUserById(Integer idRestorant, Integer userId, Integer registrationId)
			throws Exception {
		return registerUserFormMapper.toDto(repository.getUserById(idRestorant, registrationId, userId));

	}

	@Override
	public UserDto registerNewUserAccount(@Valid RegisterUserFormDto registerUserForm)
			throws UsernameNotFoundException {
		registerUserForm.setPassword(passwordEncoder.encode(registerUserForm.getPassword()));
		var result = registerUserFormMapper.toEntity(registerUserForm);
		return userMapper.toDto(repository.save(result));
	}

	@Override
	public UserDto update(Integer userId, Integer idRestorant, Integer registrationId,
			@Valid RegisterUserFormDto registerUserForm) throws Exception {
		var user = registerUserFormMapper.toEntity(getUserById(idRestorant, registrationId, userId));
		var result = registerUserFormMapper.toUpdate(registerUserForm, user);
		return userMapper.toDto(repository.save(result));
	}

	@Override
	public LoginDto getUserLogInById(Integer userId, Integer registrationId) throws Exception {

		return loginMapper.toDto(repository.getUserLogInById(userId, registrationId));
	}

	private boolean emailExists(String email) {
		return repository.findByEmail(email) != null;
	}

	@Override
	public UserDto login(@Valid Login form) throws Exception {
		if (emailExists(form.getEmail())) {
			throw new UsernameNotFoundException("There is an account with that email address: " + form.getEmail());
		}
		var user = getUserLogInById(form.getUserId(), form.getId());
		user.setEmail(form.getEmail());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		user.setUserRole(UserRole.fromValue(form.getUserRole()));
		return userMapper.toDto(repository.save(user));
	}

	@Override
	public UserDto registerLoginData(@Valid LoginDto form) throws Exception {
		form.setPassword(passwordEncoder.encode(form.getPassword()));
		var result = loginMapper.toEntity(form);
		return userMapper.toDto(repository.save(result));
	}

	@Override
	public UserDto updateLoginData(Integer userId, Integer registrationId, @Valid LoginDto login_form)
			throws Exception {
		var user = loginMapper.toEntity(getUserLogInById(registrationId, userId));
		var result = loginMapper.toUpdate(login_form, user);
		return userMapper.toDto(repository.save(result));
	}

	// Admini afishon te gjithe klientet qe kane krijuar llogari ne aplikacion
	@Override
	public List<UserDto> getAllUser() throws Exception {
		return repository.findAll().stream().map(m -> userMapper.toDto(m)).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		var toDelete = repository.findById(id);
		toDelete.get().setDeleted(false);
		repository.save(toDelete.get());
	}

	@Override
	public UserDto addIdentification(Integer idRestorant, Integer userId, Integer registrationId,
			UserWithFileDto reqDto) throws Exception {
		var user = getUserById(idRestorant, userId, registrationId);

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
	public Resource downloadIdentitficationCard(Integer idRestorant, Integer userId, Integer registrationId,
			UserWithFileDto reqDto) throws Exception {
		var user = getUserById(idRestorant, userId, registrationId);
		return (Resource) storageService.loadAsResource(((RegisterUserFormDto) user).getPersonalIdentityNo());
	}

	@Override
	public List<UserDto> getAllShippersByAdminId(Integer id) throws Exception {

		return (List<UserDto>) userMapper.toDto(repository.getAllShippersByAdminId(id));
	}

}
