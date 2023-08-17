package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.StatusOrderSession;


import jakarta.validation.constraints.NotNull;


public class PackageOrderedDto {
	private Integer id;
	@NotNull(message = "It's required")
	private StatusOrderSession statusOrderSession;
	@NotNull(message = "It's required")
	private Double sessionPayment;
	private Integer shippersId;
	private String shippersName;
	private Long totalOrd;
	private Integer serviceId;
	private String servicePlaces;

	public PackageOrderedDto() {

	}

	public PackageOrderedDto(Integer id, StatusOrderSession statusOrderSession, Double sessionPayment,
			Integer shippersId, String shippersName, Long totalOrd, Integer serviceId, String servicePlaces) {
		this.id = id;
		this.statusOrderSession = statusOrderSession;
		this.sessionPayment = sessionPayment;
		this.setShippersId(shippersId);
		this.setShippersName(shippersName);
		this.setTotalOrd(totalOrd);
		this.setServiceId(serviceId);
		this.servicePlaces = servicePlaces;
	}

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

	public Integer getShippersId() {
		return shippersId;
	}

	public void setShippersId(Integer shippersId) {
		this.shippersId = shippersId;
	}

	public String getShippersName() {
		return shippersName;
	}

	public void setShippersName(String shippersName) {
		this.shippersName = shippersName;
	}

	public Long getTotalOrd() {
		return totalOrd;
	}

	public void setTotalOrd(Long totalOrd) {
		this.totalOrd = totalOrd;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServicePlaces() {
		return servicePlaces;
	}

	public void setServicePlaces(String servicePlaces) {
		this.servicePlaces = servicePlaces;
	}

	public String toString() {

		return "PackageOrdered[id = " + id + ",statusOrderSession = " + statusOrderSession + ",sessionPayment = "
				+ sessionPayment + ",shippersId = " + shippersId + ",shippersName = " + shippersName + ",totalOrd = "
				+ totalOrd + ",serviceId = " + serviceId + ",servicePlaces = " + servicePlaces + "]";
	}

	

}
