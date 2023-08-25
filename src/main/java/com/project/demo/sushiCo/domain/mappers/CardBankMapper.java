package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;
import com.project.demo.sushiCo.entity.AddInBasket;
import com.project.demo.sushiCo.entity.CardBank;
@Component
public class CardBankMapper extends BaseMapper<CardBank , RegisterCardBankDto> {

	@Override
	public CardBank toEntity(RegisterCardBankDto dto) {
		CardBank card = new CardBank();
		card.setBankId(dto.getBankId());
		card.setValid_from(dto.getValid_from());
		card.setExpiredTime(dto.getExpiredTime());
		card.setCardSecurityCode(dto.getCardSecurityCode());
		return card;
	}

	@Override
	public RegisterCardBankDto toDto(CardBank entity) {
		RegisterCardBankDto cardsDto = new RegisterCardBankDto();
		cardsDto.setRegistrationId(entity.getId());
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
	public CardBank toUpdate(RegisterCardBankDto dto, CardBank entity) {
		
		return null;
	}

	@Override
	public List<CardBank> toEntity(List<RegisterCardBankDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<CardBank> list = new ArrayList<CardBank>( dtoList.size() );
        for ( RegisterCardBankDto cbDto : dtoList ) {
            list.add( toEntity( cbDto ) );
        }

        return list;

	}

	@Override
	public List<RegisterCardBankDto> toDto(List<CardBank> entityList) {
		if ( entityList == null ) {
            return null;
        }

        List<RegisterCardBankDto> list = new ArrayList<RegisterCardBankDto>( entityList.size() );
        for ( CardBank cb : entityList ) {
            list.add( toDto( cb ) );
        }

        return list;
	}

}
