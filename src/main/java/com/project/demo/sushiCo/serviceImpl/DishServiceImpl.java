package com.project.demo.sushiCo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.domain.mappers.DishMapper;
import com.project.demo.sushiCo.repository.DishRepository;
import com.project.demo.sushiCo.service.DishService;
import jakarta.validation.Valid;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private final DishRepository dishRepository;
	private final DishMapper dishMapper;

	public DishServiceImpl(DishRepository dishRepository, DishMapper dishMapper) {
		this.dishRepository = dishRepository;
		this.dishMapper = dishMapper;
	}

	@Override
	public void delete(Integer id) throws Exception {
		dishRepository.deleteById(id);
	}

	@Override
	public DishDto register(@Valid RegisterUserForm form) throws Exception {
		
		return null;
	}

/*private String dishName;
	@Column(name = "dishPrize")
	private Double dishPrize;
	@Column(name = "dishDescrition")
	private String dishDescription;*/
	
	@Override
	public DishDto create(@Valid DishDto dishDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DishDto update(@Valid DishDto dishDto, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DishDto> getDishes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DishDto getDishById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
