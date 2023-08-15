package com.project.demo.sushiCo.domain.dto;

import java.time.LocalDateTime;

import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderDto {
	private Integer oId;
	@NotNull(message = "It can't be null")
	private Double orderPrize;
	@NotNull(message = "It can not be null")
	private Integer orderItems;
	@NotNull(message = "It can not be null")
	private String orderStatus;
	@NotNull(message = "It can not be null")
	private LocalDateTime oTimeConfirmed;
	@NotNull(message = "It can not be null")
	private LocalDateTime oTimeProccessed;

	private Long totalP_methods;
	private Integer idShporta;
	private Long totalDish;
	private Integer idCustomer;
	private String customerName;

	public OrderDto() {

	}

	public OrderDto(Integer oId, Double orderPrize, Integer orderItems, String orderStatus,
			LocalDateTime oTimeConfirmed, LocalDateTime oTimeProccessed, Integer idCustomer, String customerName,
			Integer idShporta, Long totalP_methods) {
		this.oId = oId;
		this.orderPrize = orderPrize;
		this.orderItems = orderItems;
		this.orderStatus = orderStatus;
		this.oTimeConfirmed = oTimeConfirmed;
		this.oTimeProccessed = oTimeProccessed;
		this.setIdCustomer(idCustomer);
		this.setCustomerName(customerName);
		this.setIdShporta(idShporta);
		this.totalP_methods = totalP_methods;
	}

	public Integer getOId() {
		return oId;
	}

	public void setOId(Integer oId) {
		this.oId = oId;
	}

	public Double getOrderPrize() {
		return orderPrize;
	}

	public void setOrderPrize(Double orderPrize) {
		this.orderPrize = orderPrize;
	}

	public Integer getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Integer orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOTimeConfirmed() {
		return oTimeConfirmed;
	}

	public void setOTimeConfirmed(LocalDateTime oTimeConfirmed) {
		this.oTimeConfirmed = oTimeConfirmed;
	}

	public LocalDateTime getOTimeProccessed() {
		return oTimeProccessed;
	}

	public void setOTimeProccessed(LocalDateTime oTimeProccessed) {
		this.oTimeProccessed = oTimeProccessed;
	}

	public Long getTotalP_methods() {
		return totalP_methods;
	}

	public void setTotalP_methods(Long totalP_methods) {
		this.totalP_methods = totalP_methods;
	}

	public Integer getIdShporta() {
		return idShporta;
	}

	public void setIdShporta(Integer idShporta) {
		this.idShporta = idShporta;
	}

	public Long getTotalDish() {
		return totalDish;
	}

	public void setTotalDish(Long totalDish) {
		this.totalDish = totalDish;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String toString() {
		return "OrderDto[oId = " + oId + ",orderPrize = " + orderPrize + ",orderItems = " + orderItems
				+ ",orderStatus = " + orderStatus + ",oTimeConfirmed = " + oTimeConfirmed + ",oTimeProccessed = "
				+ oTimeProccessed + ",totalP_methods = " + totalP_methods + ", idShporta= " + idShporta
				+ ",totalDish = " + totalDish + ",idCustomer = " + idCustomer + ",customerName = " + customerName + "]";
	}


}
