package com.project.demo.sushiCo.service;

import java.sql.Date;
import java.sql.Time;

import com.project.demo.sushiCo.entity.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterBookingForm extends BasicEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer crId;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = " phoneNo")
	private String phoneNo;
	@Column(name = "reservationDate")
	private Date reservationDate;
	@Column(name = "start_reservationTime")
	private Time start_reservationTime;
	@Column(name = "end_reservationTime")
	private Time end_reservationTime;
	@Column(name = "noParticipants")
	private Integer noParticipants;
	@Column(name = "reservationDescription")
	private String reservationDescription;
	@Column(name = "tableName")
	private String tableName;
	@Column(name = "noTables")
	private Integer noTables;
	@Column(name = "lockedTables")
	private Integer lockedTables;
	private Integer idCustomer;
	private Integer idRestorant;

	@Override
	public Integer getId() {
		return crId;
	}

	public void setCrId(Integer id) {
		this.crId = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Time getStart_reservationTime() {
		return start_reservationTime;
	}

	public void setStart_reservationTime(Time start_reservationTime) {
		this.start_reservationTime = start_reservationTime;
	}

	public Time getEnd_reservationTime() {
		return end_reservationTime;
	}

	public void setEnd_reservationTime(Time end_reservationTime) {
		this.end_reservationTime = end_reservationTime;
	}

	public Integer getNoParticipants() {
		return noParticipants;
	}

	public void setNoParticipants(Integer noParticipants) {
		this.noParticipants = noParticipants;
	}

	public String getReservationDescription() {
		return reservationDescription;
	}

	public void setReservationDescription(String reservationDescription) {
		this.reservationDescription = reservationDescription;
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

	public Integer getLockedTables() {
		return lockedTables;
	}

	public void setLockedTables(Integer lockedTables) {
		this.lockedTables = lockedTables;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;

	}

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public String toString() {
		return "RegisterBookingForm[crId = " + crId + ",first_name = " + first_name + ",last_name = " + last_name
				+ ",phoneNo = " + phoneNo + ",reservationDate = " + reservationDate + ",start_reservationTime = "
				+ start_reservationTime + ",start_reservationTime = " + start_reservationTime
				+ ",end_reservationTime = " + end_reservationTime + ",noParticipants = " + noParticipants
				+ ",reservationDescription = " + reservationDescription + ",tableName = " + tableName + ",noTables = "
				+ noTables + ",lockedTables = " + lockedTables + ",idCustomer = " + idCustomer + ",idRestorant = "
				+ idRestorant + "]";
	}

}
