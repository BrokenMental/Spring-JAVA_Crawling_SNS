package com.swproject.persistence;

import java.util.List;

import com.swproject.domain.FeedVO;
import com.swproject.domain.SearchCriteria;

public interface FeedDAO {

	public void create(FeedVO vo) throws Exception;
	public FeedVO read(Integer F_Number) throws Exception;
	public void update(FeedVO vo) throws Exception;
	public void delete(Integer F_Number) throws Exception;
	
	public List<FeedVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	List<FeedVO> listPage(int page) throws Exception;

	//public List<FeedVO> listAll() throws Exception;
	//public List<FeedVO> listCriteria(Criteria cri) throws Exception;
	//public int countPaging(Criteria cri) throws Exception;

}
