package com.project.demo.sushiCo.serviceImpl;

import com.project.demo.sushiCo.entity.BasicEntity;
import com.project.demo.sushiCo.entity.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Login extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "userRole")
	private UserRole userRole;
	private Integer userId;

	@Override
	public Integer getId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId2) {
		this.registrationId = registrationId2;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String toString() {
		return "Login[idLogin = " + registrationId + ",email = " + email + ",password = " + password + " ]";
	}

	

}
