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

	//Në çdo zonë sherbimi dergohen 1 ose N-shporta porosie
	@OneToMany(mappedBy = "servicePlaces", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PackageOrdered> pckO = new ArrayList<PackageOrdered>();

	//Disa zona sherbimi i perkasin cdo restoranti
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_idApp", referencedColumnName = "idRestorant")
	private Restorant restorant;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "service_Places")
	private String service_Places;
	@Column(name = "shippingCost")
	private Double shippingCost;

	public ServicePlaces() {
		super();
	}

	public ServicePlaces(String service_Places, Restorant restorant, List<PackageOrdered> pckO, Double shippingCost) {
		super();
		this.service_Places = service_Places;
		this.restorant = restorant;
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

	public Restorant getAppRest() {
		return restorant;
	}

	public void setAppRest(Restorant restorant) {
		this.restorant = restorant;
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
		return "ServicePlaces[Id = " + Id + ",service_Places = " + service_Places + ", restorant = " + restorant
				+ ",pckO = " + pckO + ",shippingCost = " + shippingCost + "]";
	}

}
