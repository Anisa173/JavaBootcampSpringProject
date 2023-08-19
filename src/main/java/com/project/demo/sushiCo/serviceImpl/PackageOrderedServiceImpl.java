package com.project.demo.sushiCo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.ShippingPackageOrderFormDto;
import com.project.demo.sushiCo.domain.mappers.PackagedOrderedMapper;
import com.project.demo.sushiCo.domain.mappers.ShippingPackageOrderFormMapper;
import com.project.demo.sushiCo.repository.PackagedOrderedRepository;
import com.project.demo.sushiCo.service.PackageOrderedService;
import com.project.demo.sushiCo.service.ShippingPackageOrderForm;
import jakarta.validation.Valid;

@Service
public class PackageOrderedServiceImpl implements PackageOrderedService {
	@Autowired
	private final PackagedOrderedRepository packageOrRepository;
	private final PackagedOrderedMapper packageOrMapper;
	private final ShippingPackageOrderFormMapper packageOrderFMapper;

	public PackageOrderedServiceImpl(PackagedOrderedRepository packageOrRepository,
			PackagedOrderedMapper packageOrMapper, ShippingPackageOrderFormMapper packageOrderFMapper) {
		this.packageOrRepository = packageOrRepository;
		this.packageOrMapper = packageOrMapper;
		this.packageOrderFMapper = packageOrderFMapper;
	}

	@Override
	public PackageOrderedDto register(@Valid ShippingPackageOrderForm packageForm) throws Exception {
		var packOrdert = getPackageOrderById(packageForm.getId(), packageForm.getIdShporta(),
				packageForm.getAdminRestId(), packageForm.getIdCustomer(), packageForm.getShippersId());
		packOrdert.setCustomerName(packageForm.getCustomerName());
		packOrdert.setShippersName(packageForm.getShippersName());
		packOrdert.setCustomerAddress(packageForm.getCustomerAddress());
		packOrdert.setNoPhoneCustomer(packageForm.getNoPhoneCustomer());
		packOrdert.setOrders(packageForm.getOrders());

		return packageOrMapper.toDto(packageOrRepository.save(packOrdert));
	}

	@Override
	public ShippingPackageOrderFormDto create(@Valid PackageOrderedDto packOrderedDto) throws Exception {
		return packageOrderFMapper.toDto(packageOrRepository.create(packOrderedDto));
	}

	@Override
	public ShippingPackageOrderFormDto getPackageOrderById(Integer adminRestId, Integer idCustomer, Integer shipperId,
			Integer serviceId, Integer idShporta) {
		return packageOrderFMapper.toDto(
				packageOrRepository.getPackageOrderById(adminRestId, idCustomer, shipperId, serviceId, idShporta));
	}

}
