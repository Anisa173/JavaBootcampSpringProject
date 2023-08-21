package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.Dish;

import jakarta.validation.constraints.NotNull;

public class AddInBasketDto {

	private Integer addId;
	private Integer custId;
	private String phoneNo;
	private String customerName;
	private Dish dishes;
	@NotNull(message = "It's required")
	private Integer addItemsDish;
	private Double valueAmount;
	private Integer dCatId;
	@NotNull(message = "It's required ! ")
	private String dishType;

	public AddInBasketDto() {
		addItemsDish = 5;
	}

	public AddInBasketDto(Integer addId, Integer custId, String phoneNo, String customerName, Dish dish,
			Integer addItemsDish, Double valueAmount) {
		this.addId = addId;
		this.setCustId(custId);
		this.setPhoneNo(phoneNo);
		this.setCustomerName(customerName);
		this.setDishes(dish);
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

	public Dish getDishes() {
		return dishes;
	}

	public void setDishes(Dish dishes) {
		this.dishes = dishes;
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
				+ customerName + ",dishes = " + dishes + ",addItemDish = " + addItemsDish + ", valueAmount = "
				+ valueAmount + ",dCatId = " + dCatId + ",dishType = " + dishType + "]";
	}

}
