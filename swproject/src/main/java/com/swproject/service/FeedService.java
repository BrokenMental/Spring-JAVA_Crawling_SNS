package com.swproject.service;

import java.util.List;

import com.swproject.domain.FeedVO;
import com.swproject.domain.SearchCriteria;

public interface FeedService {

	public void regist(FeedVO board) throws Exception;
	
	public FeedVO read(Integer F_Number) throws Exception;
	
	public void remove(Integer F_Number) throws Exception;
	
	public List<FeedVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
