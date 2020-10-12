package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void getListTest() {
		
		Criteria cri = new Criteria();
		
		mapper.getListWithpaging(cri).forEach(board -> log.info(board));
		
	}
	
	@Test
	public void get() {
		
		log.info(mapper.read(284L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(284L);
		board.setTitle("123");
		board.setContent("!@#!@#");
		board.setWriter("KAZUYA");
		
		int count = mapper.update(board);
		
		log.info(count);
		
		
	}
	
	@Test
	public void testDelete() {
	
		log.info(mapper.delete(186L));
		
	}
	
}
