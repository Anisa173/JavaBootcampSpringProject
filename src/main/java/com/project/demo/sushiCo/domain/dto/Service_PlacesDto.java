package com.project.demo.sushiCo.domain.dto;

import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Service_PlacesDto {

	private Integer Id;

	private Long totalPackaged_Ordered;

	private Integer service_idApp;
	private String restName;
	@NotNull(message = "It can not be null,it's optional")
	private String service_Places;
	@NotNull(message = "It can not be null")
	private Double shippingCost;

	public Service_PlacesDto() {

	}

	public Service_PlacesDto(Integer Id, Long totalPackaged_Ordered,Integer service_idApp, String restName,
			String service_Places, Double shippingCost) {
		this.Id = Id;
		this.totalPackaged_Ordered = totalPackaged_Ordered;
		this.setService_idApp(service_idApp);
		this.setRestName(restName);
		this.service_Places = service_Places;
		this.shippingCost = shippingCost;
	}

	public Long getTotalPackaged_Ordered() {
		return totalPackaged_Ordered;
	}

	public void setTotalPackaged_Ordered(Long totalPackaged_Ordered) {
		this.totalPackaged_Ordered = totalPackaged_Ordered;
	}

	public Integer getService_idApp() {
		return service_idApp;
	}

	public void setService_idApp(Integer id) {
		this.service_idApp = id;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
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
				+ service_idApp + ",restName = " + restName + ",service_Places = " + service_Places + ",shippingCost = "
				+ shippingCost + "]";
	}

	

}
