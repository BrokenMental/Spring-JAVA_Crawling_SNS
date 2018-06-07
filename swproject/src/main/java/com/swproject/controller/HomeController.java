package com.swproject.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swproject.domain.CardVO;
import com.swproject.domain.CrawlerVO;
import com.swproject.domain.TotalVO;
import com.swproject.service.CrawlService;
import com.swproject.service.TotalService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TotalService service1;

	@Autowired
	private CrawlService service2;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "ConfirmCard/num_card";
	}

	@RequestMapping(value = "/CardHome/cardHome", method = RequestMethod.GET)
	public void home(TotalVO Total, CardVO Card, Locale locale, CrawlerVO Crawl, Model model) throws Exception {
		logger.info("CardHome GET...");
		
		model.addAttribute("list",service1.listHome(Total, Card));
		
		//DB결과값을 가져오면서 크롤링을 하니까 런타임이 오래걸린다.
		//model.addAttribute("list1",service2.listCrawl1(Crawl));
		//model.addAttribute("list2",service2.listCrawl2(Crawl));
	}
	
}
