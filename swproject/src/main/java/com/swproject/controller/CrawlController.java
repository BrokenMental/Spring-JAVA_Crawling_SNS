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
import com.swproject.persistence.CrawlDAO;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Controller
@RequestMapping("/Crawl/*")
public class CrawlController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);
	
	@Inject
	private CrawlDAO dao;

	@RequestMapping(value = "/CrawlList", method = RequestMethod.GET)
	public void CrawlPage(@ModelAttribute("el") Elements el,CrawlerVO Crawl, Model model) throws Exception {
		CrawlerNews Craw = new CrawlerNews();
		Craw.setURL("https://news.google.co.kr");
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("div.esc-lead-article-title-wrapper a"));

		el = Craw.getEl();
		model.addAttribute("list", el);
		
		for(Element temp : el){ // 페이지에 뿌려주는것과 DB에 넣어주는것을 따로 해야한다.
			Crawl.setC_Group("News");
			Crawl.setN_Title(temp.text().toString());
			Crawl.setURL(temp.attr("href").toString());
			
			if(!Crawl.getN_Title().equals(temp.text())){ //집어넣은 값이랑 긁어온 제목이랑 같지 않을경우에만 DB에 넣기
				dao.create(Crawl); // Feed에선 Service 계층이 필요했지만 크롤링을 하는 페이지에선 Service가 필요없기 때문에 DAO에 바로 넣어준다.
			}
		}

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
