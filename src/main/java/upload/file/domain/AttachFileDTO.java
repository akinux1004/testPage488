package upload.file.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import net.coobird.thumbnailator.Thumbnailator;

@Data
public class AttachFileDTO {
	
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
	
	
	public AttachFileDTO(String UPLOAD_FOLDER, MultipartFile mf) {
		
		
		this.uploadPath = getFolder();
		File uploadFolderPath = new File(UPLOAD_FOLDER, uploadPath);
		if(uploadFolderPath.exists() == false) {
			uploadFolderPath.mkdirs();
		}
		
		
		String originFileName = mf.getOriginalFilename();
		this.fileName = originFileName.substring(originFileName.lastIndexOf("\\") + 1);
		this.uuid = UUID.randomUUID().toString();
		String uploadFileName = uuid +"_"+ fileName;
		
		File saveFile = new File(uploadFolderPath, uploadFileName);
		
		
		try {
			mf.transferTo(saveFile);
			
			if(checkImageType(saveFile)) {
				this.image = true;
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolderPath, "s_" + uploadFileName));
				Thumbnailator.createThumbnail(mf.getInputStream(), thumbnail, 100, 100);
				thumbnail.close();
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
	public boolean checkImageType(File file){
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
