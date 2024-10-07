package com.project.demo.sushiCo.domain.dto;

import java.sql.Date;
import java.sql.Time;
import com.project.demo.sushiCo.entity.RestorantTables;

public class RegisterBookingFormDto {
	private Integer crId;
	private String First_name;
	private String Last_name;
	private String phoneNo;
	private Date reservationDate;
	private Time start_reservationTime;
	private Time end_reservationTime;
	private Integer noParticipants;
	private String reservationDescription;
	private RestorantTables tables;
	private Integer idCustomer;
	private Integer rtb_id;

	public RegisterBookingFormDto(Integer crId, String First_name, String Last_name, String phoneNo,
			Date reservationDate, Time start_reservationTime, Time end_reservationTime, Integer noParticipants,
			String reservationDescription, RestorantTables tableName, Integer idCustomer, Integer rtb_id) {
		this.crId = crId;
		this.First_name = First_name;
		this.Last_name = Last_name;
		this.phoneNo = phoneNo;
		this.reservationDate = reservationDate;
		this.start_reservationTime = start_reservationTime;
		this.end_reservationTime = end_reservationTime;
		this.noParticipants = noParticipants;
		this.reservationDescription = reservationDescription;
		this.tables = tableName;
		this.idCustomer = idCustomer;
		this.setRtb_id(rtb_id);
	}

	public RegisterBookingFormDto() {

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

	public RestorantTables getTables() {
		return tables;
	}

	public void setTables(RestorantTables tableName) {
		this.tables = tableName;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getRtb_id() {
		return rtb_id;
	}

	public void setRtb_id(Integer rtb_id) {
		this.rtb_id = rtb_id;
	}

	public String toString() {
		return "RegisterBookingFormDto[crId = " + crId + ", First_name = " + First_name + ",Last_name = " + Last_name
				+ ",phoneNo = " + phoneNo + ", reservationDate = " + reservationDate + ",start_reservationTime = "
				+ start_reservationTime + ", end_reservationTime = " + end_reservationTime + ",noParticipants = "
				+ noParticipants + ", reservationDescription = " + reservationDescription + ",tableName = " + tables
				+ ",idCustomer = " + idCustomer + ",id = " + rtb_id + "]";

	}

}