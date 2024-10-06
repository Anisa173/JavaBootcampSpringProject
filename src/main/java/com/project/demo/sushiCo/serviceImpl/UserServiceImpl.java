package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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

@Validated
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository Urepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private final UserMapper userMapper;
	@Autowired
	private final RegisterUserFormMapper registerUserFormMapper;
	@Autowired
	private final FileSystemStorageService storageService;
	@Autowired
	private final LoginMapper loginMapper;

	public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, UserMapper userMapper,
			RegisterUserFormMapper registerUserFormMapper, FileSystemStorageService storageService,
			LoginMapper loginMapper) {
		super();
		this.Urepository = repository;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
		this.registerUserFormMapper = registerUserFormMapper;
		this.storageService = storageService;
		this.loginMapper = loginMapper;
	}

	@Override
	public UserDto registerUserForm(@Valid RegisterUserForm registerUserForm, Integer userId, Integer registrationId,
			Integer idRestorant) throws Exception {
		var userF = getUserById(registerUserForm.getUserId(), registerUserForm.getId(),
				registerUserForm.getIdRestorant());
		userF.setFirst_name(registerUserForm.getFirst_name());
		userF.setLast_name(registerUserForm.getLast_name());
		userF.setPassword(registerUserForm.getPassword());
		userF.setEmail(registerUserForm.getEmail());
		userF.setAddress(registerUserForm.getAddress());
		userF.setPhoneNo(registerUserForm.getPhoneNo());
		userF.setAge(registerUserForm.getAge());
		userF.setPersonalIdentityNo(registerUserForm.getPersonalIdentityNo());
		userF.setRestorant(registerUserForm.getRestorant());
		userF.setUserRole(UserRole.fromValue(registerUserForm.getUserRole()));
		return userMapper.toDto(Urepository.save(userF));
	}

	@Override
	public RegisterUserFormDto getUserById(Integer userId, Integer registrationId, Integer idRestorant)
			throws Exception {
		return registerUserFormMapper.toDto(Urepository.getUserById(userId, registrationId, idRestorant));

	}

	@Override
	public UserDto registerNewUserAccount(@Valid RegisterUserFormDto registerUserF, Integer idRestorant, Integer userId,Integer registrationId)
			throws UsernameNotFoundException {

		registerUserF.setPassword(passwordEncoder.encode(registerUserF.getPassword()));
		var result = registerUserFormMapper.toEntity(registerUserF);
		return userMapper.toDto(Urepository.save(result));
	}

	@Override
	public RegisterUserFormDto update(Integer userId,Integer idRestorant,@Valid RegisterUserFormDto regUserForm ) throws Exception {
		return registerUserFormMapper.toDto(((UserRepository) Urepository).update(userId, idRestorant,regUserForm));
	}

	@Override
	public LoginDto getUserLogInById(Integer userId, Integer registrationId) throws Exception {

		return loginMapper.toDto(Urepository.getUserLogInById(userId, registrationId));
	}

	@Override
	public UserDto login(@Valid Login form, Integer userId, Integer registrationId) throws Exception {
		if (emailExists(form.getEmail())) {
			throw new UsernameNotFoundException("There is an account with that email address: " + form.getEmail());
		}
		var user = getUserLogInById(form.getUserId(), form.getId());
		user.setEmail(form.getEmail());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		user.setUserRole(UserRole.fromValue(form.getUserRole()));
		return userMapper.toDto(Urepository.save(user));
	}

	private boolean emailExists(String email) {
		return (Urepository.findByEmail(email) != null);
	}

	@Override
	public LoginDto updateLoginData(Integer userId,@Valid LoginDto loginForm)
			throws Exception {
		return loginMapper.toDto(Urepository.updateLoginData(userId, loginForm));
	}


	// AdminWebi afishon te gjithe userat qe kane krijuar llogari ne aplikacion
	@Override
	public List<UserDto> getAllUser() throws Exception {
		return Urepository.findAll().stream().map(m -> userMapper.toDto(m)).collect(Collectors.toList());
	}

	// Kur nderpret marredheniet e punes admini i restorantit
	@Override
	public void deleteAdmin(Integer id) {
		Urepository.deleteAdmin(id);
	}

//Kur shippersi nderpret marredheniet e punes
	@Override
	public void deleteShippers(Integer id) {
		Urepository.deleteShippers(id);
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

		return userMapper.toDto(Urepository.save(user));
	}

	@Override
	public Resource downloadIdentitficationCard(Integer idRestorant, Integer userId, Integer registrationId,
			UserWithFileDto reqDto) throws Exception {
		var user = getUserById(idRestorant, userId, registrationId);
		return (Resource) storageService.loadAsResource(((RegisterUserFormDto) user).getPersonalIdentityNo());
	}

	@Override
	public List<UserDto> getAllShippersByAdminId(Integer id) throws Exception {

		return (List<UserDto>) userMapper.toDto(Urepository.getAllShippersByAdminId(id));
	}

	@Override
	public List<UserDto> getAllCustomers(Integer userId) throws Exception {
		
		return (List<UserDto>) userMapper.toDto(Urepository.getAllCustomers());
	}

	@Override
	public List<UserDto> getShippersAdmin(Integer id) throws Exception {
		return  userMapper.toDto(Urepository.getShippersAdmin(id));
	}

	

}
