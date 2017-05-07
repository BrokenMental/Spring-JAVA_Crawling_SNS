package com.swproject.domain;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class CrawlerSNS {
	
		private Twitter twitter;
		private User user;
		private List<Status> list;
		
		public Twitter getTwitter() {
			return twitter;
		}
		public void setTwitter(Twitter twitter) {
			this.twitter = twitter;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public List<Status> getList() {
			return list;
		}
		public void setList(List<Status> list) {
			this.list = list;
		}
		
		@Override
		public String toString() {
			return "CrawlerSNS [twitter=" + twitter + ", user=" + user + ", list=" + list + ", getTwitter()="
					+ getTwitter() + ", getUser()=" + getUser() + ", getList()=" + getList() + ", getClass()="
					+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		
}
