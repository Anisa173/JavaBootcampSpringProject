package com.project.demo.sushiCo.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.sushiCo.entity.Order;

public class TransportingPackageOrderFormDto {
	private Integer registrationId;
	private String customerName_Surname;
	private String shippersName_Surname;
	private String customerAddress;
	private List<Order> orders = new ArrayList<Order>();
	private List<String> servicePl = new ArrayList<String>();
	private String noPhoneCustomer;
	private Double sessionPayment;

	public TransportingPackageOrderFormDto() {

	}

	public TransportingPackageOrderFormDto(Integer registrationId, String customerName, String shippersName,
			String customerAddress, List<Order> orders, List<String> servicePl, String noPhoneCustomer,
			Double sessionPayment) {
		this.registrationId = registrationId;
		this.customerName_Surname = customerName;
		this.shippersName_Surname = shippersName;
		this.customerAddress = customerAddress;
		this.noPhoneCustomer = noPhoneCustomer;
		this.orders = orders;
		this.servicePl = servicePl;
		this.sessionPayment = sessionPayment;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getCustomerName_Surname() {
		return customerName_Surname;
	}

	public void setCustomerName_Surname(String customerName) {
		this.customerName_Surname = customerName;
	}

	public String getShippersName_Surname() {
		return shippersName_Surname;
	}

	public void setShippersName_Surname(String shippersName) {
		this.shippersName_Surname = shippersName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<String> getServicePl() {
		return servicePl;
	}

	public void setServicePl(List<String> servicePl) {
		this.servicePl = servicePl;
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
		return "TransportingPackageOrderFormDto[registrationId = " + registrationId + ",customerName = "
				+ customerName_Surname + ",shippersName = " + shippersName_Surname + ",customerAddress = "
				+ customerAddress + ",noPhoneCustomer = " + noPhoneCustomer + ",orders = " + orders + ",servicePl = "
				+ servicePl + ",noPhoneCustomer = " + noPhoneCustomer + " ,sessionPayment = " + sessionPayment + "]";
	}

}
