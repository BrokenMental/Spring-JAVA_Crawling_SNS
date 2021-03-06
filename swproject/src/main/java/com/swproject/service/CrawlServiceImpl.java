package com.swproject.service;

import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private CrawlDAO dao;

	@Autowired
	private CrawlService service;

	public String time() {

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyyy.MM.dd.
																										// HH:mm:ss
		String now = formatter.format(new Date());
		return now;

	}

	public void splitsns(CrawlerVO sns, Status temp1){
		String crawl = temp1.getText().toString();
		String content, addr;
		int i = 0;
		if (crawl.indexOf("http") != -1) {
			i = crawl.indexOf("http");
			content = crawl.substring(0, i);
			addr = crawl.substring(i + 1);
			if (spaceCheck(addr) == true) {
				int index = addr.indexOf(' ') + 1;
				String link = addr.substring(0, index);
				sns.setS_Addr('h' + link);
			} else {
				sns.setS_Addr('h' + addr);
			}

			// System.out.println("Addr : " + sns.getS_Addr());
			jsoupurl(sns);

			sns.setS_Content(content);
		}
	}

	public void splitaddr(CrawlerVO sns, String text) {
		try {
			if (text.indexOf('=') != -1) {
				sns.setS_Addr(text.substring(text.indexOf('=') + 1, text.length()));
				Document jdoc = Jsoup.connect(sns.getS_Addr()).get();
				Elements jimage = jdoc.select("meta[property=og:image]");
				// System.out.println(jimage.attr("content"));
				sns.setS_Img(jimage.attr("content"));
			}
		} catch (Exception e) {

		}
	}

	public void jsoupurl(CrawlerVO sns) {
		try {
			Document jdoc = Jsoup.connect(sns.getS_Addr()).get();
			Elements metaTags = jdoc.getElementsByTag("meta");
			for (Element metaTag : metaTags) {
				String jcon = metaTag.attr("content");
				splitaddr(sns, jcon);
			}
		} catch (Exception e) {

		}
	}

	public boolean spaceCheck(String spaceCheck) {
		for (int i = 0; i < spaceCheck.length(); i++) {
			if (spaceCheck.charAt(i) == ' ')
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
		Craw.setURL("https://news.google.com/?hl=ko&gl=KR&ceid=KR:ko");
		/* url 변경 : https://news.google.co.kr/news/?ned=kr */ // 뒤에 부가적인 kr을 붙이지
																// 않으면 영문페이지를
																// 끌고온다.
		Craw.setDoc(Jsoup.connect(Craw.getURL()).get());
		Craw.setEl(Craw.getDoc().select("c-wiz.Erv9te"));
		Elements temp = Craw.getEl();

		if (!temp.equals(null)) {
			Elements ctitle = temp.select("div.ZulkBc.qNiaOd span");
			Elements csource = temp.select("div.PNwZO.zhsNkd span");
			Elements tempurl = temp.select("a.ipQwMb");
			// Elements cimg = temp.select("img.tvs3Id.dIH98c");

			for (int i = 0; i < ctitle.size(); i++) {
				cn.setC_Group("News");
				cn.setC_Time(time());

				// 이미지는 어떻게 넣어야 하냐...
				/*
				 * if(cimg.eq(i).contains("<img")){
				 * cn.setN_IMG(cimg.eq(i).attr("src")); }else{
				 * cn.setN_IMG("NO IMG"); }
				 */

				cn.setN_Source(csource.eq(i).text());
				cn.setN_Title(ctitle.eq(i).text());

				String curl = tempurl.eq(i).select("a.ipQwMb").attr("href").replace(".", "https://news.google.com");
				cn.setURL(curl);
				service.create1(cn);
			}
		}

		// foreach가 통하지 않아 싹 갈아엎음
		/*
		 * for (Element temp : Craw.getEl()) { cn.setC_Group("News");
		 * cn.setN_IMG(temp.select("div.xrnccd img").attr("src").toString());
		 * 
		 * // 뉴스제공사가 여러개 붙어오는경우가 있다 추가 뉴스제공사를 잘라 set해주자. String sp =
		 * temp.select("span.KbnJ8").text();
		 * 
		 * if(spaceCheck(sp) == true){ int index = sp.indexOf(' ') + 1;
		 * //System.out.println("sp.length() = "+sp.length());
		 * //System.out.println("index = "+index); String Source =
		 * sp.substring(0, index); //System.out.println("Source = "+Source);
		 * cn.setN_Source(Source); } //cn.setN_Source(sp);
		 * 
		 * //cn.setN_Source(temp.select("span.IH8C7b").text());
		 * 
		 * //System.out.println("이거 : "+temp.select("div.ZulkBc.qNiaOd span").eq
		 * (1).text().toString());
		 * 
		 * cn.setN_Title(temp.select("div.ZulkBc.qNiaOd span").eq(numbr).text().
		 * toString()); numbr++;
		 * 
		 * String tempurl = temp.select("a.ipQwMb").attr("href").toString();
		 * String curl = tempurl.replace(".", "https://news.google.com");
		 * cn.setURL(curl);
		 * 
		 * cn.setC_Time(time());
		 * 
		 * service.create1(cn); }
		 */

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
		/*
		 * List<String> media = new ArrayList<String>();
		 * 
		 * for (Status te : cl){ // img Url 가져오기(링크 이미지나 동영상은 안가져오는듯...)
		 * for(MediaEntity me : te.getMediaEntities()){
		 * media.add(me.getMediaURL()); System.out.println("num : "+media); } }
		 */
		for (Status temp1 : cl) {
			sns.setC_Group("SNS");
			sns.setS_User(temp1.getUser().getScreenName().toString());
			splitsns(sns, temp1);
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
