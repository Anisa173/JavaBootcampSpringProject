package com.project.demo.sushiCo.domain.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.CardBankDto;
import com.project.demo.sushiCo.entity.CardBank;
@Component
public class CardBankMapper extends BaseMapper<CardBank , CardBankDto> {

	@Override
	public CardBank toEntity(CardBankDto dto) {
		CardBank card = new CardBank();
		card.setBankId(dto.getBankId());
		card.setValid_from(dto.getValid_from());
		card.setExpiredTime(dto.getExpiredTime());
		card.setCardSecurityCode(dto.getCardSecurityCode());
		return card;
	}

	@Override
	public CardBankDto toDto(CardBank entity) {
		CardBankDto cardsDto = new CardBankDto();
		cardsDto.setId(entity.getId());
		cardsDto.setBankId(entity.getBankId());
		cardsDto.setValid_from(entity.getValid_from());
		cardsDto.setExpiredTime(entity.getExpiredTime());
		cardsDto.setCardSecurityCode(entity.getCardSecurityCode());
		cardsDto.setUserCardId(entity.getUser().getId());
		var cardHolderName = entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name());
		cardsDto.setCardHolderName(cardHolderName);
		return cardsDto;
	}

	@Override
	public CardBank toUpdate(CardBankDto dto, CardBank entity) {
		
		return null;
	}

	@Override
	public List<CardBank> toEntity(List<CardBankDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardBankDto> toDto(List<CardBank> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
