package com.project.demo.sushiCo.domain.dto;

import java.sql.Date;
import java.sql.Time;

import com.project.demo.sushiCo.entity.Restorant_tables;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomerReservationDto {
	private Integer cR_Id;
	@NotNull(message = "It's required")
	private Date reservationDate;
	@NotNull(message = "It's required")
	private Time start_reservationTime;
	@NotNull(message = "It's required")
	private Time end_reservationTime;
	@NotNull(message = "It's required")
	@Size(min = 12, max = 60, message = "It's min is 12 persons and maximum is 60 participants")
	private Integer noParticipants;
	@NotNull(message = "It's required")
	@Size(min = 300, max = 1000, message = "Description should be with a minimum of 300 characters and with a maximum of 1000 characters")
	private String reservationDescription;
	private Integer customerId;
	private String customerName;
	private Restorant_tables tables;

	public CustomerReservationDto() {

	}

	public CustomerReservationDto(Integer cR_Id, Date reservationDate, Time start_reservationTime,Time end_reservationTime, Integer noParticipants,
			String reservationDescription, Integer customerId, String customerName, Restorant_tables tables) {
		this.cR_Id = cR_Id;
		this.reservationDate = reservationDate;
		this.start_reservationTime = start_reservationTime;
		this.end_reservationTime = end_reservationTime;
		this.noParticipants = noParticipants;
		this.reservationDescription = reservationDescription;
		this.setCustomerId(customerId);
		this.setCustomerName(customerName);
		this.setTables(tables);
		
	}

	public Integer getcR_Id() {
		return cR_Id;
	}

	public void setcR_Id(Integer cR_Id) {
		this.cR_Id = cR_Id;
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

	public void setStart_reservationTime(Time reservationTime) {
		this.start_reservationTime = reservationTime;
	}
	public Time getEnd_reservationTime() {
		return end_reservationTime;
	}

	public void setEnd_reservationTime(Time reservationTime) {
		this.end_reservationTime = reservationTime;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

    public Restorant_tables getTables() {
		return tables;
	}

	public void setTables(Restorant_tables tables) {
		this.tables = tables;
	}
	public String toString() {
		return "CustomerReservation[cR_Id = " + cR_Id + ",reservationDate = " + reservationDate + ",start_reservationTime = "
				+ start_reservationTime + ",end_reservationTime = " +end_reservationTime+ ",noParticipants = " + noParticipants + ",reservationDescription = "
				+ reservationDescription + ",customerId = " + customerId + ",customerName = " + customerName
				+ ",tables = " + tables + "]";
	}
}
