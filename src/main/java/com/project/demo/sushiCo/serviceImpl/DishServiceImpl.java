package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.service.DishService;
import jakarta.validation.Valid;


@Service
public class DishServiceImpl implements DishService{

	public DishServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DishDto register(@Valid RegisterUserForm form) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

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
