package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;

import jakarta.validation.Valid;

public interface RestorantService {

public	RestorantDto registerRestorant(@Valid RegisterRestorantForm registerForm) throws Exception;

public	RestorantDto create(@Valid RestorantDto restorantDto) throws Exception;

public	RestorantDto getRestorantsById(Integer idRestorant, Integer adminIdWeb) throws Exception;

public	RestorantDto update(Integer idRestorant, Integer adminIdWeb, @Valid RestorantDto restorantDto) throws Exception;

public	void delete(Integer idRestorant, Integer adminIdWeb) throws Exception;

public	List<RestorantDto> getAllRestorants(Integer adminIdWeb) throws Exception;

public RestorantDto selectRestorant(@Valid SelectWhichYouPreferForm restorantPreference) throws Exception;

public SelectWhichYouPreferFormDto getCustomerRestorantById(Integer id,Integer idRestorant) throws Exception;

}
