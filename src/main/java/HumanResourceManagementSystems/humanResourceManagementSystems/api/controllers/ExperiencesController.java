package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ExperienceService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.add(experience);
	}

	@GetMapping("/getById")
	public DataResult<Experience> getById(@RequestParam int id) {
		return this.experienceService.getById(id);
	}

	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<Experience>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam("id") int id) {
		return this.experienceService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}

	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<Experience>> getAllByJobseekerId(@RequestParam int id) {
		return this.experienceService.getAllByJobseekerId(id);
	}
}
