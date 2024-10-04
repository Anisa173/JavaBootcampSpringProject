package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Payment_Methods extends BasicEntity<Integer> {
	@OneToMany(mappedBy = "payment_Method", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders = new ArrayList<Order>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentIdApp", referencedColumnName = "idApp")
	private AppRestorant appRestorant;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer Id;
	@Column(name = "payment_Methods")
	private String payment_Method;

	public Payment_Methods() {
		super();
	}

	public Payment_Methods(String payment_Methods, AppRestorant appRestorant, List<Order> orders) {
		super();
		this.payment_Method = payment_Methods;
		this.appRestorant = appRestorant;
		this.setOrders(orders);
	}

	@Override
	public Integer getId() {
		return Id;
	}

	public void setId(Integer paymentId) {
		this.Id = paymentId;
	}

	public String getPayment_Method() {
		return payment_Method;
	}

	public void setPayment_Method(String payment_Methods) {
		this.payment_Method = payment_Methods;
	}

	public AppRestorant getAppRest() {
		return appRestorant;
	}

	public void setAppRest(AppRestorant appRestorant) {
		this.appRestorant = appRestorant;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String toString() {
		return "Payment_Methods[Id = " + Id + ",payment_Method = " + payment_Method + ", appRestorant = " + appRestorant
				+ ",orders = " + orders + "]";
	}


}


