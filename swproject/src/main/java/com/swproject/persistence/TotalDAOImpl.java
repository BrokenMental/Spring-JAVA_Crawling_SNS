package com.swproject.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.TotalVO;

@Repository
public class TotalDAOImpl implements TotalDAO {
	private static String namespace = "com.swproject.mapper.TotalMapper";

	@Inject
	private SqlSession session;
	
	@Override
	public List<TotalVO> listTest0(TotalVO total) throws Exception{
		return session.selectList(namespace + ".listTest0", total);
	}
	@Override
	public List<TotalVO> listTest1(TotalVO total) throws Exception{
		return session.selectList(namespace + ".listTest1", total);
	}

	@Override
	public List<TotalVO> listTest2(TotalVO total) throws Exception{
		return session.selectList(namespace + ".listTest2", total);
	}

}
