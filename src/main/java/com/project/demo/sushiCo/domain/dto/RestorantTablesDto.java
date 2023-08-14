package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.Restorant;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RestorantTablesDto {

	private Integer rtb_id;

	private Integer tb_id;

	private String tableName;

	private Integer noTables;
	
	private Integer availableTables;
	
	private Integer lockedTables;
	
	private String tableDescription;

	private Integer noChairsT;

	private Integer reservationId;

	private String reservationDescription;

	private Restorant aRest;

	public RestorantTablesDto() {

	}

	public RestorantTablesDto(Integer rtb_id, Integer tb_id, String tableName, Integer noTables,
			Integer availableTables, Integer lockedTables, String tableDescription, Integer noChairsT,
			Integer reservationId, String reservationDescription, Restorant aRest) {
		this.rtb_id = rtb_id;
		this.tb_id = tb_id;
		this.tableName = tableName;
		this.setNoTables(noTables);
		this.setAvailableTables(availableTables);
		this.setLockedTables(lockedTables);
		this.setTableDescription(tableDescription);
		this.noChairsT = noChairsT;
		this.reservationId = reservationId;
		this.reservationDescription = reservationDescription;
		this.aRest = aRest;

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

	public Restorant getARest() {
		return aRest;
	}

	public void setARest(Restorant aRest2) {
		this.aRest = aRest2;
	}

	public String toString() {
		return "return[rtb_id = " + rtb_id + ",tb_id = " + tb_id + ",tableName = " + tableName + ",noTables = "
				+ noTables + ",availableTables = " + availableTables + ",unAvailableTables = " + lockedTables
				+ ",description = " + tableDescription + ",noChairsT = " + noChairsT + ",reservationId = "
				+ reservationId + ",reservationDescription = " + reservationDescription + ",aRest = " + aRest + "]";
	}

}
