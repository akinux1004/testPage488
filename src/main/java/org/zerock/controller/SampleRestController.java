package org.zerock.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleRestController {

	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8" )
	public String getText(HttpServletRequest req, Model model) {
		
		String reqVal = req.getContentType();
		Enumeration<String> e = req.getParameterNames();
		while(e.hasMoreElements()) {
			String name =  e.nextElement();
			String[] values = req.getParameterValues(name);
			for(String value : values)
				log.info("paramName =  " + name + ", paramValue = " + value);
			
		}
		
		
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN);
		
		log.info("req.getContenType() : " + reqVal );
		
		model.addAttribute("result", reqVal);
		
		return model.toString();
	}
	
	@GetMapping(value= "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample(Model model) {
		
		SampleVO sample = new SampleVO(112,"hh","머~?");
		
		model.addAttribute("sampleVO", sample);
		
		return sample;
	}
	
}
