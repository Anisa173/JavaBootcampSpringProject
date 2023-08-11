package com.project.demo.sushiCo.domain.dto;

import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ServicePlacesDto {

	private Integer Id;

	private Long totalPackaged_Ordered;

	private Integer service_id;
	private String restName;
	@NotNull(message = "It can not be null,it's optional")
	private String service_Places;
	@NotNull(message = "It can not be null")
	private Double shippingCost;

	public ServicePlacesDto() {

	}

	public ServicePlacesDto(Integer Id, Long totalPackaged_Ordered,Integer service_id, String restName,
			String service_Places, Double shippingCost) {
		this.Id = Id;
		this.totalPackaged_Ordered = totalPackaged_Ordered;
		this.setService_id(service_id);
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

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer id) {
		this.service_id = id;
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
		return "ServicePlacesDto[Id = " + Id + ",totalPackaged_Ordered =" + totalPackaged_Ordered + ",service_id = "
				+ service_id + ",restName = " + restName + ",service_Places = " + service_Places + ",shippingCost = "
				+ shippingCost + "]";
	}

	

}
