package com.project.demo.sushiCo.domain.dto;

import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class PaymentMethodsDto {
	private Integer Id;
	@NotNull(message = "It can not be null,it's optional")
	private String payment_Method;
	private Integer orderMethodId;
	private Integer paymentId;
	private String restName;

	public PaymentMethodsDto() {

	}

	public PaymentMethodsDto(Integer Id, String payment_Methods,Integer orderMethodId, Integer paymentId,
			String restName) {
		this.Id = Id;
		this.payment_Method = payment_Methods;
		this.setOrderMethodId(orderMethodId);
		this.setPaymentId(paymentId);
		this.setRestName(restName);
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPayment_Method() {
		return payment_Method;
	}

	public void setPayment_Method(String payment_Methods) {
		this.payment_Method = payment_Methods;
	}

	public Integer getOrderMethodId() {
		return orderMethodId;
	}

	public void setOrderMethodId(Integer orderMethodId) {
		this.orderMethodId = orderMethodId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentIdApp) {
		this.paymentId = paymentIdApp;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String toString() {
		return "PaymentMethodsDto[Id = " + Id + ",payment_Method = " + payment_Method + ",orderMethodId = " + orderMethodId
				+ ",paymentId = " + paymentId + ",restName = " + restName + "]";

	}

	
}
