package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import upload.file.check.UploadFileCheckDTO;
import upload.file.check.UploadFileCheckService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class UploadFileCheckServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private UploadFileCheckService service;
	
	@Test
	public void fileCheck() {
		
		
		// 컨트롤러 에서 인자로 받아야 할 값;
		String fileName = "ajax.zip"; //"(.*?)\\.(exe|sh|zip|alz)$"
		Long fileSize = 5242780011111L; 
		
		UploadFileCheckDTO dto = service.ajaxFileCheck(fileName, fileSize);
		service.ajaxFileCheck(fileName, fileSize);
		
		log.info(dto.getResult());
	}
		
}
