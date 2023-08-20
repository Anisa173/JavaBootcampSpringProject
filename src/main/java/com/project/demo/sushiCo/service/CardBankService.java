package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.CardBankDto;

import jakarta.validation.Valid;

public interface CardBankService {
	CardBankDto createPaymentCard(@Valid CardBankDto cBankDto);
}
