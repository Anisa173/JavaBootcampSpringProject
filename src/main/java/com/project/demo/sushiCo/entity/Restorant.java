package com.project.demo.sushiCo.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@Entity
public class Restorant extends BasicEntity<Integer> {
//Per te gjitha restorantet te dhenat e secilit regjistrohen dhe mirmbahen nga administratori i platformës
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "adminIdWeb", referencedColumnName = "id")
	private User adminWeb;

	// Çdo restoranti i perket nje admin qe administron proçesin e punës se
	// restorantit
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "adminRId", referencedColumnName = "id")
	@JsonManagedReference
	private User admin;

	// Çdo restoranti i perket nje "mjedis fizik" i arreduar me tavolina
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restorant_tbId", referencedColumnName = "rtb_id")
	@JsonManagedReference
	private RestorantTables restorantTables;

	// Shume 'kliente' zgjedhin per tu rregjistruar ne aplikacionin tone
	@ManyToMany(mappedBy = "rest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties
	private List<User> users;

    //Çdo restorant lejon kryerjen e pageses se porosive nepermjet dy formave , me kesh dhe me karte
	@OneToMany(mappedBy = "restorant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PaymentMethods> payment_MethodsR = new ArrayList<PaymentMethods>();

	// Çdo restorant kryen transportin e porosive ne disa zona "sherbimi"
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
	@Column(name = "startDay")
	private Time startDay;
	@Column(name = "endDay")
	private Time endDay;

	public Restorant() {
		super();
	}

	public Restorant(String restNUIS, String restName, String phoneNo, String activity_field, String addressRest,
			List<ServicePlaces> service_Places, List<PaymentMethods> payment_MethodsR, Time startDay, Time endDay, List<User> users,RestorantTables restorantTables,
			 User admin, User adminWeb) {

		super();

		this.restNUIS = restNUIS;
		this.restName = restName;
		this.phoneNo = phoneNo;
		this.activity_field = activity_field;
		this.addressRest = addressRest;
		this.startDay = startDay;
		this.endDay = endDay;
		this.users = users;
		this.payment_MethodsR = payment_MethodsR;
		this.places = service_Places;
		this.setRestorantTables(restorantTables);
		this.setAdmin(admin);
		this.adminWeb = adminWeb;
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

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User user) {
		this.admin = user;
	}

	public User getAdminWeb() {
		return adminWeb;
	}

	public void setAdminWeb(User adminWeb) {
		this.adminWeb = adminWeb;
	}


	public String toString() {
		return "RestorantService[idRestorant = " + idRestorant + ",users = " + users + ",payment_MethodsR = "
				+ payment_MethodsR + ",places = " + places + ",restNUIS = " + restNUIS + ", restName = " + restName
				+ ",phoneNo = " + phoneNo + ",activity_field = " + activity_field + ",addressRest =" + addressRest
				+ ",startDay = "+ startDay + ",endDay = " + endDay + ",restorantTables = " + restorantTables + ",admin = " + admin
				+ ",adminWeb = " + adminWeb + "]";
	}

}
