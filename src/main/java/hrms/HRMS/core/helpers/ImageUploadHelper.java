package hrms.HRMS.core.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.concretes.ErrorDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;

@Service
public class ImageUploadHelper implements ImageUploadService {
	public ImageUploadHelper() {

	}

	public IDataResult<Map<String, String>> uploadImage(MultipartFile image) {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dpsu9nta0", "api_key",
				"455151316552541", "api_secret", "wrspcKws-kZok8cpmL45nH-oDgE"));
		try {
			Map<String, String> uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map<String, String>>(uploadResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map<String, String>>();
	}
}
