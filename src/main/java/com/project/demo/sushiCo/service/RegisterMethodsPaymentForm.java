package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class RegisterMethodsPaymentForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;
	@Column(name = "Id")
	private Integer Id;
	@Column(name = "payment_Method")
	private String payment_Method;
	@Column(name = "adminIdWeb")
	private Integer adminIdWeb;
	@Column(name = "idRestorant")
	private Integer idRestorant;

	public RegisterMethodsPaymentForm() {
		super();
	}

	public RegisterMethodsPaymentForm(String payment_Method, Integer adminIdWeb, Integer idRestorant) {
		super();
		this.payment_Method = payment_Method;
		this.adminIdWeb = adminIdWeb;
		this.idRestorant = idRestorant;
	}

@Override
	public Integer getId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}	
	public Integer getId1() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}


	public String getPayment_Method() {
		return payment_Method;
	}

	public void setPayment_Method(String payment_Method) {
		this.payment_Method = payment_Method;
	}

	public Integer getAdminIdWeb() {
		return adminIdWeb;
	}

	public void setAdminIdWeb(Integer adminIdWeb) {
		this.adminIdWeb = adminIdWeb;
	}

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public String toString() {
		return "RegisterMethodsPaymentForm[registrationId = " +registrationId+ ",Id = " + Id + ",payment_Method = " + payment_Method + ",adminIdWeb = "
				+ adminIdWeb + ",idRestorant = " + idRestorant + "]";
	}

	
}
