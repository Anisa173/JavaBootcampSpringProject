package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.PaymentMethods;
import com.project.demo.sushiCo.entity.ServicePlaces;

public class OrderByProcessingDto {
	private Integer idSession;
	private Integer idcust;
	private PaymentMethods payments_methodR;
	private ServicePlaces service_placesR;
	private Integer idRestorant;

	public OrderByProcessingDto(Integer idSession, Integer idcust, PaymentMethods payments_methodR,
			ServicePlaces service_placesR, Integer idRestorant) {
		this.idSession = idSession;
		this.idcust = idcust;
		this.payments_methodR = payments_methodR;
		this.service_placesR = service_placesR;
		this.setIdRestorant(idRestorant);
	}

	public OrderByProcessingDto() {

	}

	public Integer getIdSession() {
		return idSession;
	}

	public void setIdSession(Integer idSession) {
		this.idSession = idSession;
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

	public Integer getIdcust() {
		return idcust;
	}

	public void setIdcust(Integer idcust) {
		this.idcust = idcust;
	}

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public String toString() {
		return "OrderByProcessing[idSession = " + idSession + ",idcust = " + idcust + ",payments_methodR = "
				+ payments_methodR + ",service_placesR = " + service_placesR + ",idRestorant = " + idRestorant + "]";
	}

}
