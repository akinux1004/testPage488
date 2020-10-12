package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void insertTest() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("!!!!");
//		vo.setContent("!!!");
//		vo.setWriter("KAZUYA");
//		
//		log.info(mapper.insertSelectKey(vo));
//		
//	}

	
//	@Test
//	public void getListTest() {
//		
//		Criteria cri = new Criteria();
//
//		mapper.getListWithpaging(cri).forEach(board -> log.info(board));
//		
//		log.info("total : " + mapper.getTotalCount(cri));
//		
//	}
	
//	@Test
//	public void testSearch() {
//		
//		Criteria cri = new Criteria();
//		
//		
//		cri.setKeyword("asd");
//		cri.setType("TW");
//		
//		mapper.getListWithpaging(cri).forEach(board -> log.info(board));
//		
//		log.info("total : " + mapper.getTotalCount(cri));
//		
//		log.info("searchCount : " + mapper.getTotalCount(cri));
//		
//	}
	
//	@Test
//	public void testRead() {
//		log.info(mapper.read(284L));
//	}
//	
//	@Test
//	public void testUpdate() {
//		
//		BoardVO board = new BoardVO();
//		board.setBno(284L);
//		board.setTitle("123");
//		board.setContent("!@#!@#");
//		board.setWriter("KAZUYA");
//		
//		int count = mapper.update(board);
//		
//		log.info(count);
//		
//		
//	}
	
//	@Test
//	public void testDelete() {
//	
//		log.info(mapper.delete(186L));
//		
//	}
	
	@Test
	public void updateReplyCountTest() {
		
		Long bno = 359L;
		int increse = -1;
		
		mapper.updateReplyCount(bno, increse);
		log.info(mapper.read(bno));
		
		
	}
	
}
