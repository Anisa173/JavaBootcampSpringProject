package com.project.demo.sushiCo.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WebAplicationDto {
	private Integer idAppl;
	@NotNull(message = "It's required")
	@Size(min = 3, max = 20, message = "This can be between 3 ad 20 characters")
	private String appname;
	private Integer adminWebId;
	private String serialNo;
	private Long totalUsers;
	private Long totalRestorants;


	public WebAplicationDto() {

	}

	public WebAplicationDto(Integer idAppl, Long totalRestorants, String appname, String serialNo, Long totalUsers,Integer adminWebId) {
		this.idAppl = idAppl;
		this.appname = appname;
		this.serialNo = serialNo;
		this.totalUsers = totalUsers;
		this.totalRestorants = totalRestorants;
	this.adminWebId = adminWebId;
	}

	public Long getTotalRestorants() {
		return totalRestorants;
	}

	public void setTotalRestorants(Long totalRestorants) {
		this.totalRestorants = totalRestorants;
	}

	public Integer getIdAppl() {
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

	public Long getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(Long totalUsers) {
		this.totalUsers = totalUsers;
	}

	public Integer getAdminWebId() {
		return adminWebId;
	}

	public void setAdminWebId(Integer adminWebId) {
		this.adminWebId = adminWebId;
	}

	public String toString() {
		return "WebAplicationDto[idAppl = " + idAppl + ",appname = " + appname + ",serialNo = " + serialNo
				+ ",totalUsers = " + totalUsers + ",totalRestorants = " + totalRestorants + ",adminWebId = " +adminWebId+ "]";
	}

	

}
