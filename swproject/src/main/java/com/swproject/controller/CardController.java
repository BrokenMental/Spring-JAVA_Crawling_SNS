package com.swproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swproject.service.CardService;

@Controller
@RequestMapping(value = "/ConfirmCard")
public class CardController {
	
	@Autowired
	private CardService cService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void sCardGet(){
		
	}
	
	
	@RequestMapping(value = "/testvalue", method = RequestMethod.GET)
	public void testValueGet(){
		
	}
	
	@RequestMapping(value = "/testvalue", method = RequestMethod.GET)
	public void testValuePost(HttpServletRequest hRequest){
		String URI = hRequest.getRequestURI();
		
	}
}
