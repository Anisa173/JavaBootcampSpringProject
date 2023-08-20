package com.project.demo.sushiCo.serviceImpl;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegisterUserForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "phoneNo")
	private String phoneNo;
	@Column(name = "age")
	private Integer age;
	@Column(name = "personalIdentityNo")
	private String personalIdentityNo;
	@Column(name = "userRole")
	private UserRole userRole;

	@Override
	public Integer getId() {
		return registrationId;
	}

	public void setId(Integer id) {
		this.registrationId = id;
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

	public String toString() {
		return "RegisterUserForm[registrationId = " + registrationId + ",first_name = " + first_name + ",last_name = "
				+ last_name + ",password = " + password + ",email = " + email + ",address = " + address + ",phoneNo = "
				+ phoneNo + ",age  = " + age + ",personalIdentityNo = " + personalIdentityNo + ",userRole = " + userRole
				+ "]";
	}
}
