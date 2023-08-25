package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.DishCategory;

public class RegisterDishFormDto {
	private Integer idRegistration;
	private Integer dId;
	private String dishName;
	private Double dishPrize;
	private String dishDescription;
	private DishCategory dishType;
	private Integer adminId;
	private Integer categoryId;

	public RegisterDishFormDto() {

	}

	public RegisterDishFormDto(Integer idRegistration, Integer dId, String dishName, Double dishPrize,
			String dishDescription, DishCategory dishType, Integer adminId, Integer categoryId) {

	}

	public Integer getIdRegistration() {
		return idRegistration;
	}

	public void setIdRegistration(Integer idRegistration) {
		this.idRegistration = idRegistration;
	}

	public Integer getDId() {
		return dId;
	}

	public void setDId(Integer dId) {
		this.dId = dId;
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

	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public DishCategory getDishType() {
		return dishType;
	}

	public void setDishType(DishCategory dishType) {
		this.dishType = dishType;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String toString() {
		return "RegisterDishFormDto[idRegistration = " + idRegistration + ",dId = " + dId + ",dishName = " + dishName
				+ ",dishPrize = " + dishPrize + ",dishDescription = " + dishDescription + ", dishType = " + dishType
				+ ",adminId = " + adminId + ",categoryId = " + categoryId + "]";
	}

	
}
