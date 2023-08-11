package com.project.demo.sushiCo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.CardBankDto;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
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

	@Query("Select r.cus.id,r.idRestorant,r.pm.paymentId,r.svp.service_idR FROM Restorant r INNER JOIN User cus ON r.cus.id = restorant_users.userId  AND r.IdRestorant = restorant_users.idRest "
			+ "INNER JOIN  PaymentMethods pm ON r.idRestorant = r.pm.paymentId "
			+ "INNER JOIN  ServicePlaces svp ON r.idRestorant = svp.service_idR "
			+ "WHERE r.cus.id =: ?1 AND r.idRestorant =: ?2 AND r.pm.paymentId =: ?3 AND r.svp.service_idR =: ?4")
	OrderByProcessingDto getPaymentServicesById(Integer custmId, Integer idRestorant, Integer pmId, Integer servPId);

	@Query("INSERT INTO Cards(BankId,valid_from,expiredTime,cardSecurityCode,userCardId)"
			+ "VALUES(?1,?2,?3,?4,(SELECT cust.c.userCardId,cust.id FROM User cust INNER JOIN CardBank c ON cust.c.userCardId = cust.id WHERE cust.id =: id ))")

	UserDto createPaymentCard();

	User save(OrderByProcessingDto pmSer);

	@Query(value = "Select c.id,cu.id FROM User as cu INNER JOIN CardBank as c ON  cu.id = c.userCardId Where c.id =: ?1 and cu.id =: ?2",nativeQuery = true)
	
	CardBankDto getCardsByCustomerId(Integer cardId, Integer custId);

	User save(CardBankDto cardB);

	

	

}
