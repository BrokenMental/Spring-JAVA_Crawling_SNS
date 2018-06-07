package com.swproject.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.TotalVO;

@Repository
public class TotalDAOImpl implements TotalDAO {
	private static String namespace = "com.swproject.mappers.TotalMapper";

	@Inject
	private SqlSession session;
	
	@Override
	public List<TotalVO> listHome0(TotalVO total) throws Exception{
		return session.selectList(namespace + ".listHome0", total);
	}
	@Override
	public List<TotalVO> listHome1(TotalVO total) throws Exception{
		return session.selectList(namespace + ".listHome1", total);
	}
	@Override
	public List<TotalVO> listHome2(TotalVO total) throws Exception{
		return session.selectList(namespace + ".listHome2", total);
	}

}
