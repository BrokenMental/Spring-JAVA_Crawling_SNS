package com.swproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swproject.domain.FeedVO;
import com.swproject.domain.SearchCriteria;
import com.swproject.persistence.FeedDAO;

@Service
public class FeedServiceImpl implements FeedService {
	
	@Inject
	private FeedDAO dao;
	
	@Override
	public void regist(FeedVO feed) throws Exception {
		dao.create(feed);
	}
	
	@Override
	public FeedVO read(Integer F_Number) throws Exception {
		return dao.read(F_Number);
	}
	
	@Override
	public void remove(Integer F_Number) throws Exception {
		dao.delete(F_Number);
	}

	@Override
	public List<FeedVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
}
