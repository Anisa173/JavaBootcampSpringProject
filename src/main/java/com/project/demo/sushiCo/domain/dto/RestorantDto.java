package com.project.demo.sushiCo.domain.dto;

import java.sql.Time;

import jakarta.validation.constraints.NotNull;

public class RestorantDto {

	private Integer idRestorant;
	@NotNull(message = "It's Required")
	private String restNUIS;
	@NotNull(message = "It's Required")
	private String restName;
	@NotNull(message = "It's Required")
	private String phoneNo;
	@NotNull(message = "It's Required")
	private String activity_field;
	@NotNull(message = "It's Required")
	private String addressRest;
	@NotNull(message = "It's Required")
	private String service_Places;
	@NotNull(message = "It's Required")
	private String payment_Methods;
	@NotNull(message = "It's Required")
	private Time startDay;
	@NotNull(message = "It's Required")
	private Time endDay;
	private String tableDescription;
	private Integer restorant_tbId;
	private Long totalUser;
	private Long totalPayment_MethodsR;
	private Long totalService_Places;
	private Integer webAppId;
	private String applicationName;
	private Integer adminRId;
	private String adminName;
	private Integer adminIdWeb;

	public RestorantDto() {
		restName = "SushiCo Albania";
		phoneNo = "+355 67 647 53 97";
	}

	public RestorantDto(Integer idRestorant, String restNUIS, String restName, String phoneNo, String activity_field,
			String addressRest, String service_Places, String payment_Methods, Time startDay, Time endDay,
			String tableDescription, Integer restorant_tbId, Long totalUser, Long totalPayment_MethodsR,
			Long totalService_Places, Integer webAppId, String applicationName, Integer adminRId, String adminName,
			Integer adminIdWeb) {

		this.idRestorant = idRestorant;
		this.setRestNUIS(restNUIS);
		this.restName = restName;
		this.phoneNo = phoneNo;
		this.activity_field = activity_field;
		this.addressRest = addressRest;
		this.service_Places = service_Places;
		this.payment_Methods = payment_Methods;
		this.startDay = startDay;
		this.endDay = endDay;
		this.setTableDescription(tableDescription);
		this.setRestorant_tbId(restorant_tbId);
		this.setTotalUser(totalUser);
		this.setTotalPayment_MethodsR(totalPayment_MethodsR);
		this.setTotalService_Places(totalService_Places);
		this.setWebAppId(webAppId);
		this.setApplicationName(applicationName);
		this.adminRId = adminRId;
		this.adminName = adminName;
		this.adminIdWeb = adminIdWeb;
	}

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idApp) {
		this.idRestorant = idApp;
	}

	public String getRestNUIS() {
		return restNUIS;
	}

	public void setRestNUIS(String restNUIS) {
		this.restNUIS = restNUIS;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getActivity_field() {
		return activity_field;
	}

	public void setActivity_field(String activity_field) {
		this.activity_field = activity_field;
	}

	public String getAddressRest() {
		return addressRest;
	}

	public void setAddressRest(String addressRest) {
		this.addressRest = addressRest;
	}

	public String getService_Places() {
		return service_Places;
	}

	public void setService_Places(String service_Places) {
		this.service_Places = service_Places;
	}

	public String getPayment_Methods() {
		return payment_Methods;
	}

	public void setPayment_Methods(String payment_Methods) {
		this.payment_Methods = payment_Methods;
	}

	public Time getStartDay() {
		return startDay;
	}

	public void setStartDay(Time startDay) {
		this.startDay = startDay;
	}

	public Time getEndDay() {
		return endDay;
	}

	public void setEndDay(Time endDay) {
		this.endDay = endDay;
	}

	public String getTableDescription() {
		return tableDescription;
	}

	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}

	public Integer getRestorant_tbId() {
		return restorant_tbId;
	}

	public void setRestorant_tbId(Integer restorant_tbId) {
		this.restorant_tbId = restorant_tbId;
	}

	public Long getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(Long totalUser) {
		this.totalUser = totalUser;
	}

	public Long getTotalPayment_MethodsR() {
		return totalPayment_MethodsR;
	}

	public void setTotalPayment_MethodsR(Long totalPayment_MethodsR) {
		this.totalPayment_MethodsR = totalPayment_MethodsR;
	}

	public Long getTotalService_Places() {
		return totalService_Places;
	}

	public void setTotalService_Places(Long totalService_Places) {
		this.totalService_Places = totalService_Places;
	}

	public Integer getWebAppId() {
		return webAppId;
	}

	public void setWebAppId(Integer webAppId2) {
		this.webAppId = webAppId2;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Integer getAdminRId() {
		return adminRId;
	}

	public void setAdminRId(Integer adminRId) {
		this.adminRId = adminRId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getAdminIdWeb() {
		return adminIdWeb;
	}

	public void setAdminIdWeb(Integer adminIdWeb) {
		this.adminIdWeb = adminIdWeb;
	}

	public String toString() {

		return "RestorantService[idRestorant = " + idRestorant + ",restName = " + restName + ",phoneNo = " + phoneNo
				+ ",activity_field = " + activity_field + ",addressRest = " + addressRest + ",service_Places = "
				+ service_Places + ",payment_Methods = " + payment_Methods + ",startDay = " + startDay + ",endDay = "
				+ endDay + ",tableCapacity = " + tableDescription + ",restorant_tbId = " + restorant_tbId
				+ ",totalUser = " + totalUser + ",totalPayment_MethodsR = " + totalPayment_MethodsR
				+ ",totalService_Places = " + totalService_Places + ",applicationName = " + applicationName
				+ ",aplicationId = " + webAppId + ",adminRId = " + adminRId + ",adminName = " + adminName
				+ ",adminIdWeb = " + adminIdWeb + "]";
	}

}
