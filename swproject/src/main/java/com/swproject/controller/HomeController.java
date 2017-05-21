package com.swproject.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.swproject.domain.FeedVO;
import com.swproject.domain.PageMaker;
import com.swproject.domain.SearchCriteria;
import com.swproject.service.CrawlService;
import com.swproject.service.FeedService;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private FeedService service1;
	
	@Inject
	private CrawlService service2;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/Test/GridTest", method = RequestMethod.GET)
	public void test(@ModelAttribute("cri") SearchCriteria cri, CrawlerVO Crawl, Model model) throws Exception {


		System.out.println(cri);
		model.addAttribute("list", service1.listSearchCriteria(cri));
		
		model.addAttribute("list1",service2.listTest1(Crawl));
		model.addAttribute("list2",service2.listTest2(Crawl));
		
		//model.addAttribute("list", service.listSearchCriteria(cri));
		
		/*CrawlerNews Craw = new CrawlerNews();
		Craw.setURL("https://news.google.co.kr");
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("div.esc-lead-article-title-wrapper a"));

		el = Craw.getEl();
		//model.addAttribute("list1", el);

		CrawlerSNS CS = new CrawlerSNS();
		CS.setTwitter(TwitterFactory.getSingleton());
		Twitter gt = CS.getTwitter();
		CS.setUser(gt.verifyCredentials());
		CS.setList(gt.getHomeTimeline());
		List<Status> cl = CS.getList();

		//model.addAttribute("list2", cl);
		
		ArrayList<ArrayList<?>> temp = new ArrayList<ArrayList<?>>();
		ArrayList<List> test1 = new ArrayList<List>();
		//test1.add(Feed.getF_Number().toString());
		test1.add(service.listSearchCriteria(cri));
		ArrayList<Elements> test2 = new ArrayList<Elements>();
		test2.add(Craw.getEl());
		ArrayList<List> test3 = new ArrayList<List>();
		test3.add(CS.getList());
		
		temp.add(0, test1);
		temp.add(1, test2);
		temp.add(2, test3);

		System.out.println("test1 : " + temp.size());*/
		//System.out.println("test2 : " + temp.get(1));
		//System.out.println("test3 : " + temp.get(2));
		
		//model.addAttribute("test", temp);

		/*Map map;
		List list = new ArrayList();
		
		//ArrayList<ArrayList<?>> temp = new ArrayList<ArrayList<?>>();
		ArrayList<List> test1 = new ArrayList<List>();
		//test1.add(Feed.getF_Number().toString());
		test1.add(service.listSearchCriteria(cri));
		ArrayList<Elements> test2 = new ArrayList<Elements>();
		test2.add(Craw.getEl());
		ArrayList<List> test3 = new ArrayList<List>();
		test3.add(CS.getList());
		
		map = new HashMap();
		map.put("test1", service.listSearchCriteria(cri));
		map.put("test2", Craw.getEl());
		map.put("test3", CS.getList());
		list.add(map);
		
		HashMap getMap[] = new HashMap[list.size()];
		getMap[0] = (HashMap)list.get(0);
		getMap[1] = (HashMap)list.get(1);
		getMap[2] = (HashMap)list.get(2);
		System.out.println("test1 : " + getMap);*/

		/*ArrayList<ArrayList<?>> temp = new ArrayList<ArrayList<?>>();
		ArrayList<String> test1 = new ArrayList<String>();
		//test1.add(Feed.getF_Number().toString());
		test1.add(service.listSearchCriteria(cri).get(0).getF_Number().toString());
		test1.add(service.listSearchCriteria(cri).get(0).getMyFeed());
		test1.add(service.listSearchCriteria(cri).get(0).getID());
		test1.add(service.listSearchCriteria(cri).get(0).getF_Time());
		ArrayList<String> test2 = new ArrayList<String>();
		test2.add(Craw.getEl().text());
		test2.add(Craw.getEl().attr("href"));
		ArrayList<String> test3 = new ArrayList<String>();
		test3.add(CS.getList().get(0).getUser().getScreenName());
		test3.add(CS.getList().get(0).getText());
		
		
		temp.add(test1);
		temp.add(test2);
		temp.add(test3);

		System.out.println("size : " + temp.size());
		System.out.println("test1-1 : " + temp.get(0).get(0));
		System.out.println("test1-2 : " + temp.get(0).get(1));
		System.out.println("test1-3 : " + temp.get(0).get(2));
		System.out.println("test1-4 : " + temp.get(0).get(3));
		System.out.println("test2-1 : " + temp.get(1).get(0));
		System.out.println("test2-2 : " + temp.get(1).get(1));
		System.out.println("test3-1 : " + temp.get(2).get(0));
		System.out.println("test3-2 : " + temp.get(2).get(1));*/
		

		logger.info("TestPage get ...........");
	}

}
