package com.project.demo.sushiCo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;
import com.project.demo.sushiCo.domain.mappers.CardBankMapper;
import com.project.demo.sushiCo.repository.CardBankRepository;
import com.project.demo.sushiCo.service.CardBankService;
import jakarta.validation.Valid;

@Validated
@Service
public class CardBankServiceImpl implements CardBankService {
	@Autowired
	private final CardBankMapper cBankMapper;
	private final CardBankRepository cBankRepository;

	CardBankServiceImpl(CardBankMapper cBankMapper, CardBankRepository cBankRepository) {
		this.cBankMapper = cBankMapper;
		this.cBankRepository = cBankRepository;
	}

	@Override
	public RegisterCardBankDto createPaymentCard(@Valid RegisterCardBankDto cBankDto) {

		return cBankMapper.toDto(cBankRepository.createPaymentCard(cBankDto));
	}

}
