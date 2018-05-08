package com.swproject.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swproject.domain.CardVO;

@Repository
public class CardDAOImpl implements CardDAO {

	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.swproject.mapper.CardMapper";
	
	@Override
	public void insertCard(CardVO vo) {
		session.insert(namespace + ".cardinsert", vo);
	}
}
