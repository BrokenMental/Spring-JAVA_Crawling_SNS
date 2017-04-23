package com.swproject.domain;

import java.util.Date;

public class FeedVO {

	private String ID;
	private Integer F_Number;
	private String MyFeed;
	private Date F_Time;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Integer getF_Number() {
		return F_Number;
	}
	public void setF_Number(Integer f_Number) {
		F_Number = f_Number;
	}
	public String getMyFeed() {
		return MyFeed;
	}
	public void setMyFeed(String myFeed) {
		MyFeed = myFeed;
	}
	public Date getF_Time() {
		return F_Time;
	}
	public void setF_Time(Date f_Time) {
		F_Time = f_Time;
	}

	@Override
	public String toString() {
		return "FeedVO [ID=" + ID + ", F_Number=" + F_Number + ", MyFeed=" + MyFeed + ", F_Time=" + F_Time
				+ ", getID()=" + getID() + ", getF_Number()=" + getF_Number() + ", getMyFeed()=" + getMyFeed()
				+ ", getF_Time()=" + getF_Time() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
