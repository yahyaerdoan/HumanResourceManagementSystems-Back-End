package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Image;

public interface ImageService {

	Result add(Image image, MultipartFile imageFile);

	Result delete(int id);

	Result update(Image image);

	DataResult<List<Image>> getAll();

	DataResult<Image> getById(int id);

	DataResult<Image> getByJobSeekerId(int id);
}
