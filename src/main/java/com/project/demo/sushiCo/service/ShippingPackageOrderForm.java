package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShippingPackageOrderForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;
	@Column(name = "customerName")
	private String customerName;
	@Column(name = "shippersName")
	private String shippersName;
	@Column(name = "customerAddress")
	private String customerAddress;
	@Column(name = "noPhoneCustomer")
	private String noPhoneCustomer;
	@Column(name = "orders")
	private Order orders;
	@Column(name = "sessionPayment")
	private Double sessionPayment;
	private Integer idShporta;
	private Integer adminRestId;
	private Integer serviceId;
	private Integer shippersId;
	private Integer idCustomer;

	public ShippingPackageOrderForm() {
		super();
	}

	public ShippingPackageOrderForm(String customerName, String shippersName, String customerAddress,
			String noPhoneCustomer, Order orders, Double sessionPayment, Integer idShporta, Integer adminRestId,
			Integer serviceId, Integer shippersId, Integer idCustomer) {
		super();
		this.setCustomerName(customerName);
		this.setShippersName(shippersName);
		this.setCustomerAddress(customerAddress);
		this.noPhoneCustomer = noPhoneCustomer;
		this.setOrders(orders);
		this.setSessionPayment(sessionPayment);
		this.idShporta = idShporta;
		this.adminRestId = adminRestId;
		this.serviceId = serviceId;
		this.shippersId = shippersId;
		this.idCustomer = idCustomer;

	}

	@Override
	public Integer getId() {

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

	public Integer getIdShporta() {
		return idShporta;
	}

	public void setIdShporta(Integer idShporta) {
		this.idShporta = idShporta;
	}

	public Integer getAdminRestId() {
		return adminRestId;
	}

	public void setAdminRestId(Integer adminRestId) {
		this.adminRestId = adminRestId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getShippersId() {
		return shippersId;
	}

	public void setShippersId(Integer shippersId) {
		this.shippersId = shippersId;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String toString() {
		return "ShippingPackageOrderForm[registrationId = " + registrationId + ",customerName = " + customerName
				+ ",shippersName = " + shippersName + ",customerAddress = " + customerAddress + ",noPhoneCustomer = "
				+ noPhoneCustomer + ",orders = " + orders + ",sessionPayment = " + sessionPayment + "]";

	}

}
