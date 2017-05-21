package com.swproject.service;

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

}
