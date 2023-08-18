package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.Order;

public class ShippingPackageOrderFormDto {
	private Integer registrationId;
	private String customerName;
	private String shippersName;
	private String customerAddress;
	private Order orders;
	private String noPhoneCustomer;
	private Double sessionPayment;

	public ShippingPackageOrderFormDto() {

	}

	public ShippingPackageOrderFormDto(Integer registrationId, String customerName, String shippersName,
			String customerAddress, Order orders, Double sessionPayment) {
		this.registrationId = registrationId;
		this.customerName = customerName;
		this.shippersName = shippersName;
		this.customerAddress = customerAddress;
		this.orders = orders;
		this.sessionPayment = sessionPayment;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippersName() {
		return shippersName;
	}

	public void setShippersName(String shippersName) {
		this.shippersName = shippersName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public String getNoPhoneCustomer() {
		return noPhoneCustomer;
	}

	public void setNoPhoneCustomer(String noPhoneCustomer) {
		this.noPhoneCustomer = noPhoneCustomer;
	}

	public Double getSessionPayment() {
		return sessionPayment;
	}

	public void setSessionPayment(Double sessionPayment) {
		this.sessionPayment = sessionPayment;
	}

	public String toString() {
		return "ShippingPackageOrderFormDto[registrationId = " + registrationId + ",customerName = " + customerName
				+ ",shippersName = " + shippersName + ",customerAddress = " + customerAddress + ",orders = " + orders
				+ ",noPhoneCustomer = " + noPhoneCustomer + " ,sessionPayment = " + sessionPayment + "]";
	}

}
