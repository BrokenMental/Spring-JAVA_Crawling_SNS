package com.swproject.persistence;

import java.util.List;

import com.swproject.domain.ViewVO;

public interface ViewDAO {

	public List<ViewVO> allview(ViewVO view) throws Exception;
}
