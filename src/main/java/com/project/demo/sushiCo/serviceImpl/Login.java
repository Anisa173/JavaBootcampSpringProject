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
	private Integer idLogin;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private CharSequence password;
	@Column(name = "userRole")
	private UserRole userRole;

	@Override
	public Integer getId() {
		return idLogin;
	}

	public void setIdLogin(Integer id) {
		this.idLogin = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CharSequence getPassword() {
		return password;
	}

	public void setPassword(CharSequence password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String toString() {
		return "Login[idLogin = " + idLogin + ",email = " + email + ",password = " + password + " ]";
	}

}
