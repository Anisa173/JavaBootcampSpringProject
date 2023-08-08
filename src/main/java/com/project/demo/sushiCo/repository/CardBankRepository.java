package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.sushiCo.entity.CardBank;
@Repository
public interface CardBankRepository extends JpaRepository<CardBank, String>{

}
