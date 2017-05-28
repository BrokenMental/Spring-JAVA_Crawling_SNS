package com.swproject.domain;

public class FeedVO {

	private String ID;
	private Integer F_Number;
	private String MyFeed;
	private String F_Time;
	private String F_Group;
	
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
	public String getF_Time() {
		return F_Time;
	}
	public void setF_Time(String f_Time) {
		F_Time = f_Time;
	}
	public String getF_Group() {
		return F_Group;
	}
	public void setF_Group(String f_Group) {
		F_Group = f_Group;
	}
	
	@Override
	public String toString() {
		return "FeedVO [ID=" + ID + ", F_Number=" + F_Number + ", MyFeed=" + MyFeed + ", F_Time=" + F_Time
				+ ", F_Group=" + F_Group + ", getID()=" + getID() + ", getF_Number()=" + getF_Number()
				+ ", getMyFeed()=" + getMyFeed() + ", getF_Time()=" + getF_Time() + ", getF_Group()=" + getF_Group()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
