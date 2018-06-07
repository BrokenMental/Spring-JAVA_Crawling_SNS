package com.swproject.persistence;

import java.util.List;

import com.swproject.domain.CardVO;
import com.swproject.domain.TotalVO;

public interface TotalDAO {
	
	public List<CardVO> userChoiceNum(CardVO card) throws Exception;
	public List<CardVO> userChoiceSlide(CardVO card) throws Exception;
	
	public List<TotalVO> listHome0(TotalVO total) throws Exception;
	public List<TotalVO> listHome1(TotalVO total) throws Exception;
	public List<TotalVO> listHome2(TotalVO total) throws Exception;

}
