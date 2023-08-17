package com.project.demo.sushiCo.entity;

import java.sql.Date;


import groovy.transform.builder.Builder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;


@Builder
@AllArgsConstructor
@Entity
public class CardBank extends BasicEntity<Integer> {

	// Nje ose shumë karta mund të posedohen nga nje user
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userCardId", referencedColumnName = "id")
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "BankId")
	private String BankId;
	@Column(name = "valid_from")
	private Date valid_from;
	@Column(name = "expiredTime")
	private Date expiredTime;
	@Column(name = "cardSecurityCode")
	private Integer cardSecurityCode;

	public CardBank() {
		super();

	}

	public CardBank(String Id, Date datevalid_from, Date expiredTime, Integer cardSecurityCode, User user) {
		super();
		this.BankId = Id;
		this.valid_from = datevalid_from;
		this.expiredTime = expiredTime;
		this.cardSecurityCode = cardSecurityCode;
		this.user = user;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankId() {
		return BankId;
	}

	public void setBankId(String id) {
		this.BankId = id;
	}

	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date datevalid_from) {
		this.valid_from = datevalid_from;
	}

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Integer getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(Integer cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString() {
		return "CardBank[id = " + id + ",BankId = " + BankId + ",datevalid_from = " + valid_from + ",expiredTime = "
				+ expiredTime + ",cardSecurityCode = " + cardSecurityCode + ",user = " + user + "]";
	}

}
