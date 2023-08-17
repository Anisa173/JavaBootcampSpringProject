package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;

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
	@Column(name = "paymentMId")
	private Integer paymentMId;
	@Column(name = "payments_methodR")
	private String payments_methodR;
	@Column(name = "servicePId")
	private Integer servicePId;
	@Column(name = "service_placesR")
	private String service_placesR;
	private Integer idRestorant;

	public OrderByProcessing() {
		super();
	}

	public OrderByProcessing(Integer idcust, Integer paymentMId, String payments_methodR, Integer servicePId,
			String service_placesR, Integer idRestorant) {
		super();
		this.idcust = idcust;
		this.paymentMId = paymentMId;
		this.payments_methodR = payments_methodR;
		this.servicePId = servicePId;
		this.service_placesR = service_placesR;

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

	public Integer getPaymentMId() {
		return paymentMId;
	}

	public void setPaymentMId(Integer paymentMId) {
		this.paymentMId = paymentMId;
	}

	public String getPayments_methodR() {
		return payments_methodR;
	}

	public void setPayments_methodR(String payments_methodR) {
		this.payments_methodR = payments_methodR;
	}

	public Integer getServicePId() {
		return servicePId;
	}

	public void setServicePId(Integer servicePId) {
		this.servicePId = servicePId;
	}

	public String getService_placesR() {
		return service_placesR;
	}

	public void setService_placesR(String service_placesR) {
		this.service_placesR = service_placesR;
	}

	public Integer getIdRestorant() {

		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public String toString() {
		return "OrderByProcessing[idSession = " + idSession + ",idcust = " + idcust + ",paymentMId = " + paymentMId
				+ ",payments_methodR = " + payments_methodR + ",servicePId = " + servicePId + ",service_placesR = "
				+ service_placesR + ",idRestorant = " + idRestorant + "]";
	}

}
