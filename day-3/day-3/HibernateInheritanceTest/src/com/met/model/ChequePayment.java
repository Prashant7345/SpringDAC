package com.met.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/*@DiscriminatorValue(value="CHEQUE")*/
public class ChequePayment extends Payment{

	@Column(length=12)
	private String chequeNo;
	@Column(length=12)
	private String bankName;
	
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
	
}
