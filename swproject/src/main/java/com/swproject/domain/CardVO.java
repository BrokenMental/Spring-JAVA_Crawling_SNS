package com.swproject.domain;

import java.util.Arrays;

public class CardVO {
	private boolean val[] = new boolean[15];
	private String sent;

	public boolean[] getVal() {
		return val;
	}

	public void setVal(boolean[] val) {
		this.val = val;
	}

	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
		this.sent = sent;
	}
	
	@Override
	public String toString() {
		return "CardVO [val=" + Arrays.toString(val) + ", sent=" + sent + "]";
	}

}
