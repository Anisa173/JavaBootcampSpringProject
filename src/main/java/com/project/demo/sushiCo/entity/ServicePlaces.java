package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class ServicePlaces extends BasicEntity<Integer> {

	//Në çdo zonë sherbimi dergohen 1 ose N-shporta porosie gjate punes ditore
	@OneToMany(mappedBy = "servicePlaces", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PackageOrdered> pckO = new ArrayList<PackageOrdered>();

	// Disa zona sherbimi i perkasin çdo restoranti 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_idR", referencedColumnName = "idRestorant")
	private Restorant restorantService;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "service_Places")
	private String service_Places;
	@Column(name = "shippingCost")
	private Double shippingCost;

	public ServicePlaces() {
		super();
	}

	public ServicePlaces(String service_Places, Double shippingCost, Restorant restorant, List<PackageOrdered> pckO) {
		super();
		this.service_Places = service_Places;
		this.restorantService = restorant;
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

	public Restorant getRestorantService() {
		return restorantService;
	}

	public void setRestorantService(Restorant restorant) {
		this.restorantService = restorant;
	}

	public List<PackageOrdered> getPckO() {
		return pckO;
	}

	public void setPckO(List<PackageOrdered> pckO) {
		this.pckO = pckO;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String toString() {
		return "ServicePlaces[Id = " + Id + ",service_Places = " + service_Places + ", restorant = " + restorantService
				+ ",pckO = " + pckO + ",shippingCost = " + shippingCost + "]";
	}

}
