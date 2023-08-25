package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.PaymentMethods;
import com.project.demo.sushiCo.entity.ServicePlaces;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderByProcessing extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSession;
	@Column(name = "idcust")
	private Integer idcust;
	@Column(name = "payments_methodR")
	private PaymentMethods payments_methodR;
	@Column(name = "service_placesR")
	private ServicePlaces service_placesR;
	private Integer idRestorant;
	private Integer servPId;
	private Integer pmId;

	public OrderByProcessing() {
		super();
	}

	public OrderByProcessing(Integer idcust, PaymentMethods payments_methodR, Integer servicePId,
			ServicePlaces service_placesR, Integer idRestorant, Integer servPId, Integer pmId) {
		super();
		this.idcust = idcust;
		this.payments_methodR = payments_methodR;
		this.service_placesR = service_placesR;
		this.servPId = servPId;
		this.pmId = pmId;
	}

	@Override
	public Integer getId() {
		return idcust;
	}

	public void setIdSession(Integer id) {
		this.idSession = id;
	}

	public Integer getIdcust() {
		return idcust;
	}

	public void setIdcust(Integer id) {
		this.idcust = id;
	}

	public PaymentMethods getPayments_methodR() {
		return payments_methodR;
	}

	public void setPayments_methodR(PaymentMethods payments_methodR) {
		this.payments_methodR = payments_methodR;
	}

	public ServicePlaces getService_placesR() {
		return service_placesR;
	}

	public void setService_placesR(ServicePlaces service_placesR) {
		this.service_placesR = service_placesR;
	}

	public Integer getIdRestorant() {

		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public Integer getServPId() {
		return servPId;
	}

	public void setServPId(Integer servPId) {
		this.servPId = servPId;
	}

	public Integer getPmId() {
		return pmId;
	}

	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}

	public String toString() {
		return "OrderByProcessing[idSession = " + idSession + ",idcust = " + idcust + ",payments_methodR = "
				+ payments_methodR + ",service_placesR = " + service_placesR + ",idRestorant = " + idRestorant
				+ ",servPId = " + servPId + "]";
	}

}
