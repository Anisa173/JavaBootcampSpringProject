package com.project.demo.sushiCo.service;

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

}
