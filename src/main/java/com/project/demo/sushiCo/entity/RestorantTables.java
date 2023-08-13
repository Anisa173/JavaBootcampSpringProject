package com.project.demo.sushiCo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.demo.sushiCo.domain.dto.Getter;
import com.project.demo.sushiCo.domain.dto.Setter;

import groovy.transform.builder.Builder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class RestorantTables extends BasicEntity<Integer> {
//  'Mjedisi fizik' i restorantit i nderlidhet çdo rezervimi
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservationId", referencedColumnName = "cR_id")
	@JsonManagedReference
	private BookingProcessing reservation;

	// Çdo mjedis i arreduar "si per restorant" i perket nje restoranti
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
	@Column(name = "availableTables")
	private Integer availableTables;
	@Column(name = "unAvailableTables")
	private Integer unAvailableTables;
	@Column(name = "tableDescription")
	private String tableDescription;
	

	public RestorantTables() {
		super();
	}

	public RestorantTables(Integer tb_id, String tableName, Integer noTables, Integer availableTables,
			Integer unAvailableTables,String tableDescription, BookingProcessing reservation,
			Restorant aRest) {
		super();
		this.tb_id = tb_id;
		this.tableName = tableName;
		this.setNoTables(noTables);
		this.availableTables = availableTables;
		this.setUnAvailableTables(unAvailableTables);
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

	public int getAvailableTables() {
		return availableTables;
	}

	public void setAvailableTables(int availableTables) {
		this.availableTables = availableTables;
	}

	public Integer getUnAvailableTables() {
		return unAvailableTables;
	}

	public void setUnAvailableTables(Integer unAvailableTables) {
		this.unAvailableTables = unAvailableTables;
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
				+ noTables + ",availableTables = " + availableTables + ",unAvailableTables = " + unAvailableTables
				+ " ,tableDescription = " + tableDescription + ",reservation = " + reservation
				+ ",aRest = " + aRest + "]";
	}

}
