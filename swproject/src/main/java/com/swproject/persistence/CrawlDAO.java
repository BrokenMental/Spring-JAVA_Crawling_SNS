package com.swproject.persistence;

import java.util.List;

import com.swproject.domain.CrawlerVO;
import com.swproject.domain.SearchCriteria;

public interface CrawlDAO {

	public void create1(CrawlerVO vo) throws Exception;
	public void create2(CrawlerVO vo) throws Exception;
	
	public List<CrawlerVO> listCrawl1(CrawlerVO cn) throws Exception;
	public List<CrawlerVO> listCrawl2(CrawlerVO sns) throws Exception;
	public List<CrawlerVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
