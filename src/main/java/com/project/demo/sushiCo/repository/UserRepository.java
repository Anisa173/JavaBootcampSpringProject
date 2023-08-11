package com.project.demo.sushiCo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.entity.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	User save(UserDto user);

	@Query("SELECT rest.pm.payment_Method , rest.cust.id"
			+ "FROM Restorant rest INNER JOIN User cust ON rest.idRestorant = restorant_users.idRest AND rest.cust.id = restorant_users.userId "
			+ "INNER JOIN PaymentsMethods pm ON rest.idRestorant = rest.pm.paymentId " + "WHERE rest.cust.id =: id ")

	UserDto getRestorantPMethods(Integer userId, Integer restorantId, Integer paymentId);

	@Query(value = "SELECT sp.Id,sp.service_Places ,cust.id "
			+ "FROM Restorant as r INNER JOIN User as cust ON r.idRestorant = restorant_users.idRest AND cust.id = restorant_users.userId "
			+ "INNER JOIN ServicePlaces as sp ON r.idRestorant = sp.service_idR"
			+ "WHERE cust.id = ?", nativeQuery = true)

	UserDto getRestorantPServices(Integer custId, Integer restorantId, Integer service_PlacesId);
@Query("INSERT INTO Cards(BankId,valid_from,)")
	
	
	

	
	UserDto selectPaymentCard();
}
