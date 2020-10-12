package org.zerock.util;

import java.util.Map;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UploadFileCheck {
	
	
	private String patternFileExtension;
	private Long maxSize;
	
	private String fileName;
	private Long fileSize;
	
	
	public UploadFileCheck(String patternFileExtension, Long maxSize) {
		this.patternFileExtension = patternFileExtension;
		this.maxSize = maxSize;
	}
	
	public void checkExtension(Map<String, Boolean> errors) {
		
		//this.maxSize = 5242880L; // 5MB
		//this.patternFileExtension = "(.*?)\\.(exe|sh|zip|alz)$";
		
		boolean regex = Pattern.matches(this.patternFileExtension, this.fileName);
		
		
		if(fileSize >= maxSize) {
			errors.put(fileName, Boolean.TRUE);
		}
		
		if(regex) {
			errors.put(fileName, Boolean.TRUE);
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
//		Long maxSize = 5242880L; // 5MB
//		String patternFileExtension = "(.*?)\\.(exe|sh|zip|alz)$";
//		
//		UploadFileCheck fileCheck = new UploadFileCheck(patternFileExtension, maxSize);
//		fileCheck.setFileName("arr.txt");
//		fileCheck.setFileSize(4000L);
		
//		UploadFileCheckDTO ufcDTO = new UploadFileCheckDTO();
//		
//		
//		Map<String, Boolean> errors = new HashMap<>();
//		fileCheck.checkExtension(errors);
//		
//		if(!errors.isEmpty()) {
//			System.out.println("error");
//		}
//		
//		if(errors.containsKey(fileCheck.getFileName())) {
//			System.out.println(fileCheck.getFileName());
//		}
//		
	}
	
}
