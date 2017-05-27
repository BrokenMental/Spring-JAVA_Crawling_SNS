package com.swproject.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.ViewVO;

@Repository
public class ViewDAOImpl implements ViewDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.swproject.mapper.ViewMapper";
	
	@Override
	public List<ViewVO> allview(ViewVO view) throws Exception {
		return session.selectList(namespace + ".allview", view);
	}
}
