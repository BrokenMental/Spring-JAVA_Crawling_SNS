package com.swproject.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swproject.domain.TotalVO;
import com.swproject.service.TotalService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private TotalService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(TotalVO Total, Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		

		ArrayList<TotalVO> Lmaster = new ArrayList<TotalVO>();
		for(int i = 0; i<10; i++){
			Lmaster.add(service.listHome0(Total).get(i));
			Lmaster.add(service.listHome1(Total).get(i));
			Lmaster.add(service.listHome2(Total).get(i));
		}
		model.addAttribute("list",Lmaster);
		
		return "home";
	}
}
