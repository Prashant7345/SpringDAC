package com.met.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="payType", length=8)
@DiscriminatorValue(value="CASH")*/

/*@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)*/

@Inheritance(strategy=InheritanceType.JOINED)

public class Payment {

	@Id
	@Column(name="pay_id")
	@GeneratedValue
	private int id;
	private double amount;
	private Date payDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	
	
}
