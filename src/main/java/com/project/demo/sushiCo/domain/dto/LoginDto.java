package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.UserRole;

public class LoginDto {
	private Integer registrationId;

	private String email;

	private String password;

	private UserRole userRole;

	public LoginDto() {

	}

	public LoginDto(Integer idLogin, String email, String password, UserRole userRole) {
		this.registrationId = idLogin;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer idLogin) {
		this.registrationId = idLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String toString() {
		return "LoginDto[ idLogin = " + registrationId + ", email = " + email + ",password = " + password + ", userRole = "
				+ userRole + " ";
	}

}
