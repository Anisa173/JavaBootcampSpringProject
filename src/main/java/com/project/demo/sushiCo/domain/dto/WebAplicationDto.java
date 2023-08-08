package com.project.demo.sushiCo.domain.dto;

public class WebAplicationDto {
	private String idAppl;
	private String appname;
	private String serialNo;
	private Long totalUsers;
	private Long totalRestorants;

	public WebAplicationDto() {

	}

	public WebAplicationDto(String idAppl, Long totalRestorants, String appname, String serialNo, Long totalUsers) {
		this.idAppl = idAppl;
		this.appname = appname;
		this.serialNo = serialNo;
		this.totalUsers = totalUsers;
		this.totalRestorants = totalRestorants;
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

	public String toString() {
		return "WebAplicationDto[idAppl = " + idAppl + ",appname = " + appname + ",serialNo = " + serialNo
				+ ",totalUsers = " + totalUsers + ",totalRestorants = " + totalRestorants + "]";
	}

}
