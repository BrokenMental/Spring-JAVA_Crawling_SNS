package com.swproject.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.swproject.domain.CrawlerVO;

public class CrawlDAOImpl implements CrawlDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.swproject.mapper.CrawlMapper";
	
	@Override
	public void create(CrawlerVO vo)throws Exception {
		session.insert(namespace + ".create", vo);
	}

}
