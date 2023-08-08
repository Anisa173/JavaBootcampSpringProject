package com.project.demo.sushiCo.domain.dto;

public class DishCategoryDto {
	private Integer id;
	private Long totalDishes;
	private String categoryName;
	private Integer admin_Id;
	private String adminName;

	public DishCategoryDto() {

	}

	public DishCategoryDto(Integer id, String categoryName, Long totalDishes, Integer admin_Id, String adminName) {
		this.id = id;
		this.categoryName = categoryName;
		this.totalDishes = totalDishes;
		this.admin_Id = admin_Id;
		this.adminName = adminName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTotalDishes() {
		return totalDishes;
	}

	public void setTotalDishes(Long totalDishes) {
		this.totalDishes = totalDishes;
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

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String toString() {
		return "DishCategoryDto[id = " + id + ",categoryName = " + categoryName + ",totalDishes = " + totalDishes
				+ ",admin_Id = " + admin_Id + ",adminName = " + adminName + "]";
	}

}
