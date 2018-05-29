package com.swproject.domain;

public class userVO {
	
	private String ID;
	private String PW;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	
	@Override
	public String toString() {
		return "userVO [ID=" + ID + ", PW=" + PW + ", getID()=" + getID() + ", getPW()=" + getPW() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
