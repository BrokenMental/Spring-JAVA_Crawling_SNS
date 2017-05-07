package com.swproject.controller;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swproject.domain.CrawlerNews;
import com.swproject.domain.CrawlerSNS;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Controller
@RequestMapping("/Crawl/*")
public class CrawlController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	@RequestMapping(value = "/CrawlList", method = RequestMethod.GET)
	public void CrawlPage(@ModelAttribute("el") Elements el, Model model) throws Exception {
		CrawlerNews Craw = new CrawlerNews();
		Craw.setURL("https://news.google.co.kr");
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("div.esc-lead-article-title-wrapper a"));

		el = Craw.getEl();
		model.addAttribute("list", el);

		logger.info("CrawlController .........1");
	}

	@RequestMapping(value = "/CrawlList2", method = RequestMethod.GET)
	public void CrawlPage2(Model model)  throws Exception {
		CrawlerSNS CS = new CrawlerSNS();
		CS.setTwitter(TwitterFactory.getSingleton());
		Twitter gt = CS.getTwitter();
		CS.setUser(gt.verifyCredentials());
	    CS.setList(gt.getHomeTimeline());
	    List<Status>cl = CS.getList();
	    
	    model.addAttribute("list2",cl);
	    
	    logger.info("CrawlController .........2");
	}
	
}
