package com.project.demo.sushiCo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.domain.mappers.AddInBasketMapper;
import com.project.demo.sushiCo.repository.AddInBasketRepository;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.SelectDishesForm;
import jakarta.validation.Valid;

@Service
public class AddInBasketServiceImpl implements AddInBasketService {
	@Autowired
	private final AddInBasketRepository basketRepository;
	private final AddInBasketMapper basketMapper;

	public AddInBasketServiceImpl(AddInBasketRepository basketRepository, AddInBasketMapper basketMapper) {
		this.basketRepository = basketRepository;
		this.basketMapper = basketMapper;
	}

	@Override
	public AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm) throws Exception {
		var basketAdd = getDishDCategoriesByCustomerId(selectForm.getDId(), selectForm.getCategoryId(),
				selectForm.getCustomerId());
		basketAdd.setCategoryName(selectForm.getCategoryName());
		basketAdd.setDishName(selectForm.getDishName());
		basketAdd.setDishPrize(selectForm.getDishPrize());
		basketAdd.setDishDescription(selectForm.getDishDescription());
		basketAdd.setNoItems(selectForm.getNoItems());
		return basketMapper.toDto(basketRepository.save(basketAdd));
	}

	@Override
	public SelectDishesFormDto getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId) throws Exception {
		return basketRepository.getDishesByCustomerId(dId, categoryId, custId);
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
	public SelectDishesFormDto getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer customerId)
			throws Exception {

		return basketRepository.getDishDCategoriesByCustomerId(dId, categoryId, customerId);
	}

	@Override
	public void delete(Integer dId, Integer id) throws Exception {
		basketRepository.delete(dId, id);
		
	}

}
