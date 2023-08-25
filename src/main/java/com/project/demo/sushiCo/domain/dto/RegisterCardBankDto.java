package com.project.demo.sushiCo.domain.dto;

import java.sql.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterCardBankDto {

	private Integer registrationId;
	@NotNull(message = "It's required")
	@Size(min = 16, max = 20, message = "This contains at least 16 characters which are all numbers")
	private String BankId;
	@NotBlank
	@NotNull(message = "It's required")
	private Date valid_from;
	@NotNull(message = "It's required")
	private Date expiredTime;
	@NotNull(message = "It's required")
	@Size(min = 3, message = "This secret or security Code can be  usually at least 3 characters")
	private Integer cardSecurityCode;
	private Integer userCardId;
	private String cardHolderName;
	private Integer idRestorant;
	private Integer pmId;
	private Integer custId;
	private Integer servPId;

	public RegisterCardBankDto() {

	}

	public RegisterCardBankDto(Integer registrationId, String BankId, Date valid_from, Date expiredTime,
			Integer cardSecurityCode, Integer userCardId, String cardHolderName, Integer idRestorant, Integer pmId,
			Integer custId, Integer servPId) {
		this.setRegistrationId(registrationId);
		this.BankId = BankId;
		this.valid_from = valid_from;
		this.expiredTime = expiredTime;
		this.cardSecurityCode = cardSecurityCode;
		this.setUserCardId(userCardId);
		this.setCardHolderName(cardHolderName);
		this.idRestorant = idRestorant;
		this.pmId = pmId;
		this.custId = custId;
		this.servPId = servPId;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getBankId() {
		return BankId;
	}

	public void setBankId(String BankId) {
		this.BankId = BankId;
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

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Integer getUserCardId() {
		return userCardId;
	}

	public void setUserCardId(Integer userCardId) {
		this.userCardId = userCardId;
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

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getServPId() {
		return servPId;
	}

	public void setServPId(Integer servPId) {
		this.servPId = servPId;
	}

	public String toString() {
		return "CardBank[id = " + registrationId + ",BankId = " + BankId + ",valid_from = " + valid_from
				+ ",expiredTime = " + expiredTime + ",cardSecurityCode = " + cardSecurityCode + ", userCardId = "
				+ userCardId + ",cardHolderName = " + cardHolderName + ",idRestorant = " + idRestorant + ",pmId = "
				+ pmId + ",custId = " + custId + ",servPId =" + servPId + "]";
	}

}
