package upload.file.check;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UploadFileCheckServiceImpl implements UploadFileCheckService {
	
	private final String UPLOAD_FOLDER = "C:\\Dev\\upload";
	
	private final String PATTERN_FILE_EXTENSION = "(.*?)\\.(exe|sh|zip|alz)$";
	private final Long MAX_SIZE = 5242880L; // 5MB
	
	//file의 정상 유무를 확인 위해 DTO 클래스에 자원을 수집한다, 파일체크 오류를 DTO 클래스에서 처리 하고 그안의 자원인 Map 객체에 put 한뒤   DTO 클래스에 담아 반환
	public UploadFileCheckDTO ajaxFileCheck(String fileName, Long fileSize) {
		
		Map<String, Boolean> errors = new HashMap<>();
		
		UploadFileCheckVO vo = new UploadFileCheckVO(UPLOAD_FOLDER, PATTERN_FILE_EXTENSION, MAX_SIZE);
		UploadFileCheckDTO dto = new UploadFileCheckDTO(vo, errors, fileName, fileSize);
		
		String result = null;
		
		if(dto.getErrors().containsKey(fileName)) { 
			result = fileName + "  [error : 001] : 해당 파일의 확장자는 (exe|sh|zip|alz) 업로드가 불가 합니다.";
			
		}
		
		int MB = 1048576;
		
		int overFileSize = (int) (fileSize - dto.getUfcVO().getMaxSize()) / MB;
		if(dto.getErrors().containsKey(""+fileSize)) { 
			result = fileSize + "  [error : 002] : 업로드 가능한 파일의 용량이 초과 되었습니다. [ Max : " + dto.getUfcVO().getMaxSize() + " ] [ "+ fileName +" 파일의 용량 : " + fileSize+ "] [ 초과된 용량 : " + overFileSize + " MB ]";
		}	
		
		dto.setResult(result);
		
		return dto;
	
	}
	
}
