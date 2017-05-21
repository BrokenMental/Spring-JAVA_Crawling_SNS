package com.swproject.persistence;

import java.util.List;

import com.swproject.domain.CrawlerVO;

public interface CrawlDAO {

	public void create1(CrawlerVO vo) throws Exception;
	public void create2(CrawlerVO vo) throws Exception;
	
	public List<CrawlerVO> listCrawl1(CrawlerVO cn) throws Exception;
	public List<CrawlerVO> listCrawl2(CrawlerVO sns) throws Exception;
	public List<CrawlerVO> listTest1(CrawlerVO crawl) throws Exception;
	public List<CrawlerVO> listTest2(CrawlerVO crawl) throws Exception;
}
