package com.project.demo.sushiCo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import com.project.demo.sushiCo.domain.mappers.PackagedOrderedMapper;
import com.project.demo.sushiCo.domain.mappers.TransportingPackageOrderFormMapper;
import com.project.demo.sushiCo.repository.PackagedOrderedRepository;
import com.project.demo.sushiCo.service.PackageOrderedService;
import com.project.demo.sushiCo.service.TransportingPackageOrderForm;
import jakarta.validation.Valid;

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
		var packOrdert = getPackageOrderById(packageForm.getId(), packageForm.getIdPackageOrder(),
				packageForm.getAdminRestId(), packageForm.getIdCustomer(), packageForm.getShippersId());
		packOrdert.setCustomerName_Surname(packageForm.getCustomerName_Surname());
		packOrdert.setShippersName_Surname(packageForm.getShippersName_Surname());
		packOrdert.setCustomerAddress(packageForm.getCustomerAddress());
		packOrdert.setNoPhoneCustomer(packageForm.getNoPhoneCustomer());
		packOrdert.setOrders(packageForm.getOrders());

		return packageOrMapper.toDto(packageOrRepository.save(packOrdert));
	}

	@Override
	public TransportingPackageOrderFormDto create(@Valid PackageOrderedDto packOrderedDto) throws Exception {
		return packageOrderFMapper.toDto(packageOrRepository.create(packOrderedDto));
	}

	@Override
	public TransportingPackageOrderFormDto getPackageOrderById(Integer adminRestId, Integer idCustomer,
			Integer shipperId, Integer serviceId, Integer idShporta) {
		return packageOrderFMapper.toDto(
				packageOrRepository.getPackageOrderById(adminRestId, idCustomer, shipperId, serviceId, idShporta));
	}

	@Override
	public TransportingPackageOrderFormDto updateByStatus(@Valid PackageOrderedDto packOrderedDto, Integer Id,
			Integer shippersId, Integer serviceId, Integer oId, Integer idCustomer) throws Exception {

		return packageOrderFMapper
				.toDto(packageOrRepository.updateByStatus(packOrderedDto, Id, shippersId, serviceId, oId, idCustomer));
	}

	@Override
	public TransportingPackageOrderFormDto update(@Valid PackageOrderedDto packOrDto, Integer Id, Integer shippersId,
			Integer serviceId, Integer oId, Integer idCustomer) throws Exception {

		return packageOrderFMapper
				.toDto(packageOrRepository.update(packOrDto, Id, shippersId, serviceId, oId, idCustomer));
	}

}
