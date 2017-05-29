package com.swproject.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.CrawlerVO;
import com.swproject.domain.FeedVO;

@Repository
public class TotalDAOImpl implements TotalDAO {
	private static String namespace = "com.swproject.mapper.TotalMapper";

	@Inject
	private SqlSession session;
	
	@Override
	public List<FeedVO> listTest0(FeedVO feed) throws Exception{
		return session.selectList(namespace + ".listTest0", feed);
	}
	@Override
	public List<CrawlerVO> listTest1(CrawlerVO crawl) throws Exception{
		return session.selectList(namespace + ".listTest1", crawl);
	}

	@Override
	public List<CrawlerVO> listTest2(CrawlerVO crawl) throws Exception{
		return session.selectList(namespace + ".listTest2", crawl);
	}

}
