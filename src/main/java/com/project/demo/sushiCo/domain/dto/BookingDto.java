package com.project.demo.sushiCo.domain.dto;

import java.sql.Date;
import java.sql.Time;

public class BookingDto {
	private Integer crId;
	private String First_name;
	private String Last_name;
	private String phoneNo;
	private Date reservationDate;
	private Time start_reservationTime;
	private Time end_reservationTime;
	private Integer noParticipants;
	private String reservationDescription;
	private String tableName;
	private Integer noTables;
	private Integer lockedTables;

	public BookingDto(Integer crId, String First_name, String Last_name, String phoneNo, Date reservationDate,
			Time start_reservationTime, Time end_reservationTime, Integer noParticipants, String reservationDescription,
			String tableName, Integer noTables, Integer lockedTables) {
		this.crId = crId;
		this.First_name = First_name;
		this.Last_name = Last_name;
		this.phoneNo = phoneNo;
		this.reservationDate = reservationDate;
		this.start_reservationTime = start_reservationTime;
		this.end_reservationTime = end_reservationTime;
		this.noParticipants = noParticipants;
		this.reservationDescription = reservationDescription;
		this.tableName = tableName;
		this.noTables = noTables;
		this.lockedTables = lockedTables;
	}

	public Integer getCrId() {
		return crId;
	}

	public void setCrId(Integer crId) {
		this.crId = crId;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
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

	public String toString() {
		return "BookingDto[crId = " + crId + ", First_name = " + First_name + ",Last_name = " + Last_name
				+ ",phoneNo = " + phoneNo + ", reservationDate = " + reservationDate + ",start_reservationTime = "
				+ start_reservationTime + ", end_reservationTime = " + end_reservationTime + ",noParticipants = "
				+ noParticipants + ", reservationDescription = " + reservationDescription + ",tableName = " + tableName
				+ ", noTables = " + noTables + ", lockedTables = " + lockedTables + "]";

	}
}