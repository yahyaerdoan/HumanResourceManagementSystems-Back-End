package HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;

public interface ImageUploadService {

	DataResult<Map<String, String>> uploadImageFile(MultipartFile imageFile);
}
