package upload.file.check;

public interface UploadFileCheckService {
	
	public UploadFileCheckDTO ajaxFileCheck(String fileName, Long fileSize);
	
}
