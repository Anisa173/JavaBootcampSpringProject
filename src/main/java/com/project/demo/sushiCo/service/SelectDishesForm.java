package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.Dish;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SelectDishesForm extends BasicEntity<Integer> {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	private Integer categoryId;
	private Dish dish;
	private Integer noItems;
	private String categoryName;
    private Integer custId;
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getNoItems() {
		return noItems;
	}

	public void setNoItems(Integer addItemDish) {
		this.noItems = addItemDish;
}
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
		
	}
	public String toString() {
		return "SelectDishesForm[id = " + id + ",categoryId = " + categoryId + ",dish =" + dish + ",categoryName = "
				+ categoryName + ",noItems = " + noItems + ",custId = " +custId+ "]";

	}

	

}
