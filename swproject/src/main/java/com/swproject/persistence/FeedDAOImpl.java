package com.swproject.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.FeedVO;

@Repository
public class FeedDAOImpl implements FeedDAO{

	@Inject
	private SqlSession session;
	
private static String namespace
= "com.swproject.mapper.FeedMapper";
	
	@Override
	public void create(FeedVO vo)throws Exception {
		session.insert(namespace +".create", vo);
	}

	@Override
	public void update(FeedVO vo)throws Exception {
		session.update(namespace +".update", vo);
	}

	@Override
	public void delete(Integer F_Number)throws Exception {
		session.delete(namespace +".delete", F_Number);
	}

	@Override
	public List<FeedVO> listAll()throws Exception {
		return session.selectList(namespace +".listAll");
	}
}
