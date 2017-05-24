package com.swproject.controller;

import java.util.List;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
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
import com.swproject.domain.CrawlerVO;
import com.swproject.domain.PageMaker;
import com.swproject.domain.SearchCriteria;
import com.swproject.service.CrawlService;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Controller
@RequestMapping("/Crawl/*")
public class CrawlController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	@Inject
	private CrawlService service;
	
	@RequestMapping(value = "/CrawlList", method = {RequestMethod.GET, RequestMethod.POST})
	public void CrawlPage1(@ModelAttribute("cri") SearchCriteria cri, @ModelAttribute("el") Elements el, CrawlerVO Crawl, Model model) throws Exception {
		CrawlerNews Craw = new CrawlerNews();
		Craw.setURL("https://news.google.co.kr");
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("div.esc-lead-article-title-wrapper a"));
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd. HH:mm:ss"); // yyyy.MM.dd. HH:mm:ss
		String now = formatter.format(new java.util.Date());
		Crawl.setC_Time(now);
		
		el = Craw.getEl();
		//model.addAttribute("list1", el);

		for (Element temp : el) { // 페이지에 뿌려주는것과 DB에 넣어주는것을 따로 해야한다.
			Crawl.setC_Group("News");
			Crawl.setN_Title(temp.text().toString());
			Crawl.setURL(temp.attr("href").toString());

			service.create1(Crawl);
		}

		System.out.println(Crawl);
		model.addAttribute("list1",service.listCrawl1(Crawl));
		
		logger.info("CrawlPage1 .........");
		
		// 페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/CrawlList2", method = {RequestMethod.GET, RequestMethod.POST})
	public void CrawlPage2(CrawlerVO Crawl, Model model) throws Exception {
		CrawlerSNS CS = new CrawlerSNS();
		CS.setTwitter(TwitterFactory.getSingleton());
		Twitter gt = CS.getTwitter();
		CS.setUser(gt.verifyCredentials());
		CS.setList(gt.getHomeTimeline());
		List<Status> cl = CS.getList();

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd. HH:mm:ss"); // yyyy.MM.dd. HH:mm:ss
		String now = formatter.format(new java.util.Date());
		Crawl.setC_Time(now);

		//model.addAttribute("list2", cl);

		for (Status temp1 : cl) {
			Crawl.setC_Group("SNS");
			Crawl.setS_User(temp1.getUser().getScreenName().toString());
			Crawl.setS_Content(temp1.getText().toString());

			service.create2(Crawl);
		}

		System.out.println(Crawl);
		model.addAttribute("list2",service.listCrawl2(Crawl));

		logger.info("CrawlPage2 .........");
	}

}
