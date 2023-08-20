package com.project.demo.sushiCo.service;

import java.sql.Time;

import com.project.demo.sushiCo.entity.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegisterRestorantForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	private Integer adminIdWeb;

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAdminIdWeb() {
		return adminIdWeb;
	}

	public void setAdminIdWeb(Integer adminIdWeb) {
		this.adminIdWeb = adminIdWeb;
	}

	public String toString() {
		return "RegisterRestorantForm[id = " + id + ",restNUIS = " + restNUIS + ",restName = " + restName
				+ ",phoneNo = " + phoneNo + ",activity_field = " + activity_field + ",addressRest = " + addressRest
				+ ",startDay = " + startDay + ",endDay = " + endDay + ",adminIdWeb = " + adminIdWeb + "]";
	}

}
