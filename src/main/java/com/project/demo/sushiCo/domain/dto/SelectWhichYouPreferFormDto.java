package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.Restorant;

public class SelectWhichYouPreferFormDto {

	private Integer idSelect;
	private Restorant rest ;
	private Integer idRestorant;
	private Integer userId;

	public SelectWhichYouPreferFormDto() {

	}

	public SelectWhichYouPreferFormDto(Integer idSelect, Restorant restName, Integer idRestorant,
			Integer userId) {
		this.setIdSelect(idSelect);
		this.setRest(restName);
		this.idRestorant = idRestorant;
		this.userId = userId;
	}

	public Integer getIdSelect() {
		return idSelect;
	}

	public void setIdSelect(Integer idSelect) {
		this.idSelect = idSelect;
	}

	public Restorant getRest() {
		return rest;
	}

	public void setRest(Restorant restName) {
		this.rest = restName;
	}

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String toString() {
		return "SelectWhichYouPreferFormDto[idSelect = " + idSelect + ",restName = " + rest + ",idRestorant = "
				+ idRestorant + ",userId = " + userId + "]";
	}

}
