package com.board.icia;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.icia.dao.IMemberDao;
import com.board.icia.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class MemberDaoTest {
	@Autowired
	private IMemberDao dao;
	
	@Test
	public void loginTest() {
		log.info("결과:{}","msg");
		log.info("로그인");
		log.info("dao","dao");
		Member mb = dao.getMemberInfo("aaaa");
		assertThat(dao, is(notNullValue()));
		
		
		
	}
	
}
