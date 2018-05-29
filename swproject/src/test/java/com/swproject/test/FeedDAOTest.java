package com.swproject.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swproject.domain.FeedVO;
import com.swproject.persistence.FeedDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class FeedDAOTest {

	@Inject
	private FeedDAO dao;

	@Test
	public void testCreate() throws Exception {
		FeedVO feed = new FeedVO();
		feed.setMyFeed("새로운 글을 넣습니다.");
		feed.setID("user00");
		dao.create(feed);
	}
	
	@Test
	public void testUpdate() throws Exception {
		FeedVO feed = new FeedVO();
		feed.setF_Number(1);
		feed.setMyFeed("수정된 글입니다.");
		dao.update(feed);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
}
