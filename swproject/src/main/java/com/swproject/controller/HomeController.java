package com.swproject.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

	/*@Inject
	private ViewService service;*/

	/*@Inject
	private FeedService service1;*/
	
	/*@Inject
	private CrawlService service2;*/
	
	@Inject
	private TotalService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*@RequestMapping(value = "/Test/GridTest", method = RequestMethod.GET)
	public void test(@ModelAttribute("cri") SearchCriteria cri, ViewVO view, Model model) throws Exception {

		model.addAttribute("view",service.allview(view));
		
		logger.info("TestPage get ...........");
	}*/

	@RequestMapping(value = "/Test/GridTest", method = RequestMethod.GET)
	public void test(TotalVO Total, Model model) throws Exception {

		//ArrayList<ArrayList<?>> temp = new ArrayList<ArrayList<?>>();
		//ArrayList<List> Ltest1 = new ArrayList<List>();
		//Ltest1.add(service.listTest1(Crawl));
		//Ltest1 = service.listTest1(Crawl);
		
		//int t1 = service.listTest1(Crawl).size();
		//for(int i=0; i>t1; i++){
		//	Ltest1.add(service.listTest1(Crawl));
		//}
		//temp.add(Ltest1);
		//temp.add(Ltest2);
		
		//ArrayList<List> Ltest2 = new ArrayList<List>();
		//Ltest2.add(service.listTest2(Crawl));
		
		int flag = 1;
		ArrayList<TotalVO> Lmaster = new ArrayList<TotalVO>();
		int LSize = service.listTest0(Total).size() + service.listTest1(Total).size() + service.listTest2(Total).size();
		for(int i = 1; i<=LSize; i++){
			if(flag == 1){
				Lmaster.add(service.listTest0(Total).get(i));
				flag ++;
			}else if(flag == 2){
				Lmaster.add(service.listTest1(Total).get(i));
				flag ++;
			}else if(flag == 3){
				Lmaster.add(service.listTest2(Total).get(i));
				flag = 1;
			}
		}
		
		
		
		/*ArrayList<List> Lmaster = new ArrayList<List>();
		Lmaster.add(service.listTest0(Total));
		Lmaster.add(service.listTest1(Total));
		Lmaster.add(service.listTest2(Total));*/
		
		/*ArrayList<List> Lmaster = new ArrayList<List>();
		for(int i = 0; i<=10; i++){
				Lmaster.add(service.listTest0(Total));
				Lmaster.add(service.listTest1(Total));
				Lmaster.add(service.listTest2(Total));
		}*/
		
		/*int flag = 1;
		int LSize = service.listTest0(Total).size() + service.listTest1(Total).size() + service.listTest2(Total).size();
		List[] Lma = new List[LSize];
		for(int i = 0; i<LSize; i++){
			if(flag == 1){
				Lma[i] = service.listTest0(Total);
				flag ++;
			}else if(flag == 2){
				Lma[i] = service.listTest1(Total);
				flag ++;
			}else if(flag == 3){
				Lma[i] = service.listTest2(Total);
				flag = 1;
			}
		}*/

		//System.out.println("Lma[0] : " +Lma[0]);
		//System.out.println("Lma[1] : " +Lma[1]);
		//System.out.println("Lma[2] : " +Lma[2]);

		System.out.println("Lmaster.get(0) : "+Lmaster.get(0));
		System.out.println("Lmaster.get(1) : "+Lmaster.get(1));
		System.out.println("Lmaster.get(2) : "+Lmaster.get(2));
		//System.out.println("Lmaster.get(0).get(0) : "+Lmaster.get(0).get(0));
		//System.out.println("Lmaster.get(0).get(1) : "+Lmaster.get(0).get(1));

		System.out.println("service.listTest0(Total).get(0) : "+service.listTest0(Total).get(0));
		System.out.println("service.listTest1(Total).get(0) : "+service.listTest1(Total).get(0));
		System.out.println("service.listTest2(Total).get(0) : "+service.listTest2(Total).get(0));
		
		//model.addAttribute("test",Lma[1]);
		model.addAttribute("test",Lmaster);
	}

	/*@RequestMapping(value = "/Test/GridTest", method = RequestMethod.GET)
	public void test(@ModelAttribute("cri") SearchCriteria cri, ViewVO view, Model model) throws Exception {

		Map map;
		List list = new ArrayList();
		
		//ArrayList<ArrayList<?>> temp = new ArrayList<ArrayList<?>>();
		ArrayList<List> test1 = new ArrayList<List>();
		//test1.add(Feed.getF_Number().toString());
		test1.add(service.listSearchCriteria(cri));
		ArrayList<Elements> test2 = new ArrayList<Elements>();
		test2.add(Craw.getEl());
		ArrayList<List> test3 = new ArrayList<List>();
		test3.add(CS.getList());
		
		map = new HashMap();
		map.put("test1", service.listSearchCriteria(cri));
		map.put("test2", Craw.getEl());
		map.put("test3", CS.getList());
		list.add(map);
		
		HashMap getMap[] = new HashMap[list.size()];
		getMap[0] = (HashMap)list.get(0);
		getMap[1] = (HashMap)list.get(1);
		getMap[2] = (HashMap)list.get(2);
		System.out.println("test1 : " + getMap);
		
		logger.info("TestPage get ...........");
	}*/

}
