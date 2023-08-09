package com.project.demo.sushiCo.domain.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddInBasketDto {

	private Integer addId;
	private Integer custId;
	private String phoneNo;
	private String customerName;
	private Integer dishId;
	private String dishName;
	private Integer addItemsDish;
	private Double valueAmount;

	public AddInBasketDto() {
		addItemsDish = 5;
	}

	public AddInBasketDto(Integer addId, Integer custId, String phoneNo, String customerName, Integer dishId,
			String dishName, Integer addItemsDish, Double valueAmount) {
		this.addId = addId;
		this.setCustId(custId);
		this.setPhoneNo(phoneNo);
		this.setCustomerName(customerName);
		this.setDishId(dishId);
		this.setDishName(dishName);
		this.addItemsDish = addItemsDish;
		this.valueAmount = valueAmount;
	}

	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
	}

	public Integer getAddItemsDish() {
		return addItemsDish;
	}

	public void setAddItemsDish(Integer addItemsDish) {
		this.addItemsDish = addItemsDish;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Double getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(Double valueAmount) {
		this.valueAmount = valueAmount;
	}

	public String toString() {
		return "AddInBasket[addId = " + addId + ",custId = " + custId + ",phoneNo = " + phoneNo + ",customerName = "
				+ customerName + ",dishId = " + dishId + ",dishName = " + dishName + ",addItemDish = " + addItemsDish
				+ ", valueAmount = " + valueAmount + "]";
	}

}
