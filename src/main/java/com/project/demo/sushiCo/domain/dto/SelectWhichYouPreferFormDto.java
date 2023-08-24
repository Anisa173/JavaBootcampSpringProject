package com.project.demo.sushiCo.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.sushiCo.entity.Restorant;

public class SelectWhichYouPreferFormDto {

	private Integer idSelect;
	private List<Restorant> rest = new ArrayList<Restorant>();
	private Integer idRestorant;
	private Integer userId;

	public SelectWhichYouPreferFormDto() {

	}

	public SelectWhichYouPreferFormDto(Integer idSelect, List<Restorant> restName, Integer idRestorant,
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

	public List<Restorant> getRest() {
		return rest;
	}

	public void setRest(List<Restorant> restName) {
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
