package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ImageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobseekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Image;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Jobseeker;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private ImageService imageService;
	private JobseekerService jobseekerService;

	@Autowired
	public ImagesController(ImageService imageService, JobseekerService jobseekerService) {
		super();
		this.imageService = imageService;
		this.jobseekerService = jobseekerService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		Jobseeker jobseeker = this.jobseekerService.getById(id).getData();
		Image image = new Image();
		image.setJobseeker(jobseeker);
		return this.imageService.add(image, imageFile);
	}

	@GetMapping("/getById")
	public DataResult<Image> getById(@RequestParam("id") int id) {
		return this.imageService.getById(id);
	}

	@GetMapping("/getByJobseekerId")
	public DataResult<Image> getByJobseekerId(@RequestParam int id) {
		return this.imageService.getByJobseekerId(id);
	}
}
