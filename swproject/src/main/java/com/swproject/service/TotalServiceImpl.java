package com.swproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swproject.domain.TotalVO;
import com.swproject.persistence.TotalDAO;


@Service
public class TotalServiceImpl implements TotalService {

	@Inject
	private TotalDAO dao;
	
	@Override
	public List<TotalVO> listHome0(TotalVO total) throws Exception{
		return dao.listHome0(total);
	}
	@Override
	public List<TotalVO> listHome1(TotalVO total) throws Exception{
		return dao.listHome1(total);
	}
	
	@Override
	public List<TotalVO> listHome2(TotalVO total) throws Exception{
		return dao.listHome2(total);
	}

}
