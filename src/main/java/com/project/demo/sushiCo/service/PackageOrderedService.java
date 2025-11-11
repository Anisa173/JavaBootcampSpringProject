package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import jakarta.validation.Valid;

public interface PackageOrderedService {

	public PackageOrderedDto register(@Valid TransportingPackageOrderForm packageForm) throws Exception;

	public TransportingPackageOrderFormDto create(@Valid TransportingPackageOrderFormDto shippingPackOrder)
			throws Exception;

	public TransportingPackageOrderFormDto updateByStatus(@Valid TransportingPackageOrderFormDto packOrderedDto,
                                                          Integer Id, Integer serviceId, Integer oId,
			Integer userId) throws Exception;

	// public TransportingPackageOrderFormDto update(@Valid PackageOrderedDto
	// packOrDto, Integer Id,Integer serviceId, Integer oId, Integer userId) throws
	// Exception;

	// Kur adminiRest kancelon packO
	public void delete(Integer id, Integer oId, Integer adminRestId) throws Exception;

	public TransportingPackageOrderFormDto getPackageOrderById(Integer userId, Integer serviceId, Integer idShporta);

	public TransportingPackageOrderFormDto update(@Valid TransportingPackageOrderFormDto packOrDto,
                                                  Integer idShporta, Integer serviceId, Integer oId,
			Integer userId) throws Exception;

	// Shportat e porosise se Transportuesit per nje klient 
	 public  List<TransportingPackageOrderFormDto> getAllPackageOByCustomerId(Integer userId) throws Exception;
    //Te gjitha shportat e te gjithe klienteve
	 public  List<TransportingPackageOrderFormDto> getAllPackageOByshipperId(Integer userId) throws Exception;
    //Shippersit i duhet te listoje pakot qe duhet te degoje ne nje destinacion te caktuar
     public List<TransportingPackageOrderFormDto> getPackageOrdersByServiceP(Integer Id) throws Exception ;

	

	

	
	
	
}
