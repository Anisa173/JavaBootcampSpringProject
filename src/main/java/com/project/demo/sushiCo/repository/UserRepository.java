package com.project.demo.sushiCo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.entity.User;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	RegisterUserForm save(RegisterUserForm result);

	@Query("Select c.id  From User c INNER JOIN Restorant r ON r.c.id = restorant_users.userId And r.idRestorant = restorant_users.idRest "
			+ " Where c.id =: id And r.idRestorant IN( Select a.id,sh.id,r.idRestorant  From User a INNER JOIN r ON  a.id = a.r.adminRId"
			+ "	INNER JOIN User sh ON a.id = a.sh.idAdmin"
			+ " Where a.id =: ?1 And sh.id =: ?2 And r.idRestorant =: ?3  )")
	RegisterUserForm getUserById(Integer idRestorant,Integer adminRId, Integer userId,Integer idAdmin);

	User save(RegisterUserFormDto userF);

	@Query("Select sh ,r.restName From User a Inner Join User sh On a.id = a.sh.idAdmin "
+ " INNER JOIN Restorant r ON  a.id = a.r.adminRId "
+ "  Order By a.id ")
	List<User> getAllShippersByAdminId(Integer id);

}
