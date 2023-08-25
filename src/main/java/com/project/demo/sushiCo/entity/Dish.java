package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;



import groovy.transform.builder.Builder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;


@Builder
@AllArgsConstructor
@Entity
@Table(name = "Dish")
public class Dish extends BasicEntity<Integer> {
   
//Disa dishes i perkasin nje kategorie
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", referencedColumnName = "id")
	private DishCategory category;

	//Nje apo disa dishes mund te pergjidhen nga 'customers' per nje porosi
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId", referencedColumnName = "oId")
	private Order order;
//
	@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AddInBasket> addInBasket = new ArrayList<AddInBasket>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dId;
	@Column(name = "dishName")
	private String dishName;
	@Column(name = "dishPrize")
	private Double dishPrize;
	@Column(name = "dishDescrition")
	private String dishDescription;

	public Dish() {
		super();
	}

	public Dish(String dishName, Double dishPrize, String dishDescription, DishCategory category,
			Order order, List<AddInBasket> addInBasket) {
		super();
		this.dishName = dishName;
		this.dishPrize = dishPrize;
		this.dishDescription = dishDescription;
		this.setCategory(category);
		this.order = order;
		this.addInBasket = addInBasket;

	}

	@Override
	public Integer getId() {
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

	public DishCategory getCategory() {
		return category;
	}

	public void setCategory(DishCategory category) {
		this.category = category;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<AddInBasket> getAddInBasket() {
		return addInBasket;
	}

	public void setAddInBasket(List<AddInBasket> addInBasket) {
		this.addInBasket = addInBasket;
	}

	public String toString() {
		return "Dish[dId = " + dId + ",dishName = " + dishName + ",dishPrize = " + dishPrize + ",dishDescription = "
				+ dishDescription + ",category = " +category+ ",order = " + order + ", addInBasket = " + addInBasket + "]";
	}

}
