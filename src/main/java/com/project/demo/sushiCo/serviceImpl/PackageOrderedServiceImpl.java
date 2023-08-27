package com.project.demo.sushiCo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import com.project.demo.sushiCo.domain.mappers.PackagedOrderedMapper;
import com.project.demo.sushiCo.domain.mappers.TransportingPackageOrderFormMapper;
import com.project.demo.sushiCo.repository.PackagedOrderedRepository;
import com.project.demo.sushiCo.service.PackageOrderedService;
import com.project.demo.sushiCo.service.TransportingPackageOrderForm;
import jakarta.validation.Valid;

@Validated
@Service
public class PackageOrderedServiceImpl implements PackageOrderedService {
	@Autowired
	private final PackagedOrderedRepository packageOrRepository;
	private final PackagedOrderedMapper packageOrMapper;
	private final TransportingPackageOrderFormMapper packageOrderFMapper;

	public PackageOrderedServiceImpl(PackagedOrderedRepository packageOrRepository,
			PackagedOrderedMapper packageOrMapper, TransportingPackageOrderFormMapper packageOrderFMapper) {
		this.packageOrRepository = packageOrRepository;
		this.packageOrMapper = packageOrMapper;
		this.packageOrderFMapper = packageOrderFMapper;
	}

	@Override
	public PackageOrderedDto register(@Valid TransportingPackageOrderForm packageForm) throws Exception {
		var packOrdert = getPackageOrderById(packageForm.getIdShporta(), packageForm.getUserId(),
				packageForm.getServiceId());
		packOrdert.setCustomerName_Surname(packageForm.getCustomerName_Surname());
		packOrdert.setShippersName_Surname(packageForm.getShippersName_Surname());
		packOrdert.setCustomerAddress(packageForm.getCustomerAddress());
		packOrdert.setNoPhoneCustomer(packageForm.getNoPhoneCustomer());
		packOrdert.setOrders(packageForm.getOrders());

		return packageOrMapper.toDto(packageOrRepository.save(packOrdert));
	}

	@Override
	public TransportingPackageOrderFormDto create(@Valid TransportingPackageOrderFormDto shippingPackOrder)
			throws Exception {
		return packageOrderFMapper.toDto(packageOrRepository.create(shippingPackOrder));
	}

	@Override
	public TransportingPackageOrderFormDto getPackageOrderById(Integer userId, Integer serviceId, Integer idShporta) {
		return packageOrderFMapper.toDto(packageOrRepository.getPackageOrderById(userId, serviceId, idShporta));

	}

	@Override
	public TransportingPackageOrderFormDto updateByStatus(@Valid TransportingPackageOrderFormDto packOrderedDto,@Valid TransportingPackageOrderFormDto shippingPackOrder2 , Integer Id,
			Integer serviceId, Integer oId, Integer userId) throws Exception {

		return packageOrderFMapper
				.toDto(packageOrRepository.updateByStatus(packOrderedDto, Id, serviceId, oId, userId));
	}

	@Override
	public TransportingPackageOrderFormDto update(@Valid TransportingPackageOrderFormDto packOrDto,
			@Valid TransportingPackageOrderFormDto shippingPackOrder, Integer idShporta, Integer serviceId, Integer oId,
			Integer userId) throws Exception {

		return packageOrderFMapper.toDto(packageOrRepository.update(packOrDto, idShporta, serviceId, oId, userId));
	}

	@Override
	public void delete(Integer id, Integer oId, Integer adminRestId) throws Exception {

		packageOrRepository.delete(id, oId, adminRestId);
	}
@Override
	public List<TransportingPackageOrderFormDto> getAllPackageOByCustomerId(Integer userId) throws Exception {

		return packageOrderFMapper
				.toDto(packageOrRepository.getAllPackageOByCustomerId(userId));
	}

@Override
public List<TransportingPackageOrderFormDto> getAllPackageOByshipperId(Integer userId) throws Exception {
	
	return packageOrderFMapper
			.toDto((packageOrRepository).getAllPackageOByshipperId(userId)) ;
}

@Override
public List<TransportingPackageOrderFormDto> getPackageOrdersByServiceP(Integer Id) throws Exception {
	
	return packageOrderFMapper.toDto(packageOrRepository.getPackageOrdersByServiceP(Id));
}

}
