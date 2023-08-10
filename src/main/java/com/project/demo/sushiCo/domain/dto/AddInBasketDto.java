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
	private Integer IDdish;
	private String dishName;
	private Double dishPrize;
	private Integer addItemsDish;
	private Double valueAmount;
private Integer dCatId;
private String dishType;
	
	public AddInBasketDto() {
		addItemsDish = 5;
	}

	public AddInBasketDto(Integer addId, Integer custId, String phoneNo, String customerName, Integer IDdish,
			String dishName, Double dishPrize, Integer addItemsDish, Double valueAmount) {
		this.addId = addId;
		this.setCustId(custId);
		this.setPhoneNo(phoneNo);
		this.setCustomerName(customerName);
		this.setIDdish(IDdish);
		this.setDishName(dishName);
		this.dishPrize = dishPrize;
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

	public Integer getIDdish() {
		return IDdish;
	}

	public void setIDdish(Integer dishId) {
		this.IDdish = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Double getDishPrize() {
		return dishPrize;
	}

	public void setDishPrize(Double dishPrize) {
		this.dishPrize = dishPrize;
	}

	public Double getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(Double valueAmount) {
		this.valueAmount = valueAmount;
	}
public Integer getdCatId() {
		return dCatId;
	}

	public void setdCatId(Integer dCatId) {
		this.dCatId = dCatId;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	public String toString() {
		return "AddInBasket[addId = " + addId + ",custId = " + custId + ",phoneNo = " + phoneNo + ",customerName = "
				+ customerName + ",IDdish = " + IDdish + ",dishName = " + dishName + ",dishPrize = " + dishPrize
				+ ",addItemDish = " + addItemsDish + ", valueAmount = " + valueAmount + ",dCatId = " +dCatId+ ",dishType = "+dishType+ "]";
	}

	

}
