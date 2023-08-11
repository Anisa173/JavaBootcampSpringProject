package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.sushiCo.domain.dto.Getter;
import com.project.demo.sushiCo.domain.dto.Setter;

import groovy.transform.builder.Builder;
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
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class PaymentMethods extends BasicEntity<Integer> {

	// Nepermjet seciles prej metodave te pageses kryhen nje ose disa porosi ne cdo
	// restorant
	@OneToMany(mappedBy = "p_Methods", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders = new ArrayList<Order>();
	// Disa metoda Pagese i perkasin nje restoranti
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

	public PaymentMethods(String payment_Methods, Restorant restorant, List<Order> orders) {
		super();
		this.payment_Method = payment_Methods;
		this.restorant = restorant;
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

	public Restorant getRestorant() {
		return restorant;
	}

	public void setAppRest(Restorant restorant) {
		this.restorant = restorant;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String toString() {
		return "PaymentMethods[Id = " + Id + ",payment_Method = " + payment_Method + ", restorant = " + restorant
				+ ",orders = " + orders + "]";
	}

	

}
