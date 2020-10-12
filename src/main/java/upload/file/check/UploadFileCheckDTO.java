package upload.file.check;

import java.util.Map;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public class UploadFileCheckDTO {
	
	private UploadFileCheckVO ufcVO;
	private Map<String, Boolean> errors;
	private String fileName;
	private Long fileSize;
	
	private String result;
	
	
	public UploadFileCheckDTO (UploadFileCheckVO vo, Map<String, Boolean> errors, String fileName, Long fileSize) {
	
		this.ufcVO = vo;
		this.errors = errors;
		this.fileName = fileName;
		this.fileSize = fileSize;
		
		
		boolean regex = Pattern.matches(vo.getPatternFileExtension(), this.fileName);
		
		if(regex) {
			errors.put(fileName, Boolean.TRUE);
		}
		
		if(fileSize >= vo.getMaxSize()) {
			errors.put(""+fileSize, Boolean.TRUE);
		}
		
	}
	
}
