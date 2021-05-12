package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SystemworkerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Systemworker;

@RestController
@RequestMapping("/api/systemworkers")
public class SystemworkersController {

	private SystemworkerService systemworkerService;

	@Autowired
	public SystemworkersController(SystemworkerService systemworkerService) {
		super();
		this.systemworkerService = systemworkerService;
	}
	
	@GetMapping("/getall")
	public List<Systemworker>getAll(){
		return this.systemworkerService.getAll();
	}
}
