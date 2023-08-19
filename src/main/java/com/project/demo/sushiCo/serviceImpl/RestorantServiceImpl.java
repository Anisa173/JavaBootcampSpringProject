package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.mappers.RestorantMapper;
import com.project.demo.sushiCo.entity.Restorant;
import com.project.demo.sushiCo.repository.RestorantRepository;
import com.project.demo.sushiCo.service.RegisterRestorantForm;
import com.project.demo.sushiCo.service.RestorantService;
import jakarta.validation.Valid;

public class RestorantServiceImpl implements RestorantService {

	@Autowired
	private final RestorantRepository restorantRepository;
	private final RestorantMapper restorantMapper;

	public RestorantServiceImpl(RestorantRepository restorantRepository, RestorantMapper restorantMapper) {
		this.restorantRepository = restorantRepository;
		this.restorantMapper = restorantMapper;
	}

	@Override
	public RestorantDto registerRestorant(@Valid RegisterRestorantForm registerForm) throws Exception {
		var restorant = getRestorantsById(registerForm.getId(), registerForm.getAdminIdWeb());
		restorant.setRestNUIS(registerForm.getRestNUIS());
		restorant.setRestName(registerForm.getRestName());
		restorant.setPhoneNo(registerForm.getPhoneNo());
		restorant.setActivity_field(registerForm.getActivity_field());
		restorant.setAddressRest(registerForm.getAddressRest());
		restorant.setStartDay(registerForm.getStartDay());
		restorant.setEndDay(registerForm.getEndDay());
		return restorantMapper.toDto(restorantRepository.save(restorant));
	}

	@Override
	public RestorantDto create(@Valid RestorantDto restorantDto) throws Exception {
		var result = restorantMapper.toEntity(restorantDto);
		return restorantMapper.toDto(restorantRepository.save(result));

	}

	@Override
	public RestorantDto getRestorantsById(Integer idRestorant, Integer adminIdWeb) throws Exception {
		return restorantMapper.toDto(restorantRepository.getRestorantsById(idRestorant, adminIdWeb));
	}

	@Override
	public List<RestorantDto> getAllRestorants(Integer adminIdWeb) throws Exception {
		return restorantRepository.findAll().stream().map(a -> restorantMapper.toDto(a)).collect(Collectors.toList());
	}

	@Override
	public RestorantDto update(Integer idRestorant, Integer adminIdWeb, @Valid RestorantDto restorantDto)
			throws Exception {
		Restorant restorant = restorantMapper.toEntity(getRestorantsById(idRestorant, adminIdWeb));
		var result = restorantMapper.toUpdate(restorantDto, restorant);
		return restorantMapper.toDto(restorantRepository.save(result));
	}

	@Override
	public void delete(Integer idRestorant, Integer adminIdWeb) throws Exception {
		restorantRepository.delete(idRestorant, adminIdWeb);

	}
}
