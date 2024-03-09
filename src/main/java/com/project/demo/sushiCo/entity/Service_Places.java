package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Service_Places extends BasicEntity<Integer> {
	@OneToMany(mappedBy = "servicePlaces", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Package_Ordered> pckO = new ArrayList<Package_Ordered>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_idApp", referencedColumnName = "idApp")
	private AppRestorant appRestorant;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "service_Places")
	private String service_Places;
	@Column(name = "shippingCost")
	private Double shippingCost;

	public Service_Places() {
		super();
	}

	public Service_Places(String service_Places, AppRestorant appRestorant, List<Package_Ordered> pckO, Double shippingCost) {
		super();
		this.service_Places = service_Places;
		this.appRestorant = appRestorant;
		this.pckO = pckO;
		this.shippingCost = shippingCost;
	}

	@Override
	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;

	}

	public String getService_Places() {
		return service_Places;
	}

	public void setService_Places(String service_Places) {
		this.service_Places = service_Places;
	}

	public AppRestorant getAppRest() {
		return appRestorant;
	}

	public void setAppRest(AppRestorant appRestorant) {
		this.appRestorant = appRestorant;
	}

	public List<Package_Ordered> getPckO() {
		return pckO;
	}

	public void setPckO(List<Package_Ordered> pckO) {
		this.pckO = pckO;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String toString() {
		return "Service_Places[Id = " + Id + ",service_Places = " + service_Places + ", appRestorant = " + appRestorant
				+ ",pckO = " + pckO + ",shippingCost = " + shippingCost + "]";
	}

}
