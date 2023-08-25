package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;

import jakarta.validation.Valid;

public interface CardBankService {
	RegisterCardBankDto createPaymentCard(@Valid RegisterCardBankDto cBankDto);
}
