package com.project.demo.sushiCo.entity;

import java.time.LocalDateTime;
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
public class Order extends BasicEntity<Integer> {

	// Porosite e restorantit menaxhohen nga admini përkates
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "adminRestId", referencedColumnName = "oId ")
	private User adminUser;

	// Disa Metoda Pagese i vihen ne dispozicion klientit per te kryer nje porosi
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentMethodId", referencedColumnName = "oId")
	private PaymentMethods p_methods;

	// Nje porosi permban disa menu
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Dish> dish = new ArrayList<Dish>();

	// Nje ose disa porosi permban nje shporte porosie
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idShporta", referencedColumnName = "oId")
	private PackageOrdered packageOrdered;

	// Disa porosi mund te kryen gjate nje intervali te shkurter kohe ose gjate te
	// gjithe dite ~ varet nga klienti
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCustomer" , referencedColumnName = "id")
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oId")
	private Integer oId;
	@Column(name = "orderPrize")
	private Double orderPrize;
	@Column(name = "orderItems")
	private Integer orderItems;
	@Column(name = "orderStatus")
	private String orderStatus;
	@Column(name = "oTimeConfirmed")
	private LocalDateTime oTimeConfirmed;
	@Column(name = "oTimeProccessed")
	private LocalDateTime oTimeProccessed;
	public Order() {
		super();
	}

	public Order(Double orderPrize, Integer orderItems, String orderStatus, List<Dish> dish, PackageOrdered packageOrdered, User user,
			PaymentMethods p_methods) {
		super();
		this.orderPrize = orderPrize;
		this.orderItems = orderItems;
		this.orderStatus = orderStatus;
		
		this.dish = dish;
		this.packageOrdered = packageOrdered;
		this.user = user;
		this.p_methods = p_methods;
	}

	@Override
	public Integer getId() {

		return oId;
	}

	public void setOId(Integer id) {
		this.oId = id;
	}

	public Double getOrderPrize() {
		return orderPrize;
	}

	public void setOrderPrize(Double orderPrize) {
		this.orderPrize = orderPrize;
	}

	public Integer getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Integer orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String oStatus) {
		this.orderStatus = oStatus;
	}

	public List<Dish> getDish() {
		return dish;
	}

	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}

	public PackageOrdered getPackage_Ordered() {
		return packageOrdered;
	}

	public void setPackage_Ordered(PackageOrdered packageOrdered) {
		this.packageOrdered = packageOrdered;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentMethods getP_methods() {
		return p_methods;
	}

	public void setP_methods(PaymentMethods p_methods) {
		this.p_methods = p_methods;
	}
public LocalDateTime getOTimeConfirmed() {
		return oTimeConfirmed;
	}

	public void setOTimeConfirmed(LocalDateTime oTimeConfirmed) {
		this.oTimeConfirmed = oTimeConfirmed;
	}

	public LocalDateTime getOTimeProccessed() {
		return oTimeProccessed;
	}

	public void setOTimeProccessed(LocalDateTime oTimeProccessed) {
		this.oTimeProccessed = oTimeProccessed;
	}

	public String toString() {
		return "Order[oId = " + oId + ",orderPrize = " + orderPrize + ",orderItems = " + orderItems + ",orderStatus ="
				+ orderStatus + ",dish = " + dish + ",packageOrdered = " + packageOrdered + ",user = " + user + ",p_methods = "
				+ p_methods + ",oTimeConfirmed = " +oTimeConfirmed+ ",oTimeProccessed = " +oTimeProccessed+ "]";
	}

	
}
