package com.swproject.service;

import java.util.List;

import com.swproject.domain.CardVO;
import com.swproject.domain.TotalVO;

public interface TotalService {
	public List<TotalVO> listHome(TotalVO total, CardVO card) throws Exception;
	
}
