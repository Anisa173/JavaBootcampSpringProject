package com.project.demo.sushiCo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.entity.User;
import com.project.demo.sushiCo.serviceImpl.Login;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;
import jakarta.validation.Valid;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	User save(RegisterUserForm result);

	@Query("Select c.id, adw.id  From User adw INNER JOIN User c On adw.c.adminIdPlatforma = adw.id "
			+ " INNER JOIN User a ON adw.c.adminIdPlatforma = adw.id "
			+ " INNER JOIN User sh ON adw.sh.adminIdPlatforma = adw.id "
			+ " INNER JOIN  Restorant r ON adw.r.adminIdWeb = adw.id "
			+ " Where adw.id =: ?1 And c.id =: ?2 And a.id IN( Select sh.id,r.restorantName,a.id  From User a INNER JOIN r ON  a.id = a.r.adminRId"
			+ "	INNER JOIN User sh ON a.id = a.sh.idAdmin"
			+ " Where a.id =: ?1  And sh.id =: ?2 And r.idRestorant =: ?3  )")
	RegisterUserForm getUserById(Integer idRestorant, Integer registrationId, Integer userId);

	@Query("Select sh ,a.id AdminRestorant_Id,r.restName Restorant_Name From User a Inner Join User sh On a.id = a.sh.idAdmin "
			+ " INNER JOIN Restorant r ON  a.id = a.r.adminRId " + "  Order By a.id ")
	List<User> getAllShippersByAdminId(Integer id);

	User save(RegisterUserFormDto user);

	@Query("Select c.id, adw.id,sh.id,a.id  From User adw INNER JOIN User c On adw.c.adminIdPlatforma = adw.id "
			+ " INNER JOIN User a ON adw.c.adminIdPlatforma = adw.id  "
			+ "	INNER JOIN User sh ON adw.sh.adminIdPlatforma = adw.id "
			+ "	Where adw.id =: ?1 And c.id =: ?2 And a.id  =: ?3 And sh.id =: ?4  ")
	Login getUserLogInById(Integer userId, Integer registrationId);

	User save(LoginDto user);

	User save(Login result);

	@Modifying
	@Query("Update User a Set deleted = true Where a.id IN( Select a.id,r.idRestorant From  User a INNER JOIN  User adw ON  adw.a.adminIdPlatforma = adw.id "
			+ " INNER JOIN Restorant r ON a.id = a.r.adminRId " + " Where a.id =: id  and adw.id =: id )")
	void deleteAdmin(Integer id);

	@Modifying
	@Query("Update User sh Set deleted = true Where sh.id IN( Select sh.id ,a.id From User a INNER JOIN User adw ON adw.a.adminIdPlatforma = adw.id"
			+ " INNER JOIN User sh ON a.id = a.sh.idAdmin" + " Where a.id =: id And sh.id =: id And adw.id =: id )")
	void deleteShippers(Integer id);

	@Query(" Update User u Set u.email =: ?1 And u.password =: ?2 And u.address =: ?3 And u.phoneNo =: ?4 And u.personalIdentityNo =: ?5 And u.userRole =: ?6 "
			+ " Where u.id IN ( Select r.idRestorant , a.id , sh.id   From User a INNER JOIN Restorant r ON  a.id = a.r.adminRId "
			+ " INNER JOIN User sh ON a.id = a.sh.idAdmin  Where r.idRestorant IN( Update r Set a.r.adminRId =: ?1  Where r.id =: ?2)"
			+ " And sh.id IN( Update sh Set a.sh.idAdmin =: ?1 Where sh.id =: ?2) )  ")
	RegisterUserForm update(Integer userId,Integer idRestorant,@Valid RegisterUserFormDto registerUserForm);

	@Modifying
	@Query(" Update User u Set u.email =: ?1 And u.password =: ?2 Where u.id IN "
			+ " ( Select c.id , adw.id ,sh.id ,a.id  From User adw INNER JOIN User c On adw.c.adminIdPlatforma = adw.id "
			+ " INNER JOIN User a ON adw.c.adminIdPlatforma = adw.id  "
			+ " INNER JOIN User sh ON adw.sh.adminIdPlatforma = adw.id "
			+ " Where adw.id =: ?1 And c.id =: ?2 And a.id  =: ?3 And sh.id =: ?4 ) ")
	Login updateLoginData(Integer userId,@Valid LoginDto loginForm1);

	@Query(" Select c From WebAplication wb INNER JOIN User adw ON  adw.wb.adminWebId = adw.id "
			+ " INNER JOIN User c ON wb.idAppl = wb.c.userApplId Where adw.id =: id  ")
	List<User> getAllCustomers();

	@Query(" Select sh ,r.restName From User a Inner Join User sh On a.id = a.sh.idAdmin "
			+ " INNER JOIN Restorant r ON  a.id = a.r.adminRId " + "  Where a.id =: id ")
	List<User> getShippersAdmin(Integer id);

}
