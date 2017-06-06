package com.swproject.service;

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
		Craw.setURL("https://news.google.co.kr");
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("div.esc-lead-article-title-wrapper a"));
		
		cn.setC_Time(time());

		for (Element temp : Craw.getEl()) { // 페이지에 뿌려주는것과 DB에 넣어주는것을 따로 해야한다.
			cn.setC_Group("News");
			cn.setN_Title(temp.text().toString());
			cn.setURL(temp.attr("href").toString());

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

		sns.setC_Time(time());

		for (Status temp1 : cl) {
			sns.setC_Group("SNS");
			sns.setS_User(temp1.getUser().getScreenName().toString());
			sns.setS_Content(temp1.getText().toString());

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
