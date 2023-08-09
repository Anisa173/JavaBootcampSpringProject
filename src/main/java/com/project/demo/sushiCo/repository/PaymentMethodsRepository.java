package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import com.project.demo.sushiCo.entity.PaymentMethods;


@Service
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {

	PaymentMethods save(PaymentMethodsDto payment);

}
