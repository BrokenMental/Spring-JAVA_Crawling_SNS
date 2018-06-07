package com.swproject.service;

import java.util.ArrayList;
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
		
		List<TotalVO> TotalFeed = dao.listHome0(total);
		List<TotalVO> TotalNews = dao.listHome1(total);
		List<TotalVO> TotalSns = dao.listHome2(total);
		List<TotalVO> Lmaster = new ArrayList<TotalVO>();
		
		// ArrayList에 사용자 입력에 따른 결과값의 필요 카드량을 입력받는다.
		for(int i = 0; i<10; i++){
			if(TotalFeed.size() > i){
				Lmaster.add(TotalFeed.get(i));
			}
			if(TotalNews.size() > i){
				Lmaster.add(TotalNews.get(i));
			}
			if(TotalSns.size() > i){
				Lmaster.add(TotalSns.get(i));
			}
		}
		
		return Lmaster;
	}

}
