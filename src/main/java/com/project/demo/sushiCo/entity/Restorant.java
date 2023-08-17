package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import groovy.transform.builder.Builder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;

@Entity
public class Restorant extends BasicEntity<Integer> {

	// Çdo restoranti i perket nje admin
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "adminRId", referencedColumnName = "id")
	@JsonManagedReference
	private User admin;
//Disa restorante kryejne sherbimin ne rruge dixhitale nepermjet te njejtit aplikacion
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "webAppId", referencedColumnName = "idAppl")
	private WebAplication aplication;
//Çdo restoranti i perket nje "mjedis fizik" i arreduar me tavolina 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restorant_tbId", referencedColumnName = "rtb_id")
	@JsonManagedReference
	private RestorantTables restorantTables;
//Shume kliente zgjedhin per tu rregjistruar ne aplikacionin tone
	@ManyToMany(mappedBy = "rest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties
	private List<User> users;
//Çdo restorant lejon kryerjen e pageses se porosive nepermjet disa metodave pagese
	@OneToMany(mappedBy = "restorant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PaymentMethods> payment_MethodsR = new ArrayList<PaymentMethods>();
//Çdo restorant kryen transportin e porosive ne disa zona "sherbimi"
	@OneToMany(mappedBy = "restorantService", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ServicePlaces> places = new ArrayList<ServicePlaces>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRestorant;

	@Column(name = "restNUIS")
	private String restNUIS;
	@Column(name = "restName")
	private String restName;
	@Column(name = "phoneNo")
	private String phoneNo;
	@Column(name = "activity_field")
	private String activity_field;
	@Column(name = "addressRest")
	private String addressRest;
	@Column(name = "service_Places")
	private String service_Places;
	@Column(name = "payment_Methods")
	private String payment_Methods;
	@Column(name = "TimeServiceDay")
	private String TimeServiceDay;

	public Restorant() {
		super();
	}

	public Restorant(String restNUIS, String restName, String phoneNo, String activity_field, String addressRest,
			String service_Places, String payment_Methods, String TimeServiceDay, List<User> users,
			List<PaymentMethods> payment_MethodsR, List<ServicePlaces> places, RestorantTables restorantTables,
			WebAplication aplication, User admin) {

		super();

		this.restNUIS = restNUIS;
		this.restName = restName;
		this.phoneNo = phoneNo;
		this.activity_field = activity_field;
		this.addressRest = addressRest;
		this.service_Places = service_Places;
		this.payment_Methods = payment_Methods;
		this.TimeServiceDay = TimeServiceDay;
		this.users = users;
		this.payment_MethodsR = payment_MethodsR;
		this.places = places;
		this.setRestorantTables(restorantTables);
		this.setAplication(aplication);
		this.setAdmin(admin);
	}

	@Override
	public Integer getId() {

		return idRestorant;
	}

	public void setIdRestorant(Integer idApp) {
		this.idRestorant = idApp;
	}

	public List<PaymentMethods> getPayment_MethodsR() {
		return payment_MethodsR;
	}

	public void setPayment_Methods(List<PaymentMethods> payment_MethodsR) {
		this.payment_MethodsR = payment_MethodsR;
	}

	public List<ServicePlaces> getPlaces() {
		return places;
	}

	public void setPlaces(List<ServicePlaces> places) {
		this.places = places;
	}

	public String getRestNUIS() {
		return restNUIS;
	}

	public void setRestNUIS(String restID) {
		this.restNUIS = restID;
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

	public void setPhoneNo(String phone) {
		this.phoneNo = phone;
	}

	public String getActivity_field() {
		return activity_field;
	}

	public void setActivity_field(String activity) {
		this.activity_field = activity;
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

	public void setTimeServiceDay(String serviceIntervalTime) {
		this.TimeServiceDay = serviceIntervalTime;
	}

	public RestorantTables getRestorantTables() {
		return restorantTables;
	}

	public void setRestorantTables(RestorantTables restorantTables) {
		this.restorantTables = restorantTables;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public WebAplication getAplication() {
		return aplication;
	}

	public void setAplication(WebAplication aplication) {
		this.aplication = aplication;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User user) {
		this.admin = user;
	}

	public String toString() {
		return "RestorantService[idRestorant = " + idRestorant + ",users = " + users + ",payment_MethodsR = "
				+ payment_MethodsR + ",places = " + places + ",restNUIS = " + restNUIS + ", restName = " + restName
				+ ",phoneNo = " + phoneNo + ",activity_field = " + activity_field + ",addressRest =" + addressRest
				+ ",service_Places = " + service_Places + ",payment_Methods = " + payment_Methods + ",TimeServiceDay = "
				+ TimeServiceDay + ",restorantTables = " + restorantTables + ",aplication = " + aplication + ",admin = "
				+ admin + "]";
	}


}
