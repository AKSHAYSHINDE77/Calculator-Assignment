package com.yash.cal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="calculator")
public class Calculator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String inserted;
	private String sign;
	private double result;
	
	public Calculator() {
		super();
	}

	public Calculator(int cid, String inserted, String sign, double result) {
		super();
		this.cid = cid;
		this.inserted = inserted;
		this.sign = sign;
		this.result = result;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getInserted() {
		return inserted;
	}

	public void setInserted(String inserted) {
		this.inserted = inserted;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Calculator [cid=" + cid + ", inserted=" + inserted + ", sign=" + sign + ", result=" + result + "]";
	}

	
	
	
	
}
