package com.project.demo.sushiCo.domain.dto;

import jakarta.validation.constraints.NotNull;

public class Payment_MethodsDto {
	private Integer Id;
	@NotNull(message = "It can not be null,it's optional")
	private String payment_Methods;
	private Long totalOrders;
	private String paymentIdApp;
	private String appName;

	public Payment_MethodsDto() {

	}

	public Payment_MethodsDto(Integer Id, String payment_Methods, Long totalOrders, String paymentIdApp,
			String appName) {
		this.Id = Id;
		this.payment_Methods = payment_Methods;
		this.setTotalOrders(totalOrders);
		this.setPaymentIdApp(paymentIdApp);
		this.setAppName(appName);
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

	public String getPaymentIdApp() {
		return paymentIdApp;
	}

	public void setPaymentIdApp(String paymentIdApp) {
		this.paymentIdApp = paymentIdApp;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String toString() {
		return "Payment_MethodsDto[Id = " + Id + ",payment_Methods = " + payment_Methods + ",totalOrders = "
				+ totalOrders + ",paymentIdApp = " + paymentIdApp + ",appName = " + appName + "]";

	}

}
