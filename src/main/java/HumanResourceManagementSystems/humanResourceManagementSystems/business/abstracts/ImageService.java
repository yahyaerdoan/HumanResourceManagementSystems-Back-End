package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Image;

public interface ImageService {

	Result add(Image image, MultipartFile imageFile);

	DataResult<Image> getById(int id);

	DataResult<Image> getByJobseekerId(int id);
}
