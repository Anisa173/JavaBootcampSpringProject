package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.Order;
import com.project.demo.sushiCo.entity.ServicePlaces;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TransportingPackageOrderFormDto {
	private Integer registrationId;
	@NotBlank(message = "firstName_lastName")
	@NotNull(message = " * It's Required! * ")
	@Size(min = 15,max = 55  ,message = "It's at minimum with 15 characters and at maximum with 55 characters")
	private String customerName_Surname;
	@NotBlank(message = "firstName_lastName")
	@NotNull(message = " * It's Required! * ")
	@Size(min = 15,max = 55  ,message = "It's at minimum with 15 characters and at maximum with 55 characters")
	private String shippersName_Surname;
	@NotBlank(message = "ServicePlace/Street/Palace no/ApartmentCategory/Apartment no")
	@NotNull(message = "It's Required")
	private String customerAddress;
	private Order orders ;
	private ServicePlaces servicePl ;
	@NotNull(message = " It's Required! ")
	private String noPhoneCustomer;
	private Double sessionPayment;

	public TransportingPackageOrderFormDto() {

	}

	public TransportingPackageOrderFormDto(Integer registrationId, String customerName, String shippersName,
			String customerAddress, Order orders, ServicePlaces servicePl, String noPhoneCustomer,
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

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public ServicePlaces getServicePl() {
		return servicePl;
	}

	public void setServicePl(ServicePlaces servicePl) {
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
