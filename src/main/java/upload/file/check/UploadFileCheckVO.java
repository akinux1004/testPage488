package upload.file.check;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFileCheckVO {
	
	private String uploadFolder;
	private String patternFileExtension;
	private Long maxSize;
	
}
