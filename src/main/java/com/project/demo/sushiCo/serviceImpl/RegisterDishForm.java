package com.project.demo.sushiCo.serviceImpl;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.DishCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterDishForm extends BasicEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistration;
	private Integer dId;
	@Column(name = "dishName")
	private String dishName;
	@Column(name = "dishPrize")
	private Double dishPrize;
	@Column(name = "dishDescription")
	private String dishDescription;
	@Column(name = "dishType")
	private DishCategory dishType;
	private Integer adminId;
	private Integer categoryId;
	
	@Override
	public Integer getId() {
		return idRegistration;
	}

	public void setIdRegistration(Integer id) {
		this.idRegistration = id;
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
		return "RegisterDishForm[idRegistration = " + idRegistration + ",dishName = " + dishName + ",dishPrize = "
				+ dishPrize + ",dishDescription = " + dishDescription + ",dishType = " + dishType + ",adminId = "
				+ adminId + ",categoryId = " + categoryId + " ]";
	}

	
}
