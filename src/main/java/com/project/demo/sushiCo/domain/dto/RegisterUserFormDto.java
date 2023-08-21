package com.project.demo.sushiCo.domain.dto;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.entity.UserRole;

import jakarta.validation.constraints.NotNull;

public class RegisterUserFormDto {

	private Integer registrationId;

	private String first_name;

	private String last_name;

	private String password;

	private String email;

	private String address;

	private String phoneNo;

	private Integer age;

	private String personalIdentityNo;

	private UserRole userRole;
@NotNull(message = "It's required")
	private List<String> restName = new ArrayList<String>();

	public RegisterUserFormDto(Integer registrationId, String first_name, String last_name, String password,
			String email, String address, String phoneNo, Integer age, String personalIdentityNo, UserRole userRole,
			List<String> rest) {
		this.registrationId = registrationId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		this.age = age;
		this.personalIdentityNo = personalIdentityNo;
		this.userRole = userRole;
		this.restName = rest;
	}

	public RegisterUserFormDto() {

	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPersonalIdentityNo() {
		return personalIdentityNo;
	}

	public void setPersonalIdentityNo(String personalIdentityNo) {
		this.personalIdentityNo = personalIdentityNo;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<String> getRestName() {
		return restName;
	}

	public void setRestName(List<String> restName) {
		this.restName = restName;
	}
	

	public String toString() {
		return "RegisterUserFormDto[registrationId = " + registrationId + ",first_name = " + first_name
				+ ",last_name = " + last_name + ",last_name = " + last_name + ",password = " + password + ",email = "
				+ email + ",address = " + address + ",phoneNo = " + phoneNo + ",age = " + phoneNo
				+ ",personalIdentityNo = " + personalIdentityNo + ",userRole = " + userRole + ",restName = " + restName + " ]";
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
