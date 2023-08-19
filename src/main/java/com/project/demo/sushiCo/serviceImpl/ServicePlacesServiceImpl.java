package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.domain.mappers.ServicePlacesMapper;
import com.project.demo.sushiCo.entity.ServicePlaces;
import com.project.demo.sushiCo.repository.ServicePlacesRepository;
import com.project.demo.sushiCo.service.RegisterRegisterPlacesForm;
import com.project.demo.sushiCo.service.ServicePlacesService;
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
	public void delete(Integer Id,Integer idRestorant) throws Exception {
		servicePlacesRepository.delete(Id,idRestorant);
	}

	@Override
	public ServicePlacesDto getService_PlacesById(Integer Id,Integer idRestorant) throws Exception {
		return servicePlacesMapper.toDto(servicePlacesRepository.getService_PlacesById(Id,idRestorant));
	}

	@Override
	public ServicePlacesDto create(@Valid ServicePlacesDto placesDto) throws Exception {
		var result = servicePlacesMapper.toEntity(placesDto);
		return servicePlacesMapper.toDto(servicePlacesRepository.save(result));
	}
    @Override
	public ServicePlacesDto update(Integer Id,Integer idRestorant, @Valid ServicePlacesDto placesDto) throws Exception {
		ServicePlaces servicePlaces = servicePlacesMapper.toEntity(getService_PlacesById(Id,idRestorant));
		var result = servicePlacesMapper.toUpdate(placesDto, servicePlaces);
		return servicePlacesMapper.toDto(servicePlacesRepository.save(result));

	}

	@Override
	public ServicePlacesDto registerPlaces(@Valid RegisterRegisterPlacesForm registerForm) throws Exception {
		var serviceP = getService_PlacesById(registerForm.getId(),registerForm.getIdRestorant());
		serviceP.setService_Places(registerForm.getServicesPlaces());
		serviceP.setShippingCost(registerForm.getShippingCost());
		return servicePlacesMapper.toDto(servicePlacesRepository.save(serviceP));
	}

	@Override
	public List<ServicePlacesDto> getRestorantPServices(Integer restorantId) throws Exception {
		
		return servicePlacesMapper.toDto(servicePlacesRepository.getRestorantPServices(restorantId));
	}	
}
