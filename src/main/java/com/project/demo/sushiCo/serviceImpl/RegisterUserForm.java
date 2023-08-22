package com.project.demo.sushiCo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
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
	@Column(name = "rest")
	private List<String> restName = new ArrayList<String>();
	private Integer userId;
	private Integer idRestorant;

	public RegisterUserForm() {
		super();
	}

	public RegisterUserForm(String first_name, String last_name, String password, String email, String address,
			String phoneNo, Integer age, String personalIdentityNo, UserRole userRole, List<String> rest,
			Integer idRestorant, Integer userId) {
		super();
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
		this.idRestorant = idRestorant;
		this.userId = userId;
	}

	@Override
	public Integer getId() {
		return registrationId;
	}

	public void setRegistrationId(Integer id) {
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

	public List<String> getRestName() {
		return restName;
	}

	public void setRestName(List<String> rest) {
		this.restName = rest;
	}

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer id) {
		this.userId = id;
	}

	public String toString() {
		return "RegisterUserForm[registrationId = " + registrationId + ",first_name = " + first_name + ",last_name = "
				+ last_name + ",password = " + password + ",email = " + email + ",address = " + address + ",phoneNo = "
				+ phoneNo + ",age  = " + age + ",personalIdentityNo = " + personalIdentityNo + ",userRole = " + userRole
				+ ",rest = " + restName + ",idRestorant = " + idRestorant + ",userId = " + userId + "]";
	}

}
