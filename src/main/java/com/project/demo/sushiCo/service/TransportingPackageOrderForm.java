package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.Order;
import com.project.demo.sushiCo.entity.ServicePlaces;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransportingPackageOrderForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;
	@Column(name = "customerName_Surname")
	private String customerName_Surname;
	@Column(name = "shippersName_Surname")
	private String shippersName_Surname;
	@Column(name = "customerAddress")
	private String customerAddress;
	@Column(name = "noPhoneCustomer")
	private String noPhoneCustomer;
	@Column(name = "orders")
	private Order orders;
	@Column(name = "servicePl")
	private ServicePlaces servicePl;
	@Column(name = "sessionPayment")
	private Double sessionPayment;
	private Integer idShporta;
	private Integer userId;
	private Integer serviceId;

	public TransportingPackageOrderForm() {
		super();
	}

	public TransportingPackageOrderForm(String customerName, String shippersName, String customerAddress,
			String noPhoneCustomer, Order orders, Double sessionPayment, Integer idShporta, Integer serviceId,
			Integer userId, ServicePlaces servicePl) {
		super();
		this.customerName_Surname = customerName;
		this.setShippersName_Surname(shippersName);
		this.setCustomerAddress(customerAddress);
		this.noPhoneCustomer = noPhoneCustomer;
		this.setOrders(orders);
		this.setSessionPayment(sessionPayment);
		this.idShporta = idShporta;
		this.serviceId = serviceId;
		this.userId = userId;
		this.servicePl = servicePl;

	}

	@Override
	public Integer getId() {

		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getCustomerName_Surname() {
		return customerName_Surname;
	}

	public void setCustomerName_Surname(String customerName_Surname) {
		this.customerName_Surname = customerName_Surname;
	}

	public String getShippersName_Surname() {
		return shippersName_Surname;
	}

	public void setShippersName_Surname(String shippersName_Surname) {
		this.shippersName_Surname = shippersName_Surname;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getNoPhoneCustomer() {
		return noPhoneCustomer;
	}

	public void setNoPhoneCustomer(String noPhoneCustomer) {
		this.noPhoneCustomer = noPhoneCustomer;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Double getSessionPayment() {
		return sessionPayment;
	}

	public void setSessionPayment(Double sessionPayment) {
		this.sessionPayment = sessionPayment;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public ServicePlaces getServicePl() {
		return servicePl;
	}

	public void setServicePl(ServicePlaces servicePl) {
		this.servicePl = servicePl;
	}

	public Integer getIdShporta() {
		return idShporta;
	}

	public void setIdShporta(Integer idShporta) {
		this.idShporta = idShporta;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String toString() {
		return "TransportingPackageOrderForm[registrationId = " + registrationId + ", customerName = "
				+ customerName_Surname + ",shippersName = " + shippersName_Surname + ", customerAddress = "
				+ customerAddress + ", noPhoneCustomer = " + noPhoneCustomer + ", orders = " + orders + ",serviceId = "
				+ serviceId + " ,servicePl = " + servicePl + " ,sessionPayment = " + sessionPayment + ",orders = "
				+ orders + ", userId = " + userId + "]";

	}

}
