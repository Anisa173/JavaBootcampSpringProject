package com.project.demo.sushiCo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class RestorantTables extends BasicEntity<Integer> {
    //'Mjedisi fizik' i restorantit i nderlidhet çdo rezervimi
	@OneToOne(mappedBy = "tables",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	private BookingProcessing reservation;

	//Çdo mjedis i arreduar "si per restorant" i perket nje restoranti
	@OneToOne(mappedBy = "restorantTables", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private Restorant aRest;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rtb_id;
	@Column(name = "tb_id")
	private Integer tb_id;
	@Column(name = "tableName")
	private String tableName;
	@Column(name = "noTables")
	private Integer noTables;
	@Column(name = "noChairsT")
	private Integer noChairsT;
	@Column(name = "availableTables")
	private Integer availableTables;
	@Column(name = "lockedTables")
	private Integer lockedTables;
	@Column(name = "tableDescription")
	private String tableDescription;

	public RestorantTables() {
		super();
	}

	public RestorantTables(Integer tb_id, String tableName, Integer noTables, Integer noChairsT,
			Integer availableTables, Integer lockedTables, String tableDescription, BookingProcessing reservation,
			Restorant aRest) {
		super();
		this.tb_id = tb_id;
		this.tableName = tableName;
		this.setNoTables(noTables);
		this.setNoChairsT(noChairsT);
		this.availableTables = availableTables;
		this.setLockedTables(lockedTables);
		this.tableDescription = tableDescription;
		this.reservation = reservation;
		this.aRest = aRest;
	}

	@Override
	public Integer getId() {
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

	public Integer getNoChairsT() {
		return noChairsT;
	}

	public void setNoChairsT(Integer noChairsT) {
		this.noChairsT = noChairsT;
	}

	public int getAvailableTables() {
		return availableTables;
	}

	public void setAvailableTables(int availableTables) {
		this.availableTables = availableTables;
	}

	public Integer getLockedTables() {
		return lockedTables;
	}

	public void setLockedTables(Integer unAvailableTables) {
		this.lockedTables = unAvailableTables;
	}

	public String getTableDescription() {
		return tableDescription;
	}

	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
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

	public void setReservation(Restorant aRest) {
		this.aRest = aRest;
	}

	public String toString() {
		return "RestorantTables[rtb_id = " + rtb_id + ",tb_id = " + tb_id + ",tableName = " + tableName + ",noTables = "
				+ noTables + ",noChairsTable = " + noChairsT + ",availableTables = " + availableTables
				+ ",unAvailableTables = " + lockedTables + " ,tableDescription = " + tableDescription
				+ ",reservation = " + reservation + ",aRest = " + aRest + "]";
	}

}
