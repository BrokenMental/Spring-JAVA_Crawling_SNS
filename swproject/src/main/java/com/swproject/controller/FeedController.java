package com.swproject.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swproject.domain.FeedVO;
import com.swproject.domain.PageMaker;
import com.swproject.domain.SearchCriteria;
import com.swproject.service.FeedService;

@Controller
@RequestMapping("/Feed/*")
public class FeedController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	@Inject
	private FeedService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("f_Number") int f_Number, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		model.addAttribute(service.read(f_Number));
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int f_Number, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		model.addAttribute(service.read(f_Number));
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET() throws Exception {

		logger.info("regist get ...........");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(FeedVO feed, RedirectAttributes rttr) throws Exception {

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyyy.MM.dd. HH:mm:ss
		String now = formatter.format(new java.util.Date());
		feed.setF_Time(now);

		logger.info("regist post ...........");
		logger.info(feed.toString());

		service.regist(feed);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/Feed/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("F_Number") int F_Number, SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.remove(F_Number);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/Feed/list";
	}

}
