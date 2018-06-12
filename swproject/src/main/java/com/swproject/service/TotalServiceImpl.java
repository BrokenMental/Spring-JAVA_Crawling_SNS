package com.swproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swproject.domain.CardVO;
import com.swproject.domain.TotalVO;
import com.swproject.persistence.TotalDAO;

@Service
public class TotalServiceImpl implements TotalService {

	@Autowired
	private TotalDAO dao;

	// divide Result the select, similar an card
	public String divideResult(CardVO Card, int Flag) throws Exception {
		String reval = "d";
		int Sum[] = new int[15];

		/*
		 * if (Flag == 0) { // CardNum for (int i = 0; i < 5; i++) { if (i == 0
		 * && (Card.isVal00() == true)) {
		 * 
		 * } if (i == 1 && (Card.isVal01() == true)) {
		 * 
		 * } if (i == 2 && (Card.isVal02() == true)) {
		 * 
		 * } if (i == 3 && (Card.isVal03() == true)) {
		 * 
		 * } if (i == 4 && (Card.isVal04() == true)) {
		 * 
		 * } } } else {
		 */
		// CardSlide
		for (int i = 0; i < 15; i++) {
			if (i < 3 && (Card.isVal00() || Card.isVal01() || Card.isVal02() == true)) {
				System.out.println(i);
				Sum[0] = Sum[0] + 1;
			}
			if ((i >= 3 && i < 5) && (Card.isVal03() || Card.isVal04() == true)) {
				System.out.println(i);
				Sum[1] = Sum[1] + 1;
			}
			if ((i >= 5 && i < 9) && (Card.isVal05() || Card.isVal06() || Card.isVal07() || Card.isVal08() == true)) {
				System.out.println(i);
				Sum[2] = Sum[2] + 1;
			}
			if ((i >= 9 && i < 12) && (Card.isVal09() || Card.isVal10() || Card.isVal11() == true)) {
				System.out.println(i);
				Sum[3] = Sum[3] + 1;
			}
			if ((i >= 12 && i < 15) && (Card.isVal12() || Card.isVal13() || Card.isVal14() == true)) {
				System.out.println(i);
				Sum[4] = Sum[4] + 1;
			}

			// }
		}

		if (Sum[0] + Sum[1] > Sum[3] + Sum[4]) {
			// Result : img & graphic first
			reval = "a";
		} else if (Sum[2] > Sum[3] + Sum[4]) {
			// first if same thing
			reval = "b";
		} else if (Sum[3] + Sum[4] >= Sum[1] + Sum[2]){
			// Result : letter first
			reval = "c";
		}
		
		return reval;
	}

	public List<TotalVO> course(String route ,TotalVO total) throws Exception{
		List<TotalVO> Lmaster = new ArrayList<TotalVO>();
		int maxNum = 15;
		int avgNum = 10;
		int minNum = 5;

		if(route == "a"){
			// Result : img & graphic first
			List<TotalVO> TotalFeed = dao.listHome0(total, minNum);
			List<TotalVO> TotalNews = dao.listHome1(total, maxNum);
			List<TotalVO> TotalSns = dao.listHome2(total, avgNum);
			for (int i = 0; i < maxNum; i++) {
				if (TotalNews.size() > i) {
					Lmaster.add(TotalNews.get(i));
				}
				if (TotalSns.size() > i) {
					Lmaster.add(TotalSns.get(i));
				}
			}
			for (int i = 0; i < minNum; i++) {
				if (TotalSns.size() > i) {
					Lmaster.add(TotalFeed.get(i));
				}
			}
		}else if(route == "b"){
			// first if same thing but, better than letter count it first if
			List<TotalVO> TotalFeed = dao.listHome0(total, 6);
			List<TotalVO> TotalNews = dao.listHome1(total, 12);
			List<TotalVO> TotalSns = dao.listHome2(total, 12);
			for (int i = 0; i < 12; i++) {
				if (TotalNews.size() > i) {
					Lmaster.add(TotalNews.get(i));
				}
				if (TotalSns.size() > i) {
					Lmaster.add(TotalSns.get(i));
				}
			}
			for (int i = 0; i < 6; i++) {
				if (TotalSns.size() > i) {
					Lmaster.add(TotalFeed.get(i));
				}
			}
		}else if(route == "c"){
			// Result : letter first better than second result(route "b")
			List<TotalVO> TotalFeed = dao.listHome0(total, 12);
			List<TotalVO> TotalNews = dao.listHome1(total, 9);
			List<TotalVO> TotalSns = dao.listHome2(total, 9);
			for (int i = 0; i < 12; i++) {
				if (TotalNews.size() > i) {
					Lmaster.add(TotalNews.get(i));
				}
				if (TotalSns.size() > i) {
					Lmaster.add(TotalSns.get(i));
				}
				if (TotalSns.size() > i) {
					Lmaster.add(TotalFeed.get(i));
				}
			}
		}else{
			// Same Cards
			List<TotalVO> TotalFeed = dao.listHome0(total, avgNum);
			List<TotalVO> TotalNews = dao.listHome1(total, avgNum);
			List<TotalVO> TotalSns = dao.listHome2(total, avgNum);
			for (int i = 0; i < avgNum; i++) {
				if (TotalFeed.size() > i) {
					Lmaster.add(TotalFeed.get(i));
				}
				if (TotalNews.size() > i) {
					Lmaster.add(TotalNews.get(i));
				}
				if (TotalSns.size() > i) {
					Lmaster.add(TotalSns.get(i));
				}
			}
		}
		
		return Lmaster;
	}
	
	@Override
	public List<TotalVO> listHome(TotalVO total, CardVO card) throws Exception {

		// List<CardVO> CardNum = dao.userChoiceNum(card);
		// divideResult(CardNum.get(0), 0); // CardNum
		
		List<CardVO> CardSlide = dao.userChoiceSlide(card);
		String route = divideResult(CardSlide.get(0), 1); // CardSlide

		List<TotalVO> LResult = course(route, total);

		return LResult;
	}
}
