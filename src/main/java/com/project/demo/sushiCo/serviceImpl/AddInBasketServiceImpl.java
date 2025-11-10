package com.project.demo.sushiCo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;
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
	@Autowired
	private final AddInBasketMapper basketMapper;
	@Autowired
	private final SelectDishesFormMapper dishFormMapper;
	@Autowired
	private final OrderProcessingMapper orderMapper;
	@Autowired
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
	public AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm) throws Exception {
		var basketAdd = getDishDCategoriesByCustomerId(selectForm.getDId(), selectForm.getCategoryId(),
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
	public AddInBasketDto create(@Valid SelectDishesFormDto inBasketDto) throws Exception {
		var addBasket = dishFormMapper.toEntity(inBasketDto);
		return basketMapper.toDto(basketRepository.save(addBasket));
	}
    @Override
	public AddInBasketDto update(@Valid SelectDishesFormDto selectDishesInBasket, Integer dId, Integer categoryId, Integer customerId)
			throws Exception {
		var basketAdd = dishFormMapper.toEntity(getDishDCategoriesByCustomerId(dId, categoryId, customerId));
		var result = dishFormMapper.toUpdate(selectDishesInBasket, basketAdd);
		return basketMapper.toDto(basketRepository.save(result));
	}

	@Override
	public void delete(@Valid SelectDishesFormDto selectDishesFormDto,
                       Integer custId) throws Exception {
		basketRepository.delete(selectDishesFormDto, custId);
	}

	@Override
	public List<AddInBasketDto> getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId)
			throws Exception {
		return basketMapper.toDto(basketRepository.getDishesByCustomerId(dId, categoryId, custId));
	}

	@Override
	public AddInBasketDto displayPaymentServices(@Valid OrderByProcessing byProcessingform) throws Exception {
		var pmSer = getPaymentServicesCustomById(byProcessingform.getIdcust(), byProcessingform.getIdRestorant(),
				byProcessingform.getPmId(), byProcessingform.getServPId());
		pmSer.setPayments_methodR(byProcessingform.getPayments_methodR());
		pmSer.setService_placesR(byProcessingform.getService_placesR());
		return basketMapper.toDto(basketRepository.save(pmSer));
	}

	@Override
	public OrderByProcessingDto getPaymentServicesCustomById(Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId) throws Exception {
		return orderMapper.toDto(basketRepository.getPaymentServicesCustomById(custId, idRestorant, pmId, servPId));
	}

	@Override
	public RegisterCardBankDto getCardsByCustomerId(Integer registrationId, Integer custId, Integer idRestorant,
			Integer pmId, Integer servPId) {
		return cardFormMapper
				.toDto(basketRepository.getCardsByCustomerId(registrationId, custId, idRestorant, pmId, servPId));
	}

	@Override
	public AddInBasketDto displayCardForm(@Valid RegisterCardform cardBankForm) throws Exception {
		var cardB = getCardsByCustomerId(cardBankForm.getId(), cardBankForm.getCustId(), cardBankForm.getIdRestorant(),
				cardBankForm.getPmId(), cardBankForm.getServPId());
		cardB.setBankId(cardBankForm.getBankId());
		cardB.setValid_from(cardBankForm.getValid_from());
		cardB.setExpiredTime(cardBankForm.getExpiredTime());
		cardB.setCardSecurityCode(cardBankForm.getCardSecurityCode());
		return basketMapper.toDto(basketRepository.save(cardB));
	}

	
	@Override
	public OrderByProcessingDto createByProcessing(@Valid OrderByProcessingDto processingFormDto) throws Exception {
		var processO = orderMapper.toEntity(processingFormDto);
		return orderMapper.toDto(basketRepository.save(processO));
	}

	@Override
	public OrderByProcessingDto updateByProcessing(@Valid OrderByProcessingDto byProcessingform,
                                                   Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId) throws Exception {
		var processOrder = orderMapper.toEntity(getPaymentServicesCustomById(custId, idRestorant, pmId, servPId));
		var result = orderMapper.toUpdate(byProcessingform, processOrder);
		return orderMapper.toDto(basketRepository.save(result));
	}

	@Override
	public RegisterCardBankDto createOrderPaymentDetails(@Valid RegisterCardBankDto regCardForm) throws Exception {
		var paymentCard = cardFormMapper.toEntity(regCardForm);
		return cardFormMapper.toDto(basketRepository.save(paymentCard));
	}

	@Override
	public void deleteCardPaymentDetails(@Valid RegisterCardBankDto regCardBank, Integer custId, Integer idRestorant,
			Integer pmId, Integer servPId, Integer registrationId)
			throws Exception {

		basketRepository.deleteCardPaymentDetails(regCardBank, registrationId, custId, idRestorant, pmId, servPId);

	}
}
