package com.project.demo.sushiCo.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class SelectWhichYouPreferFormDto {
	private Integer idSelect;
	private List<String> restName = new ArrayList<String>();

	public SelectWhichYouPreferFormDto() {

	}

	public SelectWhichYouPreferFormDto(Integer idSelect, List<String> restName) {
		this.setIdSelect(idSelect);
		this.setRestName(restName);

	}

	public Integer getIdSelect() {
		return idSelect;
	}

	public void setIdSelect(Integer idSelect) {
		this.idSelect = idSelect;
	}

	public List<String> getRestName() {
		return restName;
	}

	public void setRestName(List<String> restName) {
		this.restName = restName;
	}

	public String toString() {
		return "SelectWhichYouPreferFormDto[idSelect = " + idSelect + ",restName = " + restName + "]";
	}
}
