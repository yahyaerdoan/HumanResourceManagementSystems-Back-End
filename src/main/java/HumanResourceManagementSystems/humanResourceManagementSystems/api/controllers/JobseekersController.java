package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobseekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Jobseeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobSeekerCurriculumVitaeDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersController {

	private JobseekerService jobseekerService;

	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Jobseeker jobseeker) {
		return this.jobseekerService.add(jobseeker);
	}

	@GetMapping("/getById")
	public DataResult<Jobseeker> getById(@RequestParam("id") int id) {
		return this.jobseekerService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<Jobseeker>> getAll() {
		return this.jobseekerService.getAll();
	}

	@GetMapping("/getJobSeekerCurriculumVitaeDtosById")
	public DataResult<JobSeekerCurriculumVitaeDto> getJobSeekerCurriculumVitaeDtosById(@RequestParam int id) {
		return this.jobseekerService.getJobSeekerCurriculumVitaeDtosById(id);
	}
}
