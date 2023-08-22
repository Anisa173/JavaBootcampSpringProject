package com.project.demo.sushiCo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.entity.User;
import com.project.demo.sushiCo.serviceImpl.Login;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	User save(RegisterUserForm result);

	@Query("Select c.id, adw.id  From User adw INNER JOIN User c On adw.c.adminIdPlatforma = adw.id "
	+ " INNER JOIN User a ON adw.c.adminIdPlatforma = adw.id "
	+ " INNER JOIN User sh ON adw.sh.adminIdPlatforma = adw.id "
	+ " INNER JOIN  Restorant r ON adw.r.adminIdWeb = adw.id "
	+ " Where adw.id =: ?1 And c.id =: ?2 And a.id IN( Select sh.id,r.idRestorant,a.id  From User a INNER JOIN r ON  a.id = a.r.adminRId"
			+ "	INNER JOIN User sh ON a.id = a.sh.idAdmin"
			+ " Where a.id =: ?1  And sh.id =: ?2 And r.idRestorant =: ?3  )")
	RegisterUserForm getUserById(Integer idRestorant, Integer registrationId, Integer userId);

	@Query("Select sh ,r.restName From User a Inner Join User sh On a.id = a.sh.idAdmin "
+ " INNER JOIN Restorant r ON  a.id = a.r.adminRId "
+ "  Order By a.id ")
	List<User> getAllShippersByAdminId(Integer id);

	User save(RegisterUserFormDto user);

	@Query("Select c.id, adw.id,sh.id,a.id  From User adw INNER JOIN User c On adw.c.adminIdPlatforma = adw.id "
		+ " INNER JOIN User a ON adw.c.adminIdPlatforma = adw.id  "
		+ "	INNER JOIN User sh ON adw.sh.adminIdPlatforma = adw.id "
		+ "	Where adw.id =: ?1 And c.id =: ?2 And a.id  =: ?3 And sh.id =: ?4  ")
	Login getUserLogInById(Integer userId, Integer registrationId);

	User save(LoginDto user);

	User save(Login result);

	

}
