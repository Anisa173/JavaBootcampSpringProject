package com.project.demo.sushiCo.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderByProcessingDto {
	private Integer idSession;
	private Integer idcust;
	private Integer paymentMId;
	private List<String> payments_methodR = new ArrayList<String>();
	private Integer servicePId;
	private List<String> service_placesR = new ArrayList<String>();
	private Integer idRestorant;

	public OrderByProcessingDto(Integer idSession, Integer idcust, Integer paymentMId, List<String> payments_methodR,
			Integer servicePId,List<String> service_placesR, Integer idRestorant) {
		this.idSession = idSession;
		this.idcust = idcust;
		this.paymentMId = paymentMId;
		this.payments_methodR = payments_methodR;
		this.servicePId = servicePId;
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

	public Integer getPaymentMId() {
		return paymentMId;
	}

	public void setPaymentMId(Integer paymentMId) {
		this.paymentMId = paymentMId;
	}

	public List<String> getPayments_methodR() {
		return payments_methodR;
	}

	public void setPayments_methodR(List<String> payments_methodR) {
		this.payments_methodR = payments_methodR;
	}

	public Integer getServicePId() {
		return servicePId;
	}

	public void setServicePId(Integer servicePId) {
		this.servicePId = servicePId;
	}

	public List<String> getService_placesR() {
		return service_placesR;
	}

	public void setService_placesR(List<String> service_placesR) {
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
		return "OrderByProcessing[idSession = " + idSession + ",idcust = " + idcust + ",paymentMId = " + paymentMId
				+ ",payments_methodR = " + payments_methodR + ",servicePId = " + servicePId + ",service_placesR = "
				+ service_placesR + ",idRestorant = " + idRestorant + "]";
	}

}
