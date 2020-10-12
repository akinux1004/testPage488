package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml",
						"file:src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml"})
@Log4j
public class BoardControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
//	@Test
//	public void getListTest() throws Exception {
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
//						.param("pageNum", "3")
//						.param("amount", "30")
//					).andReturn().getModelAndView().getModelMap()
//		);
//		
//	} 
//	
//	@Test
//	public void get() throws Exception{
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
//						.param("bno", "284")
//					).andReturn().getModelAndView().getModelMap()
//			);
//	}
//	
//	@Test
//	public void modify() throws Exception{
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//					.param("bno", "284")
//					.param("title", "TEKKEN7")
//					.param("content", "또리야 !!! 또리야!!!")
//					.param("writer", "KAZUYA")
//				).andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//		
//	}
	
	@Test
	public void register() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "ASD")
					.param("content", "ASD")
					.param("writer", "KAZUYA")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
}
