package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.add(experience);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.experienceService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Experience experience) {
		return this.experienceService.update(experience);
	}

	@GetMapping("/getAll")
	public DataResult<List<Experience>> getAll() {
		return this.experienceService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Experience> getById(@RequestParam int id) {
		return this.experienceService.getById(id);
	}

	@GetMapping("/getAllByJobSeekerIdOrderByEndAtDesc")
	public DataResult<List<Experience>> getAllByJobSeekerIdOrderByEndAtDesc(@RequestParam("id") int id) {
		return this.experienceService.getAllByJobSeekerIdOrderByEndAtDesc(id);
	}

	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<Experience>> getAllByJobSeekerId(@RequestParam int id) {
		return this.experienceService.getAllByJobSeekerId(id);
	}
}
