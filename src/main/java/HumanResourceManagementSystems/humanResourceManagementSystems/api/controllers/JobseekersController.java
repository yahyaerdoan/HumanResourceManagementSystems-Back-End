package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobseekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersController {

	private JobseekerService jobseekerService;

	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}
	
	@GetMapping("/getall")
	public List<Jobseeker>getAll(){
		return this.jobseekerService.getAll();
	}
}