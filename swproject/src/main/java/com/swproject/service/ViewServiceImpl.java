package com.swproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swproject.domain.ViewVO;
import com.swproject.persistence.ViewDAO;

@Service
public class ViewServiceImpl implements ViewService {
	
	@Inject
	private ViewDAO dao;
	
	@Override
	public List<ViewVO> allview(ViewVO view)throws Exception{
		return dao.allview(view);
	}

}
