package com.swproject.domain;

public class ViewVO {

	private String ID;
	private Integer F_Number;
	private String MyFeed;
	private String F_Time;
	private String F_Group;
	private String N_Title;
	private String URL;
	private String S_Content;
	private String S_User;
	private String C_Group;
	
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
	public String getN_Title() {
		return N_Title;
	}
	public void setN_Title(String n_Title) {
		N_Title = n_Title;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getS_Content() {
		return S_Content;
	}
	public void setS_Content(String s_Content) {
		S_Content = s_Content;
	}
	public String getS_User() {
		return S_User;
	}
	public void setS_User(String s_User) {
		S_User = s_User;
	}
	public String getF_Group() {
		return F_Group;
	}
	public void setF_Group(String f_Group) {
		F_Group = f_Group;
	}
	public String getC_Group() {
		return C_Group;
	}
	public void setC_Group(String c_Group) {
		C_Group = c_Group;
	}
	
	@Override
	public String toString() {
		return "ViewVO [ID=" + ID + ", F_Number=" + F_Number + ", MyFeed=" + MyFeed + ", F_Time=" + F_Time
				+ ", F_Group=" + F_Group + ", N_Title=" + N_Title + ", URL=" + URL + ", S_Content=" + S_Content
				+ ", S_User=" + S_User + ", C_Group=" + C_Group + ", getID()=" + getID() + ", getF_Number()="
				+ getF_Number() + ", getMyFeed()=" + getMyFeed() + ", getF_Time()=" + getF_Time() + ", getN_Title()="
				+ getN_Title() + ", getURL()=" + getURL() + ", getS_Content()=" + getS_Content() + ", getS_User()="
				+ getS_User() + ", getF_Group()=" + getF_Group() + ", getC_Group()=" + getC_Group() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
