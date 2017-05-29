package com.swproject.domain;

public class CrawlerVO {

	private Integer C_Number;
	private String C_Group;
	private String N_Title;
	private String URL;
	private String S_Content;
	private String S_User;
	private String C_Time;

	public String getC_Time() {
		return C_Time;
	}
	public void setC_Time(String c_Time) {
		C_Time = c_Time;
	}
	public String getS_User() {
		return S_User;
	}
	public void setS_User(String s_User) {
		S_User = s_User;
	}
	public int getC_Number() {
		return C_Number;
	}
	public void setC_Number(Integer c_Number) {
		C_Number = c_Number;
	}
	public String getC_Group() {
		return C_Group;
	}
	public void setC_Group(String c_Group) {
		C_Group = c_Group;
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
	
	@Override
	public String toString() {
		return "CrawlerVO [C_Number=" + C_Number + ", C_Group=" + C_Group + ", N_Title=" + N_Title + ", URL=" + URL
				+ ", S_Content=" + S_Content + ", S_User=" + S_User + ", C_Time=" + C_Time + ", getC_Time()="
				+ getC_Time() + ", getS_User()=" + getS_User() + ", getC_Number()=" + getC_Number() + ", getC_Group()="
				+ getC_Group() + ", getN_Title()=" + getN_Title() + ", getURL()=" + getURL() + ", getS_Content()="
				+ getS_Content() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
