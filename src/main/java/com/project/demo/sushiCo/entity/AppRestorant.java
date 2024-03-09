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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "appRest")
	public class AppRestorant extends BasicEntity<String>{
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "restorant_tbId", referencedColumnName = "rtb_id")
		private Restorant_tables restorant_tables;

		@OneToMany(mappedBy = "restorant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<User> users;

		@OneToMany(mappedBy = "restorant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Payment_Methods> payment_MethodsR = new ArrayList<Payment_Methods>();

		@OneToMany(mappedBy = "AppRestorant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Service_Places> places = new ArrayList<Service_Places>();

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String idApp;
		@Column(name = "appName")
		private String appName;
		@Column(name = "serialNo")
		private String serialNo;
		@Column(name = "restNUIS")
		private String restNUIS;
		@Column(name = "restaurantName")
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

		public AppRestorant() {
			super();
		}

		public AppRestorant(String appName, String serialNo, String restNUIS, String restName, String phoneNo,
				String activity_field, String addressRest, String service_Places, String payment_Methods,
				String TimeServiceDay, List<User> users, List<Payment_Methods> payment_MethodsR, List<Service_Places> places,
				Restorant_tables restorant_tables) {

			super();

			this.appName = appName;
			this.serialNo = serialNo;
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
			this.setRestorant_tables(restorant_tables);
		}

		@Override
		public String getId() {

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


		public List<Payment_Methods> getPayment_MethodsR() {
			return payment_MethodsR;
		}

		public void setPayment_Methods(List<Payment_Methods> payment_MethodsR) {
			this.payment_MethodsR = payment_MethodsR;
		}

		public List<Service_Places> getPlaces() {
			return places;
		}

		public void setPlaces(List<Service_Places> places) {
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

		public Restorant_tables getRestorant_tables() {
			return restorant_tables;
		}

		public void setRestorant_tables(Restorant_tables restorant_tables) {
			this.restorant_tables = restorant_tables;
		}
		public List<User>  getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}
		
		public String toString() {
			return "AppRestorant[idApp = " + idApp + ",appName = " + appName + ",serialNo = " + serialNo + ",users = " + users
					+ ",payment_MethodsR = " + payment_MethodsR + ",places = " + places + ",restNUIS = " + restNUIS
					+ ", restName = " + restName + ",phoneNo = " + phoneNo + ",activity_field = " + activity_field
					+ ",addressRest =" + addressRest + ",service_Places = " + service_Places + ",payment_Methods = "
					+ payment_Methods + ",TimeServiceDay = " + TimeServiceDay + ",restorant_tables = " + restorant_tables
					+ "]";
		}

		
	}
