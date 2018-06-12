package com.swproject.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swproject.domain.CardVO;
import com.swproject.domain.TotalVO;

@Repository
public class TotalDAOImpl implements TotalDAO {
	private static String namespaceCard = "com.swproject.mappers.CardMapper";
	private static String namespaceTotal = "com.swproject.mappers.TotalMapper";

	@Autowired
	private SqlSession session;

	@Override
	public List<CardVO> userChoiceNum(CardVO card) throws Exception {
		return session.selectList(namespaceCard + ".selectNum", card);
	}

	@Override
	public List<CardVO> userChoiceSlide(CardVO card) throws Exception {
		return session.selectList(namespaceCard + ".selectSlide", card);
	}

	@Override
	public List<TotalVO> listHome0(TotalVO total, int limitNum) throws Exception {
		total.setLimitNum(limitNum);
		return session.selectList(namespaceTotal + ".listHome0", total);
	}

	@Override
	public List<TotalVO> listHome1(TotalVO total, int limitNum) throws Exception {
		total.setLimitNum(limitNum);
		return session.selectList(namespaceTotal + ".listHome1", total);
	}

	@Override
	public List<TotalVO> listHome2(TotalVO total, int limitNum) throws Exception {
		total.setLimitNum(limitNum);
		return session.selectList(namespaceTotal + ".listHome2", total);
	}

}
