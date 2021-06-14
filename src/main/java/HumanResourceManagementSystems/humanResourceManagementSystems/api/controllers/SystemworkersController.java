package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SystemworkerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Systemworker;

@CrossOrigin
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
	public DataResult<List<Systemworker>> getAll(){
		return this.systemworkerService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Systemworker systemworker) {
		return this.systemworkerService.add(systemworker);		
	}
}
