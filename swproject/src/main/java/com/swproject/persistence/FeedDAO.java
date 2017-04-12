package com.swproject.persistence;

import java.util.List;

import com.swproject.domain.FeedVO;

public interface FeedDAO {

	public void create(FeedVO vo)throws Exception;
	
	public void update(FeedVO vo)throws Exception;
	
	public void delete(Integer F_Number)throws Exception;
	
	public List<FeedVO> listAll()throws Exception;
}
