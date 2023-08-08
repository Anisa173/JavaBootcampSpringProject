package com.project.demo.sushiCo.domain.dto;

import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DishDto {
	private Integer dId;
	@NotNull(message = "It's required!")
	@Size(min = 4, max = 62, message = "It's minimum is at four characters and maximum should be at sixty-two characters")
	private String dishName;
	@NotNull(message = "It's required!")
	private Double dishPrize;
	@NotNull(message = "It can not be null!")
	private String dishDescription;
	private Integer categoryId;
	@NotNull(message = "It's required!")
	private String dishType;
	private Integer adminId;
	private String adminName;
	private Integer orderId;
	private Integer orderItems;
	private Long totalItemsInBasket;

	public DishDto() {

	}

	public DishDto(Integer dId, String dishName, Double dishPrize, String dishDescription, Integer categoryId,
			String dishType, Integer adminId, String adminName, Integer orderId, Integer orderItems,
			Integer totalItemsInBasket) {
		this.dId = dId;
		this.dishName = dishName;
		this.dishPrize = dishPrize;
		this.dishDescription = dishDescription;
		this.dishPrize = dishPrize;
		this.categoryId = categoryId;
		this.dishType = dishType;
		this.setAdminId(adminId);
		this.setAdminName(adminName);
		this.setOrderId(orderId);
		this.setOrderItems(orderItems);
		this.setTotalItemsInBasket(totalItemsInBasket);
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Integer orderItems) {
		this.orderItems = orderItems;
	}

	public Long getTotalItemsInBasket() {
		return totalItemsInBasket;
	}

	public void setTotalItemsInBasket(long totalItemsInBasket2) {
		this.totalItemsInBasket = totalItemsInBasket2;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public String toString() {
		return "DishDto[dId = " + dId + ",dishName = " + dishName + ",dishPrize = " + dishPrize + ",dishDescription = "
				+ dishDescription + ",dishType = " + dishType + ",categoryId = " +categoryId+ ",adminId = " + adminId + ",adminName = " + adminName
				+ ",orderId = " + orderId + ",orderItems = " + orderItems + ",totalItemsInBasket = "
				+ totalItemsInBasket + "]";
	}

}
