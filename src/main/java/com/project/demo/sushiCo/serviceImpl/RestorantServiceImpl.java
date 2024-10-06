package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.domain.mappers.RestorantMapper;
import com.project.demo.sushiCo.domain.mappers.SelectWhichYouPreferMapper;
import com.project.demo.sushiCo.entity.Restorant;
import com.project.demo.sushiCo.repository.RestorantRepository;
import com.project.demo.sushiCo.service.RegisterRestorantForm;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;

import jakarta.validation.Valid;

@Validated
@Service
public class RestorantServiceImpl implements RestorantService {

	@Autowired
	private final RestorantRepository restorantRepository;
	@Autowired
	private final RestorantMapper restorantMapper;
	@Autowired
	private final SelectWhichYouPreferMapper selectWhichYouPreferMapper;

	public RestorantServiceImpl(RestorantRepository restorantRepository, RestorantMapper restorantMapper,
			SelectWhichYouPreferMapper selectWhichYouPreferMapper) {
		this.restorantRepository = restorantRepository;
		this.restorantMapper = restorantMapper;
		this.selectWhichYouPreferMapper = selectWhichYouPreferMapper;
	}

	@Override
	public RestorantDto registerRestorant(@Valid RegisterRestorantForm registerForm) throws Exception {
		var restorant = getRestorantsById(registerForm.getId());
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
	public RestorantDto getRestorantsById(Integer idRestorant) throws Exception {
		return restorantMapper.toDto(restorantRepository.getRestorantsById(idRestorant));
	}

	@Override
	public RestorantDto create(@Valid RestorantDto restorantDto) throws Exception {
		var result = restorantMapper.toEntity(restorantDto);
		return restorantMapper.toDto(restorantRepository.save(result));

	}

	@Override
	public List<RestorantDto> getAllRestorants(Integer adminIdWeb) throws Exception {
		return restorantRepository.findAll().stream().map(a -> restorantMapper.toDto(a)).collect(Collectors.toList());
	}

	@Override
	public RestorantDto update(@Valid RestorantDto restorantDto, @Valid RestorantDto restForm, Integer id)
			throws Exception {

		Restorant restorant = restorantMapper.toEntity(getRestorantsById(id));
		var result = restorantMapper.toUpdate(restorantDto, restorant);
		return restorantMapper.toDto(restorantRepository.save(result));
	}

	@Override
	public void delete(Integer idRestorant, Integer adminIdWeb) throws Exception {
		restorantRepository.delete(idRestorant, adminIdWeb);

	}

	@Override
	public SelectWhichYouPreferFormDto selectRestorantByCustomer(@Valid SelectWhichYouPreferForm restorantPreference)
			throws Exception {
		var restorantSelect = getCustomerRestorantById(restorantPreference.getUserId(),
				restorantPreference.getIdRestorant());
		restorantSelect.setRest(restorantPreference.getRest());
		return selectWhichYouPreferMapper.toDto(restorantRepository.save(restorantSelect));
	}

	@Override
	public SelectWhichYouPreferFormDto getCustomerRestorantById(Integer userId, Integer idRestorant) throws Exception {
		return selectWhichYouPreferMapper.toDto(restorantRepository.getCustomerRestorantById(userId, idRestorant));
	}

	@Override
	public SelectWhichYouPreferFormDto selectRestorantByVisitor(@Valid SelectWhichYouPreferForm restorantPreference)
			throws Exception {
		var restorantSelect = getRestorantById1(restorantPreference.getId());
		restorantSelect.setRest(restorantPreference.getRest());
		return selectWhichYouPreferMapper.toDto(restorantRepository.save(restorantSelect));
	}

	@Override
	public SelectWhichYouPreferFormDto getRestorantById1(Integer idRestorant) throws Exception {

		return selectWhichYouPreferMapper.toDto(restorantRepository.getRestorantById1(idRestorant));
	}

	@Override
	public SelectWhichYouPreferFormDto selectRestorant(@Valid SelectWhichYouPreferFormDto selectRPreference)
			throws Exception {
		return selectWhichYouPreferMapper.toDto(restorantRepository.selectRestorant(selectRPreference));
	}

	@Override
	public SelectWhichYouPreferFormDto updateRprefered(@Valid SelectWhichYouPreferFormDto selectRPreference,
			@Valid SelectWhichYouPreferFormDto restorantSelected, Integer idSelect) throws Exception {

		return selectWhichYouPreferMapper.toDto(restorantRepository.updateRprefered(selectRPreference, idSelect));
	}

	@Override
	public RestorantDto getRestorantDetails(Integer idRestorant) throws Exception {

		return restorantMapper.toDto(restorantRepository.getRestorantDetails(idRestorant));
	}

}
