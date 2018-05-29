package com.swproject.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.CrawlerVO;
import com.swproject.domain.SearchCriteria;

@Repository
public class CrawlDAOImpl implements CrawlDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.swproject.mapper.CrawlMapper";
	
	@Override
	public void create1(CrawlerVO vo) throws Exception {
		session.insert(namespace + ".create1", vo);
	}
	
	@Override
	public void create2(CrawlerVO vo) throws Exception {
		session.insert(namespace + ".create2", vo);
	}

	@Override
	public List<CrawlerVO> listCrawl1(CrawlerVO cn) throws Exception{
		return session.selectList(namespace + ".listNews", cn);
	}
	
	@Override
	public List<CrawlerVO> listCrawl2(CrawlerVO sns) throws Exception{
		return session.selectList(namespace + ".listSNS", sns);
	}

	@Override
	public List<CrawlerVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
