package com.swproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@Inject
	private TotalService service1;

	@Inject
	private CrawlService service2;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(TotalVO Total, Locale locale, CrawlerVO Crawl, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<TotalVO> Lmaster = new ArrayList<TotalVO>();
		for(int i = 0; i<20; i++){
			Lmaster.add(service1.listHome0(Total).get(i));
			Lmaster.add(service1.listHome1(Total).get(i));
			Lmaster.add(service1.listHome2(Total).get(i));
		}
		model.addAttribute("list",Lmaster);
		model.addAttribute("list1",service2.listCrawl1(Crawl));
		model.addAttribute("list2",service2.listCrawl2(Crawl));
		
		return "home";
	}
}
