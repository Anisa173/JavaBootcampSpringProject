package com.project.demo.sushiCo.domain.dto;

public class AppRestDto {

	private String idApp;
	private String appName;
	private String serialNo;
	private String restNUIS;
	private String restName;
	private String phoneNo;
	private String activity_field;
	private String addressRest;
	private String service_Places;
	private String payment_Methods;
	private String TimeServiceDay;
	private Integer tableCapacity;
	private Integer restorant_tbId;
	private Long totalUser;
	private Long totalPayment_MethodsR;
	private Long totalService_Places;

	public AppRestDto() {
		appName = "SushiCo Albania";
		phoneNo = "+355 67 647 53 97";
	}

	public AppRestDto(String idApp, String appName, String serialNo, String restNUIS, String restName, String phoneNo,
			String activity_field, String addressRest, String service_Places, String payment_Methods,
			String TimeServiceDay, Integer tableCapacity, Integer restorant_tbId, Long totalUser,
			Long totalPayment_MethodsR, Long totalService_Places) {

		this.idApp = idApp;
		this.appName = appName;
		this.serialNo = serialNo;
		this.setRestNUIS(restNUIS);
		this.restName = restName;
		this.phoneNo = phoneNo;
		this.activity_field = activity_field;
		this.addressRest = addressRest;
		this.service_Places = service_Places;
		this.payment_Methods = payment_Methods;
		this.TimeServiceDay = TimeServiceDay;
		this.setTableCapacity(tableCapacity);
		this.setRestorant_tbId(restorant_tbId);
		this.setTotalUser(totalUser);
		this.setTotalPayment_MethodsR(totalPayment_MethodsR);
		this.setTotalService_Places(totalService_Places);
	}

	public String getIdApp() {
		return idApp;
	}

	public void setIdApp(String idApp) {
		this.idApp = idApp;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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

	public String getTimeServiceDay() {
		return TimeServiceDay;
	}

	public void setTimeServiceDay(String timeServiceDay) {
		TimeServiceDay = timeServiceDay;
	}

	public Integer getTableCapacity() {
		return tableCapacity;
	}

	public void setTableCapacity(Integer tableCapacity) {
		this.tableCapacity = tableCapacity;
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

	public String toString() {

		return "AppRestorant[idApp = " + idApp + ",appName = " + appName + ",serialNo = " + serialNo + ",restName = "
				+ restName + ",phoneNo = " + phoneNo + ",activity_field = " + activity_field + ",addressRest = "
				+ addressRest + ",service_Places = " + service_Places + ",payment_Methods = " + payment_Methods
				+ ",TimeServiceDay = " + TimeServiceDay + ",tableCapacity = " + tableCapacity + ",restorant_tbId = "
				+ restorant_tbId + ",totalUser = " + totalUser + ",totalPayment_MethodsR = " + totalPayment_MethodsR
				+ ",totalService_Places = " + totalService_Places + "]";
	}

}
