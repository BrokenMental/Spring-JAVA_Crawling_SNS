package com.swproject.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swproject.domain.CrawlerVO;
import com.swproject.service.CrawlService;

@Controller
@RequestMapping("/Crawl/*")
public class CrawlController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	@Inject
	private CrawlService service;
	
	@RequestMapping(value = "/CrawlList", method = {RequestMethod.GET, RequestMethod.POST})
	public void CrawlPage1(CrawlerVO Crawl, Model model) throws Exception {

		model.addAttribute("list1",service.listCrawl1(Crawl));
		
		logger.info("CrawlPage1 .........");

	}

	@RequestMapping(value = "/CrawlList2", method = {RequestMethod.GET, RequestMethod.POST})
	public void CrawlPage2(CrawlerVO Crawl, Model model) throws Exception {

		model.addAttribute("list2",service.listCrawl2(Crawl));

		logger.info("CrawlPage2 .........");
	}

}
