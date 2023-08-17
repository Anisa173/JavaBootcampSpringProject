package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import com.project.demo.sushiCo.entity.PaymentMethods;


@Service
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {

	PaymentMethods save(PaymentMethodsDto payment);
	@Query("SELECT pm, c.id"
			+ "FROM Restorant rest INNER JOIN User c ON rest.idRestorant = restorant_users.idRest AND rest.c.id = restorant_users.userId "
			+ "INNER JOIN PaymentMethods pm ON rest.idRestorant = rest.pm.paymentId " + "WHERE rest.c.id =: ?1 and rest.idRestorant =: ?2 ")
	PaymentMethods getRestorantPMethods(Integer userId, Integer restorantId);

}
