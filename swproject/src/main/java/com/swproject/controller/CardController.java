package com.swproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swproject.domain.CardVO;
import com.swproject.service.CardService;

@Controller
@RequestMapping(value = "/ConfirmCard")
public class CardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CardService cService;
	
	@RequestMapping(value = "/num_card", method = RequestMethod.GET)
	public void nCardGet(){
		logger.info("num_card .........");
		
	}

	@RequestMapping(value = "/slide_card", method = RequestMethod.GET)
	public void sCardGet(){
		logger.info("slide_card .........");
		
	}
	
	@RequestMapping(value = "/testvalue1", method = RequestMethod.GET)
	public void testValueGet1(){
		logger.info("testvalue1 GET .........");
		
	}
	
	@RequestMapping(value = "/testvalue1", method = RequestMethod.POST)
	public String testValuePost1(CardVO vo){
		logger.info("testvalue1 POST .........");
		cService.insertCard(vo,"Å©±â");
		return "redirect:/ConfirmCard/slide_card";
	}
	
	@RequestMapping(value = "/testvalue2", method = RequestMethod.GET)
	public void testValueGet2(){
		logger.info("testvalue2 GET .........");
		
	}
	
	@RequestMapping(value = "/testvalue2", method = RequestMethod.POST)
	public String testValuePost2(CardVO vo){
		logger.info("testvalue2 POST .........");
		cService.insertCard(vo,"ÄÁÅÙÃ÷");
		return "redirect:/CardHome/cardHome";
	}
}
