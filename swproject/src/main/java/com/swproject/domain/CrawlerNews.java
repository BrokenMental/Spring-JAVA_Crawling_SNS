package com.swproject.domain;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlerNews {
	
	private String URL;
	private Document doc;
	private Elements el;
	
	
	public String getURL() {
		return URL;
	}


	public void setURL(String uRL) {
		URL = uRL;
	}


	public Document getDoc() {
		return doc;
	}


	public void setDoc(Document doc) {
		this.doc = doc;
	}


	public Elements getEl() {
		return el;
	}


	public void setEl(Elements el) {
		this.el = el;
	}


}
