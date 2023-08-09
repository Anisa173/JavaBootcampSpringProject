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
import jakarta.persistence.OneToMany;

@Entity
public class WebAplication extends BasicEntity<String> {

	// Admini i webApplication menaxhon te gjithe "userat" qe regjistrohen si :
	// 1)klientet qe rregjistrohen 2)adminin e çdo restoranti 3)shippers-at e çdo restoranti
	 

	@OneToMany(mappedBy = "AdminPlatforma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> user = new ArrayList<User>();

	// Ne aplikacion zgjedhin te regjistrohen,logohen apo preferojne ta perdorin
	// N-klientë
	@OneToMany(mappedBy = "webAplication", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();

	// Web_based Aplication permban disa restorante
	@OneToMany(mappedBy = "webAplication", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Restorant> restorants = new ArrayList<Restorant>();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idAppl;
	@Column(name = "appname")
	private String appname;
	@Column(name = "serialNo")
	private String serialNo;

	public WebAplication() {
		super();
	}

	public WebAplication(String appname, String serialNo, List<Restorant> restorants, List<User> users,
			List<User> user) {
		super();
		this.appname = appname;
		this.serialNo = serialNo;
		this.setRestorants(restorants);
		this.users = users;
		this.user = user;
	}

	@Override
	public String getId() {
		return idAppl;
	}

	public void setIdAppl(String idAppl) {
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

	public List<Restorant> getRestorants() {
		return restorants;
	}

	public void setRestorants(List<Restorant> restorants) {
		this.restorants = restorants;
	}

	public List<User> getUser() {

		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public String toString() {
		return "WebApplication[idAppl = " + idAppl + ",appname = " + appname + ",serialNo = " + serialNo + ",users = "
				+ users + ",user = " + user + ",restorants = " + restorants + "]";
	}

}
