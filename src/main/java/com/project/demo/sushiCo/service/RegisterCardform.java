package com.project.demo.sushiCo.service;

import java.sql.Date;

import com.project.demo.sushiCo.entity.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
public class RegisterCardform extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registrationId;
	@Column(name = "BankId")
	private String BankId;
	@Column(name = "valid_from")
	private Date valid_from;
	@Column(name = "expiredTime")
	private Date expiredTime;
	@Column(name = "cardSecurityCode")
	private Integer cardSecurityCode;
	private Integer idRestorant;
	private Integer pmId;
	private Integer userCardId;

	@Override
	public Integer getId() {
		return registrationId;
	}

	public void setRegistrationId(Integer id) {
		this.registrationId = id;
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

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
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

	public Integer getIdRestorant() {
		return idRestorant;
	}

	public void setIdRestorant(Integer idRestorant) {
		this.idRestorant = idRestorant;
	}

	public Integer getPmId() {
		return pmId;
	}

	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}

	public Integer getUserCardId() {
		return userCardId;
	}

	public void setUserCardId(Integer userCardId) {
		this.userCardId = userCardId;
	}

	public String toString() {
		return "RegisterCardform[registrationId = " + registrationId + ",BankId = " + BankId + ",valid_from = "
				+ valid_from + ",expiredTime = " + expiredTime + ",cardSecurityCode = " + cardSecurityCode
				+ ",idRestorant = " + idRestorant + ",userCardId = " + userCardId + " ]";
	}

}
