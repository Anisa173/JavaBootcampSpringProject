package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import jakarta.validation.Valid;

public interface PackageOrderedService {

	public PackageOrderedDto register(@Valid TransportingPackageOrderForm packageForm) throws Exception;

	public TransportingPackageOrderFormDto getPackageOrderById(Integer adminRestId, Integer idCustomer,
			Integer shipperId, Integer serviceId, Integer idShporta);

	public TransportingPackageOrderFormDto create(@Valid PackageOrderedDto packOrderedDto) throws Exception;

	public TransportingPackageOrderFormDto updateByStatus(@Valid PackageOrderedDto packOrderedDto, Integer Id,
			Integer shippersId, Integer serviceId, Integer oId, Integer idCustomer) throws Exception;

	public TransportingPackageOrderFormDto update(@Valid PackageOrderedDto packOrDto, Integer Id, Integer shippersId,
			Integer serviceId, Integer oId, Integer idCustomer) throws Exception;

	//Kur adminiRest kancelon packO
    public void delete(Integer id, Integer oId, Integer adminRestId) throws Exception;
  
    //Shportat e porosise se Transportuesit 
	public List<PackageOrderedDto> getAllPackageOByshipperId(Integer shippersId, Integer adminRestId, Integer idCustomer)
			throws Exception;
}
