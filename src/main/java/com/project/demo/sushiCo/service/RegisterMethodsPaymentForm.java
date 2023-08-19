package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;

import jakarta.persistence.Entity;

@Entity
public class RegisterMethodsPaymentForm extends BasicEntity<Integer> {
	private Integer Id;
	private String payment_Method;
	private Integer adminIdWeb;
	private Integer idRestorant;

	public RegisterMethodsPaymentForm() {
		super();
	}

	public RegisterMethodsPaymentForm(String payment_Method, Integer adminIdWeb) {
		super();
		this.payment_Method = payment_Method;
		this.adminIdWeb = adminIdWeb;
	}

	@Override
	public Integer getId() {
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
		return "RegisterMethodsPaymentForm[Id = " + Id + ",payment_Method = " + payment_Method + ",adminIdWeb = "
				+ adminIdWeb + "]";
	}

}
