package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.BookingProcessing;
import com.project.demo.sushiCo.entity.Restorant;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RestorantTablesDto {

	private Integer rtb_id;
	private Integer tb_id;
	@NotNull(message = "It's not required ")
	private String tableName;
	@NotNull(message = "It's Required")
	private Integer noTables;
	private Integer availableTables;
	@NotNull(message = "It's required !")
	private Integer lockedTables;
	@Size(min = 140, max = 300, message = " It's at minimum with 140 character and at maximum with 300 characters")
	@NotNull(message = "It's required")
	private String tableDescription;
	@NotNull(message = "It's Required ")
	private Integer noChairsT;
	private BookingProcessing reservation;
	private Restorant aRest;
	private Integer adminRId;

	public RestorantTablesDto() {

	}

	public RestorantTablesDto(Integer rtb_id, Integer tb_id, String tableName, Integer noTables,
			Integer availableTables, Integer lockedTables, String tableDescription, Integer noChairsT,
			BookingProcessing reservation, Restorant aRest, Integer adminRId) {
		this.rtb_id = rtb_id;
		this.tb_id = tb_id;
		this.tableName = tableName;
		this.setNoTables(noTables);
		this.setAvailableTables(availableTables);
		this.setLockedTables(lockedTables);
		this.setTableDescription(tableDescription);
		this.noChairsT = noChairsT;
		this.reservation = reservation;
		this.aRest = aRest;
		this.adminRId = adminRId;
	}

	public Integer getRtb_id() {
		return rtb_id;
	}

	public void setRtb_id(Integer rtb_id) {
		this.rtb_id = rtb_id;
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

	public Integer getNoTables() {
		return noTables;
	}

	public void setNoTables(Integer noTables) {
		this.noTables = noTables;
	}

	public Integer getAvailableTables() {
		return availableTables;
	}

	public void setAvailableTables(Integer availableTables) {
		this.availableTables = availableTables;
	}

	public Integer getLockedTables() {
		return lockedTables;
	}

	public void setLockedTables(Integer lockedTables) {
		this.lockedTables = lockedTables;
	}

	public String getTableDescription() {
		return tableDescription;
	}

	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}

	public Integer getNoChairsT() {
		return noChairsT;
	}

	public void setNoChairsT(Integer noChairsT) {
		this.noChairsT = noChairsT;
	}

	public BookingProcessing getReservation() {
		return reservation;
	}

	public void setReservation(BookingProcessing reservation) {
		this.reservation = reservation;
	}

	public Restorant getARest() {
		return aRest;
	}

	public void setARest(Restorant aRest2) {
		this.aRest = aRest2;
	}

	public Integer getAdminRId() {
		return adminRId;
	}

	public void setAdminRId(Integer adminRId) {
		this.adminRId = adminRId;
	}

	public String toString() {
		return "return[rtb_id = " + rtb_id + ",tb_id = " + tb_id + ",tableName = " + tableName + ",noTables = "
				+ noTables + ",availableTables = " + availableTables + ",unAvailableTables = " + lockedTables
				+ ",description = " + tableDescription + ",noChairsT = " + noChairsT + ",reservation = " + reservation
				+ ",aRest = " + aRest + ",adminRId = " + adminRId + "]";
	}

}
