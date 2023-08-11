package com.project.demo.sushiCo.domain.dto;

public class SelectDishesFormDto {
	private Integer custId;
	private Integer dCategId;
	private String categoryName;
	private Integer dishId;
	private String dishName;
	private String dishDescription;
	private Double dishPrize;
	private Integer noItems;// selected
	private Double amountValue;
	private Double totalCost;

	public SelectDishesFormDto(Integer custId, Integer dCategId, String categoryName, Integer dishId, String dishName,String dishDescription,
			Double dishPrize, Integer noItems, Double amountValue, Double totalCost) {
		this.custId = custId;
		this.dCategId = dCategId;
		this.categoryName = categoryName;
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishDescription = dishDescription;
		this.dishPrize = dishPrize;
		this.noItems = noItems;
		this.amountValue = amountValue;
		this.totalCost = totalCost;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getdCategId() {
		return dCategId;
	}

	public void setdCategId(Integer dCategId) {
		this.dCategId = dCategId;
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

	public Double getDishPrize() {
		return dishPrize;
	}

	public void setDishPrize(Double dishPrize) {
		this.dishPrize = dishPrize;
	}

	public Integer getNoItems() {
		return noItems;
	}

	public void setNoItems(Integer noItems) {
		this.noItems = noItems;
	}

	public Double getAmountValue() {
		return amountValue;
	}

	public void setAmountValue(Double amountValue) {
		this.amountValue = amountValue;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public String toString() {
		return "SelectDishesFormDto[custId = " + custId + ",dCategId = " + dCategId + ",dishId = " + dishId
				+ ",dishName= " + dishName + ", dishDescription = " +dishDescription+ ",dishPrize = " + dishPrize + ",noItems = " + noItems + ",amountValue = "
				+ amountValue + ",totalCost = " + totalCost + ", categoryName = " + categoryName + "]";
	}

	
	
}
