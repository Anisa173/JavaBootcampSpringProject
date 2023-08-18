package com.project.demo.sushiCo.entity;

import java.sql.Date;
import java.sql.Time;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
	public class BookingProcessing extends BasicEntity<Integer> {
	
		//Nje apo disa rezervime mund te kryehen nga i njejti klient gjate punes ditore
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "customerId", referencedColumnName = "id")
		private User user;

        //Cdo rezervim kryhet ne te njejtin restorant fhe ne te njejten vendododhje
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "reservationId", referencedColumnName = "rtb_id")
		@JsonManagedReference
		private RestorantTables tables;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer cR_Id;
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

		public BookingProcessing() {
			super();
		}

		public BookingProcessing(Date reservationDate, Time start_reservationTime, Time end_reservationTime,
				Integer noParticipants, String reservationDescription, User user,RestorantTables tables) {
			super();
			this.reservationDate = reservationDate;
			this.start_reservationTime = start_reservationTime;
			this.end_reservationTime = end_reservationTime;
			this.noParticipants = noParticipants;
			this.reservationDescription = reservationDescription;
			this.user = user;
		this.setTables(tables);
		}

		@Override
		public Integer getId() {

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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	public RestorantTables getTables() {
			return tables;
		}

		public void setTables(RestorantTables tables) {
			this.tables = tables;
		}
		public String toString() {
			return "BookingProcessing[cR_Id = " + cR_Id + ",reservationDate = " + reservationDate
					+ ",start_reservationTime = " + start_reservationTime + ",noParticipants = " + noParticipants
					+ ",reservationDescription = " + reservationDescription + ",user = " + user + ",tables = " +tables+ "]";
		}

	}
