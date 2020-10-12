package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
//	@Test
//	public void testList() {
//		
//		Criteria cri = new Criteria();
//		
//		cri.setPageNum(3);
//		
//		Long bno = 359L;
//		
//		List<ReplyVO> list = mapper.getListWithPaging(cri, bno);
//		
//		list.forEach(reply -> log.info(reply));
//		
//	}
//	
//	@Test
//	public void testInsert() {
//		
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO vo = new ReplyVO();
//			vo.setBno(359L);
//			vo.setReply("아무 내용 이나 적기");
//			vo.setReplyer("AKI");
//			
//			log.info(mapper.insert(vo));
//		});
//		
//	}
	
//	@Test
//	public void testUpdate() {
//		
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(762L);
//		vo.setReply("내용 수정!!!");
//		
//		log.info(mapper.update(vo));
//		
//	}
	
//	@Test
//	public void testDelete() {
//		
//		Long rno = 762L;
//		
//		log.info(mapper.delete(rno));
//		
//	}
	
	@Test
	public void testRead() {
		
		Long rno = 769L;
		
		ReplyVO vo = mapper.read(rno);
		
		log.info("-------------------------------> " + vo);
		
	}
	
}
