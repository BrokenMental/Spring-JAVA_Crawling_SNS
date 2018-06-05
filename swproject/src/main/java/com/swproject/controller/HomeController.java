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
	public String home(Locale locale) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "ConfirmCard/num_card";
	}

	@RequestMapping(value = "/CardHome/cardHome", method = RequestMethod.GET)
	public void home(TotalVO Total, Locale locale, CrawlerVO Crawl, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		List<TotalVO> TotalFeed = service1.listHome0(Total);
		List<TotalVO> TotalNews = service1.listHome1(Total);
		List<TotalVO> TotalSns = service1.listHome2(Total);
		List<TotalVO> Lmaster = new ArrayList<TotalVO>();
		
		// ArrayList에 사용자 입력에 따른 결과값의 필요 카드량을 입력받는다.
		for(int i = 0; i<10; i++){
			if(TotalFeed.size() > i){
				Lmaster.add(TotalFeed.get(i));
			}
			if(TotalNews.size() > i){
				Lmaster.add(TotalNews.get(i));
			}
			if(TotalSns.size() > i){
				Lmaster.add(TotalSns.get(i));
			}
		}
		
		model.addAttribute("list",Lmaster);
		
		//DB결과값을 가져오면서 크롤링을 하니까 런타임이 오래걸린다.
		model.addAttribute("list1",service2.listCrawl1(Crawl));
		model.addAttribute("list2",service2.listCrawl2(Crawl));
	}
	
}
