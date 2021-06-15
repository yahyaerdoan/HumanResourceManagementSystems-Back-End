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

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SchoolService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.School;

@CrossOrigin
@RestController
@RequestMapping("api/schools")
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}

	@GetMapping("/getById")
	public DataResult<School> getById(@RequestParam int id) {
		return this.schoolService.getById(id);
	}

	@GetMapping("/getAllByJobSeekerIdOrderByEndAtDesc")
	public DataResult<List<School>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam int id) {
		return this.schoolService.getAllByJobSeekerIdOrderByEndAtDesc(id);
	}

	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<School>> getAllByJobSeekerId(@RequestParam int id) {
		return this.schoolService.getAllByJobSeekerId(id);
	}

}
