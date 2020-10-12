package org.zerock.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import upload.file.check.UploadFileCheckDTO;
import upload.file.check.UploadFileCheckService;


@Controller
@Log4j
public class UploadController {
	
	@Setter(onMethod_ = @Autowired)
	private UploadFileCheckService service;
	
	@GetMapping("/uploadForm")
	public void uploadForm() {

		log.info("upload form");
	}
	
	 @PostMapping("/uploadFormAction")
	 public void uploadFormPost(MultipartFile[] uploadFile, Model model) throws Exception {
	
		 String uploadFolder = "C:\\Dev\\upload";
		 
		 for (MultipartFile multipartFile : uploadFile) {
		
			 log.info("-------------------------------------");
			 log.info("Upload File Name: " +multipartFile.getOriginalFilename());
			 log.info("Upload File Size: " +multipartFile.getSize());
			 log.info("Upload File getName() : " +multipartFile.getName());
			 log.info("Upload File getBytes() : " + multipartFile.getBytes());
			 log.info("Upload File getContentType(): " +multipartFile.getContentType());
			 log.info("Upload File getInputStream(): " +multipartFile.getInputStream());
			 
			 File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			 
			 try {
				multipartFile.transferTo(saveFile);
				log.info("upload File Success " + saveFile);
			 } catch(Exception e) {
				 e.getMessage();
			 } 	
		 
		 }
		 
	 }

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		
		log.info("upload Ajax");
		
	}
	
	
	@ExceptionHandler({RuntimeException.class, MaxUploadSizeExceededException.class, IllegalStateException.class})
	@PostMapping("/uploadAjaxAction")
	public String uploadAjaxPost(MultipartFile[] uploadFile, ModelAndView modelView) throws Exception {
		
		log.info("upload ajax post.......");
		UploadFileCheckDTO dto = null;
		
		
		for(MultipartFile multipartFile : uploadFile) {
			String fileName = multipartFile.getOriginalFilename();
				fileName = fileNameOs(fileName); //os별 경로 설정이 다르기에 파일이름을 바꿔준다.  예 : 윈도우 \\ 리눅스 / 맞나??
			Long fileSize = multipartFile.getSize();
			
			logStack(fileName, fileSize); // file 의 정보들 로그 찍어 보기
			
			dto = service.ajaxFileCheck(fileName, fileSize); // 하나씩 업로드된 파일의 이름과 사이즈를 담아 객체를 생성한다
			
			File saveFile = new File(dto.getUfcVO().getUploadFolder(), dto.getFileName()); //파일 객체를 만들어 저장할 위치와 생성될 파일 이름을 담는다.
			
			
			modelView.addObject("failUpload", dto.getResult());
			multipartFile.transferTo(saveFile);	
			
		}// end for
		
		return "redirect:/uploadAjax";
		
	}
	
	public String fileNameOs(String uploadFileName) {
		int pathCut = uploadFileName.lastIndexOf("\\") + 1;
		String fileName = uploadFileName.substring(pathCut);
		return fileName;
	}
	
	public void logStack(String val1, Long val2) {
		log.info("--------------------------------");
		log.info("Upload File Name : " + val1);
		log.info("Upload File size : " + val2);
	}

}
