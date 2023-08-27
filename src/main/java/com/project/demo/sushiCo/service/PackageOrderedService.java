package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import jakarta.validation.Valid;

public interface PackageOrderedService {

	public PackageOrderedDto register(@Valid TransportingPackageOrderForm packageForm) throws Exception;

	public TransportingPackageOrderFormDto create(@Valid TransportingPackageOrderFormDto shippingPackOrder)
			throws Exception;

	public TransportingPackageOrderFormDto updateByStatus(@Valid TransportingPackageOrderFormDto shippingPackOrder,
			@Valid TransportingPackageOrderFormDto shippingPackOrder2, Integer Id, Integer userId, Integer serviceId, Integer oId) throws Exception;

	// public TransportingPackageOrderFormDto update(@Valid PackageOrderedDto
	// packOrDto, Integer Id,Integer serviceId, Integer oId, Integer userId) throws
	// Exception;

	// Kur adminiRest kancelon packO
	public void delete(Integer id, Integer oId, Integer adminRestId) throws Exception;

	public TransportingPackageOrderFormDto getPackageOrderById(Integer userId, Integer serviceId, Integer idShporta);

	TransportingPackageOrderFormDto update(@Valid TransportingPackageOrderFormDto packOrDto,
			@Valid TransportingPackageOrderFormDto shippingPackOrder, Integer Id, Integer serviceId, Integer oId,
			Integer userId) throws Exception;

	// Shportat e porosise se Transportuesit
	List<PackageOrderedDto> getAllPackageOByshipperId(Integer userId) throws Exception;


}
