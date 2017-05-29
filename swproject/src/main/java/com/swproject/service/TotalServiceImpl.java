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
	public List<TotalVO> listTest0(TotalVO total) throws Exception{
		return dao.listTest0(total);
	}
	@Override
	public List<TotalVO> listTest1(TotalVO total)throws Exception{
		return dao.listTest1(total);
	}
	
	@Override
	public List<TotalVO> listTest2(TotalVO total)throws Exception{
		return dao.listTest2(total);
	}

}
