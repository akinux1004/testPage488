package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list");
		
		log.info("cri :" + cri);
		
		int total = service.getTotal(cri);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("get or modify -->  bno : " + bno);
		
		model.addAttribute("board", service.get(bno));
		
	}
	
	@PostMapping("/modify")
	public String modify(@ModelAttribute BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("board" + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", board.getBno());
		}
		
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			
		return "redirect:/board/list";
		
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", bno);
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Criteria cri) {
		
		
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		Map<String, Boolean> errors = new HashMap<>();
		vo.checkEmpty(errors, vo.getTitle(), "title");
		vo.checkEmpty(errors, vo.getContent(), "content");
		vo.checkEmpty(errors, vo.getWriter(), "writer");
		
		if(!errors.isEmpty()) {
			rttr.addFlashAttribute("errors", errors);
			return "redirect:/board/register";
		}
		
		
		if(service.register(vo)) {
			rttr.addFlashAttribute("result", vo.getBno());
		}
		
		return "redirect:/board/list";
		
	}
	
	
	
}
