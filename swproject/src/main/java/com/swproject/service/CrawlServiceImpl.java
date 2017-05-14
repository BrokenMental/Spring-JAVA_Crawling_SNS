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
	public void insert(CrawlerVO Crawl)throws Exception {
		dao.create(Crawl);
	}

}
