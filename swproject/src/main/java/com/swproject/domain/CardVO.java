package com.swproject.domain;

import java.util.Arrays;

public class CardVO {
	private String sent;
	private boolean val[] = new boolean[] {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

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

	@Override
	public String toString() {
		return "CardVO [val=" + Arrays.toString(val) + ", sent=" + sent + "]";
	}

}
