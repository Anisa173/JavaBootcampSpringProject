package com.project.demo.sushiCo.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PaymentMethods extends BasicEntity<Integer> {

	// Nepermjet seciles prej metodave te pageses kryhen nje ose disa porosi ne cdo
	// restorant
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderMethodId", referencedColumnName = "oId")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId", referencedColumnName = "idRestorant")
	private Restorant restorant;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer Id;
	@Column(name = "payment_Method")
	private String payment_Method;

	public PaymentMethods() {
		super();
	}

	public PaymentMethods(String payment_Methods, Restorant restorant, Order orders) {
		super();
		this.payment_Method = payment_Methods;
		this.restorant = restorant;
		this.order = orders;
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

	public Restorant getRestorant() {
		return restorant;
	}

	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order orders) {
		this.order = orders;
	}

	public String toString() {
		return "PaymentMethods[Id = " + Id + ",payment_Method = " + payment_Method + ", restorant = " + restorant
				+ ",orders = " + order + "]";
	}


	

}
