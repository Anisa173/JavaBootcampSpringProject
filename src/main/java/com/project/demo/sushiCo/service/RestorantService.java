package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;

import jakarta.validation.Valid;

public interface RestorantService {

	public RestorantDto registerRestorant(@Valid RegisterRestorantForm registerForm) throws Exception;

	public RestorantDto create(@Valid RestorantDto restorantDto) throws Exception;

	public void delete(Integer idRestorant, Integer adminIdWeb) throws Exception;

	public List<RestorantDto> getAllRestorants(Integer adminIdWeb) throws Exception;

	public  SelectWhichYouPreferFormDto selectRestorantByVisitor(@Valid SelectWhichYouPreferForm restorantPreference)
			throws Exception;

	public SelectWhichYouPreferFormDto getCustomerRestorantById(Integer userId, Integer idRestorant) throws Exception;

    public SelectWhichYouPreferFormDto getRestorantById1(Integer idRestorant) throws Exception;
	
	public RestorantDto getRestorantsById(Integer idRestorant,Integer adminIdWeb) throws Exception;

	public RestorantDto update(@Valid RestorantDto restorantDto,@Valid RestorantDto restForm, Integer id, Integer adminIdWeb) throws Exception;

	public  SelectWhichYouPreferFormDto selectRestorantByCustomer(@Valid SelectWhichYouPreferForm restorantPreference) throws Exception;

    public RestorantDto getRestorantDetails(Integer idRestorant) throws Exception;

	public SelectWhichYouPreferFormDto updateRprefered(@Valid SelectWhichYouPreferFormDto restorantSelected1, Integer idSelect) throws Exception;

	

	
	

	

    





}

