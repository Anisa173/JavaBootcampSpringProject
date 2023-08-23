package com.project.demo.sushiCo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.CardBankDto;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.domain.mappers.AddInBasketMapper;
import com.project.demo.sushiCo.domain.mappers.CardBankMapper;
import com.project.demo.sushiCo.domain.mappers.OrderProcessingMapper;
import com.project.demo.sushiCo.domain.mappers.SelectDishesFormMapper;
import com.project.demo.sushiCo.repository.AddInBasketRepository;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.OrderByProcessing;
import com.project.demo.sushiCo.service.RegisterCardform;
import com.project.demo.sushiCo.service.SelectDishesForm;
import jakarta.validation.Valid;

@Validated
@Service
public class AddInBasketServiceImpl implements AddInBasketService {
	@Autowired
	private final AddInBasketRepository basketRepository;
	private final AddInBasketMapper basketMapper;
	private final SelectDishesFormMapper dishFormMapper;
	private final OrderProcessingMapper orderMapper;
	private final CardBankMapper cardFormMapper;

	public AddInBasketServiceImpl(AddInBasketRepository basketRepository, AddInBasketMapper basketMapper,
			SelectDishesFormMapper dishFormMapper, OrderProcessingMapper orderMapper, CardBankMapper cardFormMapper) {
		this.basketRepository = basketRepository;
		this.basketMapper = basketMapper;
		this.dishFormMapper = dishFormMapper;
		this.orderMapper = orderMapper;
		this.cardFormMapper = cardFormMapper;
	}

	@Override
	public AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm, Integer custId) throws Exception {
		var basketAdd = getDishDCategoriesByCustomerId(selectForm.getId(), selectForm.getCategoryId(),
				selectForm.getCustId());
		basketAdd.setCategoryName(selectForm.getCategoryName());
		basketAdd.setDish(selectForm.getDish());
		basketAdd.setNoItems(selectForm.getNoItems());
		return basketMapper.toDto(basketRepository.save(basketAdd));
	}

	@Override
	public SelectDishesFormDto getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer customerId)
			throws Exception {

		return dishFormMapper.toDto(basketRepository.getDishDCategoriesByCustomerId(dId, categoryId, customerId));
	}

	@Override
	public List<AddInBasketDto> getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId) throws Exception {
		return basketMapper.toDto(basketRepository.getDishesByCustomerId(dId, categoryId, custId));
	}

	@Override
	public AddInBasketDto displayPaymentServices(@Valid OrderByProcessing byProcessingform) throws Exception {
		var pmSer = getPaymentServicesById(byProcessingform.getIdcust(), byProcessingform.getPaymentMId(),
				byProcessingform.getServicePId(), byProcessingform.getIdRestorant());
		pmSer.setPayments_methodR(byProcessingform.getPayments_methodR());
		pmSer.setService_placesR(byProcessingform.getService_placesR());
		return basketMapper.toDto(basketRepository.save(pmSer));
	}

	@Override
	public OrderByProcessingDto getPaymentServicesById(Integer idcust, Integer idRestorant, Integer pmId,
			Integer servPId) throws Exception {

		return orderMapper.toDto(basketRepository.getPaymentServicesById(idcust, idRestorant, pmId, servPId));
	}

	@Override
	public CardBankDto getCardsByCustomerId(Integer registrationId, String BankId, Integer userCardId,
			Integer idRestorant, Integer pmId) {

		return cardFormMapper
				.toDto(basketRepository.getCardsByCustomerId(registrationId, BankId, userCardId, idRestorant, pmId));
	}

	@Override
	public CardBankDto displayCardForm(@Valid RegisterCardform cardBankForm) throws Exception {
		var cardB = getCardsByCustomerId(cardBankForm.getId(), cardBankForm.getBankId(), cardBankForm.getUserCardId(),
				cardBankForm.getIdRestorant(), cardBankForm.getPmId());
		cardB.setBankId(cardBankForm.getBankId());
		cardB.setValid_from(cardBankForm.getValid_from());
		cardB.setExpiredTime(cardBankForm.getExpiredTime());
		cardB.setCardSecurityCode(cardBankForm.getCardSecurityCode());
		return cardFormMapper.toDto(basketRepository.save(cardB));
	}

	@Override
	public AddInBasketDto create(@Valid AddInBasketDto inBasketDto) throws Exception {
		var addBasket = basketMapper.toEntity(inBasketDto);
		return basketMapper.toDto(basketRepository.save(addBasket));
	}

	@Override
	public AddInBasketDto update(@Valid AddInBasketDto inBasketDto, Integer id) throws Exception {
		var basketAdd = basketMapper.toEntity(inBasketDto);
		var result = basketMapper.toUpdate(inBasketDto, basketAdd);
		return basketMapper.toDto(basketRepository.save(result));
	}

	@Override
	public void delete(Integer dId, Integer categoryId,Integer custId) throws Exception {
		basketRepository.delete(dId, categoryId , custId);

	}

}
