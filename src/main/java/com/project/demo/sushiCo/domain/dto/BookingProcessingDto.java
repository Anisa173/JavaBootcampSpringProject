package com.project.demo.sushiCo.domain.dto;

import java.sql.Date;
import java.sql.Time;
import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookingProcessingDto {

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
	private Integer reservationId;
	private String tableName;

	public BookingProcessingDto() {

	}

	public BookingProcessingDto(Integer cR_Id, Date reservationDate, Time start_reservationTime,
			Time end_reservationTime, Integer noParticipants, String reservationDescription, Integer customerId,
			String customerName, Integer reservationId, String tableName) {
		this.cR_Id = cR_Id;
		this.reservationDate = reservationDate;
		this.start_reservationTime = start_reservationTime;
		this.end_reservationTime = end_reservationTime;
		this.noParticipants = noParticipants;
		this.reservationDescription = reservationDescription;
		this.setCustomerId(customerId);
		this.setCustomerName(customerName);
		this.reservationId = reservationId;
		this.setTableName(tableName);

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

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String toString() {
		return "BookingProcessing[cR_Id = " + cR_Id + ",reservationDate = " + reservationDate
				+ ",start_reservationTime = " + start_reservationTime + ",end_reservationTime = " + end_reservationTime
				+ ",noParticipants = " + noParticipants + ",reservationDescription = " + reservationDescription
				+ ",customerId = " + customerId + ",customerName = " + customerName + ",reservationId = "
				+ reservationId + ",tableName = " + tableName + "]";
	}
}
