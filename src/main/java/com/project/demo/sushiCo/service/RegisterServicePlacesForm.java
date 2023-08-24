package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegisterServicePlacesForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;
	private Integer Id;
	@Column(name = "servicesPlaces")
	private String servicesPlaces;
	@Column(name = "shippingCost")
	private Double shippingCost;
	private Integer idRestorant;

	public RegisterServicePlacesForm() {
		super();
	}

	public RegisterServicePlacesForm(String servicesPlaces, Double shippingCost, Integer idRestorant) {
		super();
		this.servicesPlaces = servicesPlaces;
		this.idRestorant = idRestorant;
	}

	@Override
	public Integer getId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public Integer getId1() {
		return Id;
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
		return "RegisterServicePlacesForm[registrationId = " + registrationId + ",id = " + Id + ",servicesPlaces = "
				+ servicesPlaces + ",shippingCost = " + shippingCost + ",idRestorant = " + idRestorant + "]";
	}

}
