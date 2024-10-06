package com.project.demo.sushiCo.domain.dto;

import jakarta.validation.constraints.NotNull;

public class Service_PlacesDto {

	private Integer Id;

	private Long totalPackaged_Ordered;

	private String service_idApp;
	private String appName;
	@NotNull(message = "It can not be null,it's optional")
	private String service_Places;
	@NotNull(message = "It can not be null")
	private Double shippingCost;

	public Service_PlacesDto() {

	}

	public Service_PlacesDto(Integer Id, Long totalPackaged_Ordered, String service_idApp, String appName,
			String service_Places, Double shippingCost) {
		this.Id = Id;
		this.totalPackaged_Ordered = totalPackaged_Ordered;
		this.setService_idApp(service_idApp);
		this.setAppName(appName);
		this.service_Places = service_Places;
		this.shippingCost = shippingCost;
	}

	public Long getTotalPackaged_Ordered() {
		return totalPackaged_Ordered;
	}

	public void setTotalPackaged_Ordered(Long totalPackaged_Ordered) {
		this.totalPackaged_Ordered = totalPackaged_Ordered;
	}

	public String getService_idApp() {
		return service_idApp;
	}

	public void setService_idApp(String id) {
		this.service_idApp = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getService_Places() {
		return service_Places;
	}

	public void setService_Places(String service_Places) {
		this.service_Places = service_Places;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String toString() {
		return "Service_PlacesDto[Id = " + Id + ",totalPackaged_Ordered =" + totalPackaged_Ordered + ",service_idApp = "
				+ service_idApp + ",appName = " + appName + ",service_Places = " + service_Places + ",shippingCost = "
				+ shippingCost + "]";
	}

	

}
