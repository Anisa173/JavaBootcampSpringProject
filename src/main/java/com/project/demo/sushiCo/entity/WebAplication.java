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


@Entity
public class WebAplication extends BasicEntity<Integer> {
//Platforma Web administrohet nga admini
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "adminWebId", referencedColumnName = "id")
	private User adminWebAplication;
	
	// Ne aplikacion zgjedhin te regjistrohen,logohen apo preferojne ta perdorin
	// N-klientë,admin,shippersa
	@OneToMany(mappedBy = "webAplication", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAppl;
	@Column(name = "appname")
	private String appname;
	@Column(name = "serialNo")
	private String serialNo;

	public WebAplication() {
		super();
	}

	public WebAplication(String appname, String serialNo, List<User> users) {
		super();
		this.appname = appname;
		this.serialNo = serialNo;
		this.users = users;
		
	}

	@Override
	public Integer getId() {
		return idAppl;
	}

	public void setIdAppl(Integer idAppl) {
		this.idAppl = idAppl;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
public User getAdminWebAplication() {
		return adminWebAplication;
	}

	public void setAdminWebAplication(User adminWebAplication) {
		this.adminWebAplication = adminWebAplication;
	}
	public String toString() {
		return "WebApplication[idAppl = " + idAppl + ",appname = " + appname + ",serialNo = " + serialNo + ",users = "
				+ users + ",adminWebAplication = " + adminWebAplication+"]";
	}

	

	
}
