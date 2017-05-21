package com.swproject.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swproject.domain.Criteria;
import com.swproject.domain.FeedVO;
import com.swproject.domain.SearchCriteria;

@Repository
public class FeedDAOImpl implements FeedDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.swproject.mapper.FeedMapper";

	@Override
	public void create(FeedVO vo)throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public FeedVO read(Integer F_Number)throws Exception {
		return session.selectOne(namespace+".read",F_Number);
	}
	
	@Override
	public void update(FeedVO vo)throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer F_Number)throws Exception {
		session.delete(namespace + ".delete", F_Number);
	}

	@Override
	public List<FeedVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<FeedVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	/*@Override
	public List<FeedVO> listAll()throws Exception {
		return session.selectList(namespace + ".listAll");
	}*/

	/*@Override
	public List<FeedVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}*/

	/*@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}*/
}
