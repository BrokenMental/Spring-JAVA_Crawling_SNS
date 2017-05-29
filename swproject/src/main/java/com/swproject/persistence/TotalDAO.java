package com.swproject.persistence;

import java.util.List;

import com.swproject.domain.CrawlerVO;
import com.swproject.domain.FeedVO;

public interface TotalDAO {
	public List<FeedVO> listTest0(FeedVO feed) throws Exception;
	public List<CrawlerVO> listTest1(CrawlerVO crawl) throws Exception;
	public List<CrawlerVO> listTest2(CrawlerVO crawl) throws Exception;

}
