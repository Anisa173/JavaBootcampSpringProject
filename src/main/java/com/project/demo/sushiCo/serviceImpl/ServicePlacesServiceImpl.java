package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.domain.mappers.ServicePlacesMapper;
import com.project.demo.sushiCo.entity.ServicePlaces;
import com.project.demo.sushiCo.repository.ServicePlacesRepository;
import com.project.demo.sushiCo.service.RegisterRegisterPlacesForm;
import com.project.demo.sushiCo.service.ServicePlacesService;

import groovy.util.ResourceException;
import jakarta.validation.Valid;

@Service
public class ServicePlacesServiceImpl implements ServicePlacesService {
	@Autowired
	private final ServicePlacesRepository servicePlacesRepository;
	private final ServicePlacesMapper servicePlacesMapper;

	ServicePlacesServiceImpl(ServicePlacesRepository servicePlacesRepository, ServicePlacesMapper servicePlacesMapper) {
		this.servicePlacesRepository = servicePlacesRepository;
		this.servicePlacesMapper = servicePlacesMapper;
	}

	@Override
	public void delete(Integer Id) throws Exception {
		servicePlacesRepository.deleteById(Id);
	}

	@Override
	public ServicePlacesDto getService_PlacesById(Integer Id) throws Exception {

		return servicePlacesMapper.toDto(servicePlacesRepository.findById(Id)
				.orElseThrow(() -> new ResourceException(String.format("ServicePlace does not exist!", Id))));
	}

	@Override
	public List<ServicePlacesDto> getAllService_Places() throws Exception {
		return servicePlacesRepository.findAll().stream().map(m -> servicePlacesMapper.toDto(m))
				.collect(Collectors.toList());
	}

	@Override
	public ServicePlacesDto create(@Valid ServicePlacesDto placesDto) throws Exception {
		var result = servicePlacesMapper.toEntity(placesDto);
		return servicePlacesMapper.toDto(servicePlacesRepository.save(result));
	}

	@Override
	public ServicePlacesDto update(Integer Id, @Valid ServicePlacesDto placesDto) throws Exception {
		ServicePlaces servicePlaces = servicePlacesMapper.toEntity(getService_PlacesById(Id));
		var result = servicePlacesMapper.toUpdate(placesDto, servicePlaces);
		return servicePlacesMapper.toDto(servicePlacesRepository.save(result));

	}

	@Override
	public ServicePlacesDto registerPlaces(@Valid RegisterRegisterPlacesForm registerForm) throws Exception {
		var serviceP = getService_PlacesById(registerForm.getId());
		serviceP.setService_Places(registerForm.getServicesPlaces());
		serviceP.setShippingCost(registerForm.getShippingCost());
		return servicePlacesMapper.toDto(servicePlacesRepository.save(serviceP));
	}

	@Override
	public ServicePlacesDto getRestorantPServices(Integer custId, Integer restorantId) throws Exception {
		
		return servicePlacesMapper.toDto(servicePlacesRepository.getRestorantPServices(custId, restorantId));
	}
}
