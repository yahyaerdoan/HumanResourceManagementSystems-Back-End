package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.AuthService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Employer;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/registerEmployer")
	public Result registerEmpolyer(@RequestBody Employer employer, @RequestParam String confirmPassword) {
		return this.authService.registerEmployer(employer, confirmPassword);
	}

	@PostMapping("/registerJobseeker")
	public Result registerJobseeker(@RequestBody JobSeeker jobSeeker, @RequestParam String confirmPassword) {
		return this.authService.registerJobSeeker(jobSeeker, confirmPassword);
	}
}
