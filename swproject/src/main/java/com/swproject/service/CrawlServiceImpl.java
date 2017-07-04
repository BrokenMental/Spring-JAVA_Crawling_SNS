package com.swproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.swproject.domain.CrawlerNews;
import com.swproject.domain.CrawlerSNS;
import com.swproject.domain.CrawlerVO;
import com.swproject.domain.SearchCriteria;
import com.swproject.persistence.CrawlDAO;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Service
public class CrawlServiceImpl implements CrawlService {
	
	@Inject
	private CrawlDAO dao;

	@Inject
	private CrawlService service;
	
	public String time(){

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd. HH:mm:ss"); // yyyy.MM.dd. HH:mm:ss
		String now = formatter.format(new java.util.Date());
		return now;
		
	}
	
	public void split(CrawlerVO sns, Status temp1){
		String crawl = temp1.getText().toString();
		String content, addr;
		int i = 0;
		if(crawl.indexOf("http") != -1){
			i = crawl.indexOf("http");
			content = crawl.substring(0,i);
			addr = crawl.substring(i+1);
			
			sns.setS_Content(content);
			sns.setS_Addr('h'+addr);
		}
	}
	
	@Override
	public void create1(CrawlerVO crawl) throws Exception{
		dao.create1(crawl);
	}
	
	@Override
	public void create2(CrawlerVO crawl) throws Exception{
		dao.create2(crawl);
	}
	
	@Override
	public List<CrawlerVO> listCrawl1(CrawlerVO cn) throws Exception{
		CrawlerNews Craw = new CrawlerNews();
		Craw.setURL("https://news.google.co.kr/news/?ned=kr"); // 뒤에 부가적인 kr을 붙이지 않으면 영문페이지를 끌고온다.
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("c-wiz.PaqQNc"));

		for (Element temp : Craw.getEl()) {
			cn.setC_Group("News");
			cn.setN_IMG(temp.select("div.X20oP img").attr("src").toString());
			cn.setN_Source(temp.select("span.IH8C7b Pc0Wt").text());
			cn.setN_Title(temp.select("a.nuEeue").text().toString());
			cn.setURL(temp.select("a.nuEeue").attr("href").toString());
			cn.setC_Time(time());
			
			service.create1(cn);
		}

		System.out.println(cn);
		return dao.listCrawl1(cn);
	}

	@Override
	public List<CrawlerVO> listCrawl2(CrawlerVO sns) throws Exception{
		CrawlerSNS CS = new CrawlerSNS();
		CS.setTwitter(TwitterFactory.getSingleton());
		Twitter gt = CS.getTwitter();
		CS.setUser(gt.verifyCredentials());
		CS.setList(gt.getHomeTimeline());
		List<Status> cl = CS.getList();

		for (Status temp1 : cl) {
			sns.setC_Group("SNS");
			sns.setS_User(temp1.getUser().getScreenName().toString());
			split(sns, temp1);
			sns.setC_Time(time());

			service.create2(sns);
		}
		return dao.listCrawl2(sns);
	}
	
	@Override
	public List<CrawlerVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
}
