package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.sushiCo.domain.dto.Getter;
import com.project.demo.sushiCo.domain.dto.Setter;

import groovy.transform.builder.Builder;
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
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class PackageOrdered extends BasicEntity<Integer> {
	// Nje ose N-shporta Porosie dergohet ne te njejten zone sherbimi gjate nje dite
	// pune
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serviceId", referencedColumnName = "id")
	private ServicePlaces servicePlaces;

	// Seciles shporte porosie i perkasin nje ose N porosi
	@OneToMany(mappedBy = "packageOrdered", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> ord = new ArrayList<Order>();

	// Disa shporta_porosie dergohen nepermjet nje "shippers"
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

	public PackageOrdered() {
		super();
		sessionPayment = 800000.00;
	}

	public PackageOrdered(StatusOrderSession statusOrderSession, Double sessionPayment, List<Order> ord, User user,
			ServicePlaces servicePlaces) {
		super();
		this.statusOrderSession = statusOrderSession;
		this.sessionPayment = sessionPayment;
		this.ord = ord;
		this.user = user;
		this.servicePlaces = servicePlaces;
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

	public ServicePlaces getServicePlaces() {
		return servicePlaces;
	}

	public void setServicePlaces(ServicePlaces serviceP) {
		this.servicePlaces = serviceP;
	}

	public String toString() {
		return "PackageOrdered[id = " + id + ",statusOrderSession = " + statusOrderSession + ",sessionPayment = "
				+ sessionPayment + ",ord = " + ord + ",user = " + user + ",servicePlaces = " + servicePlaces + " ]";
	}

}
