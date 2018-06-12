package com.swproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swproject.domain.CardVO;
import com.swproject.persistence.CardDAO;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDAO cDAO;

	@Override
	public void insertCard(CardVO vo, String sent) {
		if (sent.equals("num")) {
			vo.setSent("num");
			cDAO.insertCardnum(vo);
		} else {
			vo.setSent("slide");
			cDAO.insertCardslide(vo);
		}
	}

}
