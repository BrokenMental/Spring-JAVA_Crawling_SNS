package com.swproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swproject.domain.CrawlerVO;
import com.swproject.domain.FeedVO;
import com.swproject.persistence.CrawlDAO;
import com.swproject.persistence.FeedDAO;

@Service
public class TotalServiceImpl implements TotalService {

	@Inject
	private FeedDAO dao1;

	@Inject
	private CrawlDAO dao2;
	
	@Override
	public List<FeedVO> listTest0(FeedVO feed) throws Exception{
		return dao1.listTest0(feed);
	}
	@Override
	public List<CrawlerVO> listTest1(CrawlerVO crawl)throws Exception{
		return dao2.listTest1(crawl);
	}
	
	@Override
	public List<CrawlerVO> listTest2(CrawlerVO crawl)throws Exception{
		return dao2.listTest2(crawl);
	}

}
