package HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.ErrorDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;

@Component
public class ImageUploadManager implements ImageUploadService {

	private Cloudinary cloudinary;

	@Autowired
	public ImageUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dkqjkyoqn", "api_key", "232646818972134",
				"api_secret", "3jRRdTIp90cIE3GoxnNuwkkVrGI"));
	}

	@Override
	public DataResult<Map<String, String>> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map<String, String>>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return new ErrorDataResult<Map<String, String>>();
	}

}
