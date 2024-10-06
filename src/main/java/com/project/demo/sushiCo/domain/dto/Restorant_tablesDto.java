package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.AppRestorant;

public class Restorant_tablesDto {
	private Integer rtb_id;

	private Integer tb_id;

	private String tableName;

	private Integer noChairTable;

	private String description;

	private boolean status;

	private Integer reservationId;

	private String reservationDescription;

	private AppRestorant aRest;

	public Restorant_tablesDto() {

	}

	public Restorant_tablesDto(Integer rtb_id, Integer tb_id, String tableName, Integer noChairTable,
			String description, boolean status, Integer reservationId, String reservationDescription,
			AppRestorant aRest) {
		this.rtb_id = rtb_id;
		this.tb_id = tb_id;
		this.tableName = tableName;
		this.noChairTable = noChairTable;
		this.description = description;
		this.status = status;
		this.reservationId = reservationId;
		this.reservationDescription = reservationDescription;
		this.aRest = aRest;

	}

	public Integer getTb_id() {
		return tb_id;
	}

	public void setTb_id(Integer tb_id) {
		this.tb_id = tb_id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getNoChairTable() {
		return noChairTable;
	}

	public void setNoChairTable(Integer noChairTable) {
		this.noChairTable = noChairTable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationDescription() {
		return reservationDescription;
	}

	public void setReservationDescription(String reservationDescription) {
		this.reservationDescription = reservationDescription;
	}

	public Integer getRtb_id() {
		return rtb_id;
	}

	public void setRtb_id(Integer rtb_id) {
		this.rtb_id = rtb_id;
	}

	public AppRestorant getARest() {
		return aRest;
	}

	public void setARest(AppRestorant aRest2) {
		this.aRest = aRest2;
	}

	public String toString() {
		return "return[rtb_id = " + rtb_id + ",tb_id = " + tb_id + ",tableName = " + tableName + ",noChairTable = "
				+ noChairTable + ",description = " + description + ",status = " + status + ",reservationId = "
				+ reservationId + ",reservationDescription = " + reservationDescription + ",aRest = " + aRest + "]";
	}


}
