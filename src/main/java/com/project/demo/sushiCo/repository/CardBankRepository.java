package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.CardBankDto;
import com.project.demo.sushiCo.entity.CardBank;

@Service
public interface CardBankRepository extends JpaRepository<CardBank, Integer >{

	@Modifying
	@Query("INSERT INTO Cards(BankId,valid_from,expiredTime,cardSecurityCode,userCardId)"
			+ "VALUES(?1,?2,?3,?4,(SELECT cust.c.userCardId,cust.id FROM User cust INNER JOIN CardBank c ON cust.c.userCardId = cust.id WHERE cust.id =: id ))")
	CardBank createPaymentCard(CardBankDto cBankDto );



}
