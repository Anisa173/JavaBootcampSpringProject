package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.Dish;

import jakarta.validation.constraints.NotNull;

public class SelectDishesFormDto {
	private Integer id;
	private Integer custId;
	private Integer categoryId;
	private String categoryName;
	private Dish dish;// selected
	@NotNull(message = "It's Required")
	private Integer noItems;

	public SelectDishesFormDto(Integer id, Integer custId, Integer categoryId, String categoryName, Dish dishes,
			Integer noItems) {
		this.id = id;
		this.custId = custId;
		this.categoryId = categoryId;
		this.setDish(dishes);
		this.noItems = noItems;

	}

	public SelectDishesFormDto() {

	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer selectDishesFormId) {
		this.id = selectDishesFormId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer dCategId) {
		this.categoryId = dCategId;
	}

	public Integer getNoItems() {
		return noItems;
	}

	public void setNoItems(Integer noItems) {
		this.noItems = noItems;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String toString() {
		return "SelectDishesFormDto[id = " + id + ",custId = " + custId + ",dCategId = " + categoryId + ",dish= " + dish
				+ ",noItems = " + noItems + ",categoryName = " + categoryName + "]";
	}

}
