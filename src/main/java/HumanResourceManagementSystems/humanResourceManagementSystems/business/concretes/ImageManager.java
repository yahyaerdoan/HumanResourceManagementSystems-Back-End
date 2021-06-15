package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ImageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.imageUpload.ImageUploadService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.ImageDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result add(Image image, MultipartFile imageFile) {
		Map<String, String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf eklendi.");
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(this.imageDao.getById(id));
	}

	@Override
	public DataResult<Image> getByJobSeekerId(int id) {
		return new SuccessDataResult<Image>(this.imageDao.getByJobSeekerId(id));
	}

}
