package com.swproject.persistence;

import com.swproject.domain.CrawlerVO;

public interface CrawlDAO {

	public void create(CrawlerVO vo) throws Exception;
}
