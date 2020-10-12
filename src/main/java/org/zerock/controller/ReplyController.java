package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	@GetMapping("/pages/{bno}/{page}")
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page){
		
		Criteria cri = new Criteria(page, 10);
		
		log.info("getList  cri " + cri + "bno : " + bno + "page : " +page);
		
		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
		
	}
	
	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		log.info("ReplyVO  :  " + vo );
		
		int insertCount = service.register(vo);
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/modify")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo){
		
		int insertCount = service.modify(vo);
		
		return insertCount == 1 ? new ResponseEntity<>("modify", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable Long rno){
		
		int insertCount = service.remove(rno);
		
		return insertCount == 1 ? new ResponseEntity<>("remove", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
