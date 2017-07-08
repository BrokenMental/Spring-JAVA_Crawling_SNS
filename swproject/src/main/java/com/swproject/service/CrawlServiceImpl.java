package com.swproject.service;

import java.util.ArrayList;
import java.util.Date;
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

import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Service
public class CrawlServiceImpl implements CrawlService {

	@Inject
	private CrawlDAO dao;

	@Inject
	private CrawlService service;

	public String time() {

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd. HH:mm:ss"); // yyyy.MM.dd.
																										// HH:mm:ss
		String now = formatter.format(new Date());
		return now;

	}

	public void split(CrawlerVO sns, Status temp1) {
		String crawl = temp1.getText().toString();
		String content, addr;
		int i = 0;
		if (crawl.indexOf("http") != -1) {
			i = crawl.indexOf("http");
			content = crawl.substring(0, i);
			addr = crawl.substring(i + 1);

			sns.setS_Content(content);
			sns.setS_Addr('h' + addr);
		}
	}
	
	public boolean spaceCheck(String spaceCheck){
		for(int i=0; i<spaceCheck.length(); i++){
			if(spaceCheck.charAt(i) == ' ')
				return true;
		}
		return false;
	}

	@Override
	public void create1(CrawlerVO crawl) throws Exception {
		dao.create1(crawl);
	}

	@Override
	public void create2(CrawlerVO crawl) throws Exception {
		dao.create2(crawl);
	}

	@Override
	public List<CrawlerVO> listCrawl1(CrawlerVO cn) throws Exception {
		CrawlerNews Craw = new CrawlerNews();
		Craw.setURL("https://news.google.co.kr/news/?ned=kr"); // 뒤에 부가적인 kr을 붙이지 않으면 영문페이지를 끌고온다.
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("c-wiz.PaqQNc"));

		for (Element temp : Craw.getEl()) {
			cn.setC_Group("News");
			cn.setN_IMG(temp.select("div.X20oP img").attr("src").toString());
			
			// 뉴스제공사가 여러개 붙어오는경우가 있다 추가 뉴스제공사를 잘라 set해주자.
			String sp = temp.select("span.IH8C7b").text();
			
			if(spaceCheck(sp) == true){
				int index = sp.indexOf(' ') + 1;
				//System.out.println("sp.length() = "+sp.length());
				//System.out.println("index = "+index);
				String Source = sp.substring(0, index);
				//System.out.println("Source = "+Source);
				cn.setN_Source(Source);
			}
			//cn.setN_Source(sp);
			
			//cn.setN_Source(temp.select("span.IH8C7b").text());
			//System.out.println(cn.getN_Source());
			
			cn.setN_Title(temp.select("a.nuEeue").text().toString());
			cn.setURL(temp.select("a.nuEeue").attr("href").toString());
			cn.setC_Time(time());

			service.create1(cn);
		}

		return dao.listCrawl1(cn);
	}

	@Override
	public List<CrawlerVO> listCrawl2(CrawlerVO sns) throws Exception {
		CrawlerSNS CS = new CrawlerSNS();
		CS.setTwitter(TwitterFactory.getSingleton());
		Twitter gt = CS.getTwitter();
		CS.setUser(gt.verifyCredentials());
		CS.setList(gt.getHomeTimeline());
		List<Status> cl = CS.getList();
		List<String> media = new ArrayList<String>();
		
		for (Status te : cl){ // img Url 가져오기(링크 이미지나 동영상은 안가져오는듯...)
			for(MediaEntity me : te.getMediaEntities()){
				media.add(me.getMediaURL());
			}
		}
		
		for (Status temp1 : cl) {
			sns.setC_Group("SNS");
			sns.setS_User(temp1.getUser().getScreenName().toString());
			/*if(!temp1.getMediaEntities().equals(null)){ // 어째서인지 동일한 이미지를 여러번 가져온다.
				for(MediaEntity me : temp1.getMediaEntities()){
					sns.setS_Addr(me.getMediaURL());
				}
			}else{
				split(sns, temp1);
			}*/
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
