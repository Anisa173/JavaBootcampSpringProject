package com.project.demo.sushiCo.domain.dto;

import java.sql.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CardBankDto {

	private Integer id;
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

	public CardBankDto() {

	}

	public CardBankDto(Integer id, String BankId, Date valid_from, Date expiredTime, Integer cardSecurityCode,
			Integer userCardId, String cardHolderName) {
		this.id = id;
		this.BankId = BankId;
		this.valid_from = valid_from;
		this.expiredTime = expiredTime;
		this.cardSecurityCode = cardSecurityCode;
		this.setUserCardId(userCardId);
		this.setCardHolderName(cardHolderName);
	}

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public Integer getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(Integer cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	public String getBankId() {
		return BankId;
	}

	public void setBankId(String BankId) {
		this.BankId = BankId;
	}

	public Integer getUserCardId() {
		return userCardId;
	}

	public void setUserCardId(Integer userCardId) {
		this.userCardId = userCardId;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "CardBank[id = " + id + ",BankId = " + BankId + ",valid_from = " + valid_from + ",expiredTime = "
				+ expiredTime + ",cardSecurityCode = " + cardSecurityCode + ", userCardId = " + userCardId
				+ ",cardHolderName = " + cardHolderName + "]";
	}

}
