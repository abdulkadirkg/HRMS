package hrms.HRMS.core.helpers;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;

public interface ImageUploadService {
	IDataResult<Map<String,String>> uploadImage(MultipartFile image);
}
