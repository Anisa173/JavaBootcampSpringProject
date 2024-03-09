package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.demo.sushiCo.entity.Payment_Methods;
@Repository
public interface Payment_MethodsRepository extends JpaRepository<Payment_Methods, Integer>{

}
