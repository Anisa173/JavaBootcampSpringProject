package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.ShippingPackageOrderFormDto;
import jakarta.validation.Valid;

public interface PackageOrderedService {

public PackageOrderedDto register(@Valid ShippingPackageOrderForm packageForm ) throws Exception;
public ShippingPackageOrderFormDto getPackageOrderById(Integer adminRestId, Integer idCustomer, Integer shipperId,
		Integer serviceId, Integer idShporta);
ShippingPackageOrderFormDto create(@Valid PackageOrderedDto packOrderedDto) throws Exception;
	

}
