package com.swproject.service;

import java.util.List;

import com.swproject.domain.CrawlerVO;

public interface CrawlService {
	
	public List<CrawlerVO> listCrawl1(CrawlerVO crawl)throws Exception;
	
	public List<CrawlerVO> listCrawl2(CrawlerVO sns)throws Exception;

	public void create1(CrawlerVO crawl)throws Exception;
	
	public void create2(CrawlerVO crawl)throws Exception;
	
	public List<CrawlerVO> listTest1(CrawlerVO crawl)throws Exception;
	
	public List<CrawlerVO> listTest2(CrawlerVO crawl)throws Exception;
}
