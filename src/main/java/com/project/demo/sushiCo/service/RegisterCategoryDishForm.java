package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@AllArgsConstructor
@Entity
public class RegisterCategoryDishForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "categoryName")
	private String categoryName;
	private Integer admin_Id;

	@Override
	public Integer getId() {
		return getId();
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(Integer admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String toString() {
		return "RegisterCategoryDishForm[Id = " + Id + ",categoryName = " + categoryName + ",admin_Id = " + admin_Id
				+ "]";
	}
}
