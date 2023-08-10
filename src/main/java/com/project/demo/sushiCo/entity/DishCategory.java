package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.sushiCo.domain.dto.Getter;
import com.project.demo.sushiCo.domain.dto.Setter;

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

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "dishCategory")
public class DishCategory extends BasicEntity<Integer> {

	// Dishes menaxhohen nga Admini i çdo restoranti
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "admin_Id", referencedColumnName = "id")
	private User user;

	// Nje kategori Dishes mund te perzgjidhet nga me shume se nje konsumator
	@OneToMany(mappedBy = "dishCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AddInBasket> addInBasket = new ArrayList<AddInBasket>();

	// Çdo dishCategory përmban N-dishes
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Dish> dishes = new ArrayList<Dish>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "categoryName")
	private String categoryName;

	public DishCategory() {
		super();
	}

	public DishCategory(String categoryName, List<Dish> dishes, User user, List<AddInBasket> addInBasket) {
		super();
		this.categoryName = categoryName;
		this.setDishes(dishes);
		this.user = user;
		this.addInBasket = addInBasket;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AddInBasket> getAddInBasket() {
		return addInBasket;
	}

	public void setAddInBasket(List<AddInBasket> addInBasket) {
		this.addInBasket = addInBasket;
	}

	public String toString() {
		return "DishCategory[id = " + id + ",categoryName = " + categoryName + ",dishes = " + dishes + ",user = " + user
				+ ",addInBasket = " + addInBasket + "]";
	}

}
