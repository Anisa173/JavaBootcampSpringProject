package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.entity.Order;

@Service
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
