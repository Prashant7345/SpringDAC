package com.met.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/*@DiscriminatorValue(value="CARD")*/
public class CardPayment extends Payment{

	@Column(length=12)
	private String cardNo;
	
	@Column(length=12)
	private String cardType;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	
	
	
}
