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
		if (sent.equals("크기")) {
			vo.setSent("크기");
		} else {
			vo.setSent("컨텐츠");
		}
		cDAO.insertCard(vo);

		
		
		// 임시 데이터
		int Data = 0;
		
		int Sum[] = new int[] {0,};

		for (int i = 0; i < 5; i++) {

			if (Data == 1 || Data == 2 || Data == 3) {
				if (vo.getVal()[i] == true) {
					Sum[0] = Sum[0] + 1;
				}
			}
			if (Data == 3 || Data == 4) {
				if (vo.getVal()[i] == true) {
					Sum[1] = Sum[1] + 1;
				}
			}
			if (Data == 5 || Data == 6 || Data == 7 || Data == 8) {
				if (vo.getVal()[i] == true) {
					Sum[2] = Sum[2] + 1;
				}
			}
			if (Data == 9 || Data == 10 || Data == 11) {
				if (vo.getVal()[i] == true) {
					Sum[3] = Sum[3] + 1;
				}
			}
			if (Data == 13 || Data == 14 || Data == 15) {
				if (vo.getVal()[i] == true) {
					Sum[4] = Sum[4] + 1;
				}
			}
		}

		//int arrayS[] = new int[5];
		
		int temp = 0;
		boolean flag = false;
		
		for(int i = 0; i<4; i++){
			for(int j = 0; j<4-i;j++){
				if(Sum[j]>Sum[j+1]){
					flag = true;
					temp = Sum[j];
					Sum[j] = Sum[j+1];
					Sum[j+1] = temp;
				}
			}
			if(flag==false) break;
		}
		
	}

}
