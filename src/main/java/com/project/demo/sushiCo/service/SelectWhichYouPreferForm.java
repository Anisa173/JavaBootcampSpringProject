package com.project.demo.sushiCo.service;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.sushiCo.entity.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SelectWhichYouPreferForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSelect;
	@Column(name = "restName")
	private List<String> restName = new ArrayList<String>();
	private Integer idRestorant;

	public SelectWhichYouPreferForm() {
		super();
	}

	public SelectWhichYouPreferForm(List<String> restName, Integer idRestorant) {
		super();
		this.restName = restName;
		this.idRestorant = idRestorant;
	}

	@Override
	public Integer getId() {
		return idSelect;
	}

	public void setIdSelect(Integer id) {
		this.idSelect = id;
	}

	public List<String> getRestName() {
		return restName;
	}

	public void setRestName(List<String> restName) {
		this.restName = restName;

	}

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public String toString() {
		return "SelectWhichYouPreferMapper[idSelect = " + idSelect + ", restName = " + restName + ",idRestorant = "
				+ idRestorant + "]";
	}

}
