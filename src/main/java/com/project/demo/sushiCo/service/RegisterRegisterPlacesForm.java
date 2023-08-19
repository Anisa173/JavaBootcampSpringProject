package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegisterRegisterPlacesForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "servicesPlaces")
	private String servicesPlaces;
	@Column(name = "shippingCost")
	private Double shippingCost;
	private Integer idRestorant;

	public RegisterRegisterPlacesForm() {
		super();
	}

	public RegisterRegisterPlacesForm(String servicesPlaces, Double shippingCost,Integer idRestorant ) {
		super();
		this.servicesPlaces = servicesPlaces;
this.idRestorant = idRestorant;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServicesPlaces() {
		return servicesPlaces;
	}

	public void setServicesPlaces(String servicesPlaces) {
		this.servicesPlaces = servicesPlaces;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}
public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}
	
	public String toString() {
		return "RegisterRegisterPlacesForm[id = " + id + ",servicesPlaces = " + servicesPlaces + ",shippingCost = "
				+ shippingCost + ",idRestorant = " +idRestorant+ "]";
	}

	
}
