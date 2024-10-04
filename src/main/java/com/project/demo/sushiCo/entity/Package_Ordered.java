package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Package_Ordered extends BasicEntity<Integer>{
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serviceId", referencedColumnName = "id")
	private Service_Places serviceP;

	@OneToMany(mappedBy = "package_ordered", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> ord = new ArrayList<Order>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shippersId", referencedColumnName = "id")
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private StatusOrderSession statusOrderSession;
	@Column(name = "sessionPayment")
	private Double sessionPayment;

	public Package_Ordered() {
		super();
		sessionPayment = 800000.00;
	}

	public Package_Ordered(StatusOrderSession statusOrderSession, Double sessionPayment, List<Order> ord, User user,Service_Places serviceP) {
		super();
		this.statusOrderSession = statusOrderSession;
		this.sessionPayment = sessionPayment;
		this.ord = ord;
		this.user = user;
	    this.serviceP = serviceP;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusOrderSession getStatusOrderSession() {
		return statusOrderSession;
	}

	public void setStatusOrderSession(StatusOrderSession statusOrderSession) {
		this.statusOrderSession = statusOrderSession;
	}

	public Double getSessionPayment() {
		return sessionPayment;
	}

	public void setSessionPayment(Double sessionPayment) {
		this.sessionPayment = sessionPayment;
	}

	public List<Order> getOrd() {
		return ord;
	}

	public void setOrd(List<Order> ord) {
		this.ord = ord;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service_Places getServiceP() {
		return serviceP;
	}

	public void setServiceP(Service_Places serviceP) {
		this.serviceP = serviceP;
	}

	public String toString() {
		return "Package_Ordered[id = " + id + ",statusOrderSession = " + statusOrderSession + ",sessionPayment = "
				+ sessionPayment + ",ord = " + ord + ",user = " + user + ",serviceP = " + serviceP + " ]";
	}

}



