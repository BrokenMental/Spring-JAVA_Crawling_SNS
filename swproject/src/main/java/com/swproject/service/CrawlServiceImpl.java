package com.swproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swproject.domain.CrawlerVO;
import com.swproject.persistence.CrawlDAO;

@Service
public class CrawlServiceImpl implements CrawlService {
	
	@Inject
	private CrawlDAO dao;
	
	@Override
	public void create1(CrawlerVO crawl)throws Exception{
		dao.create1(crawl);
	}
	
	@Override
	public void create2(CrawlerVO crawl)throws Exception{
		dao.create2(crawl);
	}
	
	@Override
	public List<CrawlerVO> listCrawl1(CrawlerVO cn)throws Exception{
		return dao.listCrawl1(cn);
	}

	@Override
	public List<CrawlerVO> listCrawl2(CrawlerVO sns)throws Exception{
		return dao.listCrawl2(sns);
	}

	@Override
	public List<CrawlerVO> listTest1(CrawlerVO crawl)throws Exception{
		return dao.listTest1(crawl);
	}
	
	@Override
	public List<CrawlerVO> listTest2(CrawlerVO crawl)throws Exception{
		return dao.listTest2(crawl);
	}
}
