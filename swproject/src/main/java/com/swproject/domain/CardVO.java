package com.swproject.domain;

import java.util.Arrays;

public class CardVO {
	private String sent;
	private boolean val[] = new boolean[] {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private String user;
	
	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
		this.sent = sent;
	}
	
	public boolean[] getVal() {
		return val;
	}

	public void setVal(boolean[] val) {
		this.val = val;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CardVO [val=" + Arrays.toString(val) + ", sent=" + sent + "]";
	}

}
