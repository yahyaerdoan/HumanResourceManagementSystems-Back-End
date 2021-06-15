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
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobSeekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Image;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private ImageService imageService;
	private JobSeekerService jobSeekerService;

	@Autowired
	public ImagesController(ImageService imageService, JobSeekerService jobSeekerService) {
		super();
		this.imageService = imageService;
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		JobSeeker jobSeeker = this.jobSeekerService.getById(id).getData();
		Image image = new Image();
		image.setJobSeeker(jobSeeker);
		return this.imageService.add(image, imageFile);
	}

	@GetMapping("/getById")
	public DataResult<Image> getById(@RequestParam("id") int id) {
		return this.imageService.getById(id);
	}

	@GetMapping("/getByJobseekerId")
	public DataResult<Image> getByJobSeekerId(@RequestParam int id) {
		return this.imageService.getByJobSeekerId(id);
	}
}
