package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.Restorant;
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
	@Column(name = "rest")
	private Restorant rest ;
	private Integer idRestorant;
	private Integer userId;

	public SelectWhichYouPreferForm() {
		super();
	}

	public SelectWhichYouPreferForm(Restorant rest, Integer idRestorant, Integer userId) {
		super();
		this.rest = rest;
		this.idRestorant = idRestorant;
		this.userId = userId;
	}

	@Override
	public Integer getId() {
		return idSelect;
	}

	public void setIdSelect(Integer id) {
		this.idSelect = id;
	}

	public Restorant getRest() {
		return rest;
	}

	public void setRest(Restorant rest) {
		this.rest = rest;

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
		return "SelectWhichYouPreferMapper[idSelect = " + idSelect + ", restName = " + rest + ",idRestorant = "
				+ idRestorant + ",userId = " + userId + "]";
	}
}
