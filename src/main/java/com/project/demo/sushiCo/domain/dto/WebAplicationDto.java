package com.project.demo.sushiCo.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WebAplicationDto {
	private String idAppl;
	@NotNull(message = "It's required")
	@Size(min = 3, max = 20, message = "This can be between 3 ad 20 characters")
	private String appname;

	private String serialNo;
	private Long totalUsers;
	private Long totalRestorants;
	private Long totalUser;

	public WebAplicationDto() {

	}

	public WebAplicationDto(String idAppl, Long totalRestorants, String appname, String serialNo, Long totalUsers,
			Long totalUser) {
		this.idAppl = idAppl;
		this.appname = appname;
		this.serialNo = serialNo;
		this.totalUsers = totalUsers;
		this.totalRestorants = totalRestorants;
		this.totalUser = totalUser;
	}

	public Long getTotalRestorants() {
		return totalRestorants;
	}

	public void setTotalRestorants(Long totalRestorants) {
		this.totalRestorants = totalRestorants;
	}

	public String getIdAppl() {
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

	public Long getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(Long totalUsers) {
		this.totalUsers = totalUsers;
	}

	public Long getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(Long totalUser) {
		this.totalUser = totalUser;
	}

	public String toString() {
		return "WebAplicationDto[idAppl = " + idAppl + ",appname = " + appname + ",serialNo = " + serialNo
				+ ",totalUsers = " + totalUsers + ",totalRestorants = " + totalRestorants + ",totalUser = " + totalUser
				+ "]";
	}

}
