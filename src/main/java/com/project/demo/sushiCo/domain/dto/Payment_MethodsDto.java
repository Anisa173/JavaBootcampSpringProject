package com.project.demo.sushiCo.domain.dto;

import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Payment_MethodsDto {
	private Integer Id;
	@NotNull(message = "It can not be null,it's optional")
	private String payment_Methods;
	private Long totalOrders;
	private Integer paymentIdApp;
	private String restName;

	public Payment_MethodsDto() {

	}

	public Payment_MethodsDto(Integer Id, String payment_Methods, Long totalOrders, Integer paymentIdApp,
			String restName) {
		this.Id = Id;
		this.payment_Methods = payment_Methods;
		this.setTotalOrders(totalOrders);
		this.setPaymentIdApp(paymentIdApp);
		this.setRestName(restName);
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPayment_Methods() {
		return payment_Methods;
	}

	public void setPayment_Methods(String payment_Methods) {
		this.payment_Methods = payment_Methods;
	}

	public Long getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}

	public Integer getPaymentIdApp() {
		return paymentIdApp;
	}

	public void setPaymentIdApp(Integer paymentIdApp) {
		this.paymentIdApp = paymentIdApp;
	}

public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}


	public String toString() {
		return "Payment_MethodsDto[Id = " + Id + ",payment_Methods = " + payment_Methods + ",totalOrders = "
				+ totalOrders + ",paymentIdApp = " + paymentIdApp + ",restName = " + restName + "]";

	}

	
}
