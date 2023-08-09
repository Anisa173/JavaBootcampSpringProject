package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import com.project.demo.sushiCo.domain.mappers.PaymentMethodsMapper;
import com.project.demo.sushiCo.repository.PaymentMethodsRepository;
import com.project.demo.sushiCo.service.PaymentMethodsService;
import com.project.demo.sushiCo.service.RegisterMethodsPaymentForm;
import jakarta.validation.Valid;

@Service
public class PaymentMethodsServiceImpl implements PaymentMethodsService {

	@Autowired
	private final PaymentMethodsRepository methodsRepository;
	private final PaymentMethodsMapper methodsMapper;

	public PaymentMethodsServiceImpl(PaymentMethodsRepository methodsRepository, PaymentMethodsMapper methodsMapper) {
		this.methodsRepository = methodsRepository;
		this.methodsMapper = methodsMapper;
	}

	@Override
	public void delete(Integer id) throws Exception {
		methodsRepository.deleteById(id);
	}

	@Override
	public PaymentMethodsDto getPayment_MethodsById(Integer Id) throws Exception {
		return methodsMapper.toDto(methodsRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException(String.format("Payment_Method does not exist!", Id))));
	}

	@Override
	public List<PaymentMethodsDto> getAllPayment_Methods() throws Exception {

		return methodsRepository.findAll().stream().map(c -> methodsMapper.toDto(c)).collect(Collectors.toList());
	}

	@Override
	public PaymentMethodsDto registerMethod_Payment(@Valid RegisterMethodsPaymentForm form) throws Exception {
		var payment = getPayment_MethodsById(form.getId());
		payment.setPayment_Method(form.getPayment_Method());
		return methodsMapper.toDto(methodsRepository.save(payment));
	}

	@Override
	public PaymentMethodsDto create(@Valid PaymentMethodsDto methodsDto) throws Exception {
		var result = methodsMapper.toEntity(methodsDto);
		return methodsMapper.toDto(methodsRepository.save(result));
	}

	@Override
	public PaymentMethodsDto update(Integer Id, @Valid PaymentMethodsDto placesDto) throws Exception {
		var pMethod = methodsMapper.toEntity(getPayment_MethodsById(Id));
		var result = methodsMapper.toUpdate(placesDto, pMethod);
		return methodsMapper.toDto(methodsRepository.save(result));
	}

}
