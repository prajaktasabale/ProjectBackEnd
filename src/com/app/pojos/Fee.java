package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Fee
{
	private double totalFee;
	private double paid;
	private double notPaid;
	
	public Fee() {
		System.out.println("in ctor of fee");
	}

	public Fee(double totalFee, double paid, double notPaid) {
		super();
		this.totalFee = totalFee;
		this.paid = paid;
		this.notPaid = notPaid;
	}
	
	@Column(name = "total_fee")
	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	@Column(name = "fee_paid")
	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	@Column(name = "fee_not_paid")
	public double getNotPaid() {
		return notPaid;
	}

	public void setNotPaid(double notPaid) {
		this.notPaid = notPaid;
	}

	@Override
	public String toString() {
		return "Fee [totalFee=" + totalFee + ", paid=" + paid + ", notPaid=" + notPaid + "]";
	}
}
