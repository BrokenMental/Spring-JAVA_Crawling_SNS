package com.swproject.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.CrawlerVO;

@Repository
public class CrawlDAOImpl implements CrawlDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.swproject.mapper.CrawlMapper";
	
	@Override
	public void create1(CrawlerVO vo)throws Exception {
		session.insert(namespace + ".create1", vo);
	}
	
	@Override
	public void create2(CrawlerVO vo)throws Exception {
		session.insert(namespace + ".create2", vo);
	}

}
