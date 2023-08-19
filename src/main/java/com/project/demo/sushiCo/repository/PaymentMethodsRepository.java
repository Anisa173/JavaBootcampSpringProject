package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import com.project.demo.sushiCo.entity.PaymentMethods;

@Service
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {

	PaymentMethods save(PaymentMethodsDto payment);

	@Query(" SELECT pm.payment_Method, rest.idRestorant "
			+ " FROM Restorant rest INNER JOIN PaymentMethods pm ON rest.idRestorant = rest.pm.paymentId "
			+ " WHERE rest.idRestorant =: ?2 ")
	PaymentMethods getRestorantPMethods(Integer restorantId);

	@Query(" Select pm.Id,r.idRestorant From PaymentMethods pm INNER JOIN Restorant r ON r.pm.paymentId = r.idRestorant "
			+ " Where pm.Id =: Id And r.idRestorant =: idRestorant ")
	PaymentMethods getPayment_MethodsById(Integer id, Integer idRestorant);

	@Modifying
	@Query(" Delete From PaymentMethods pm Inner Join Restorant r ON r.pm.paymentId = r.idRestorant Where pm.Id =: ?1 and r.idRestorant =: ?2 ")
	void delete(Integer id, Integer idRestorant);

}
