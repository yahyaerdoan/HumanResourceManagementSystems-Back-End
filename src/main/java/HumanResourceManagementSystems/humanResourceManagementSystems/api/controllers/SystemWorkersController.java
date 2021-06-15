package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SystemWorkerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.SystemWorker;

@CrossOrigin
@RestController
@RequestMapping("/api/systemworkers")
public class SystemWorkersController {

	private SystemWorkerService systemWorkerService;

	@Autowired
	public SystemWorkersController(SystemWorkerService systemWorkerService) {
		super();
		this.systemWorkerService = systemWorkerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemWorker>> getAll(){
		return this.systemWorkerService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody SystemWorker systemWorker) {
		return this.systemWorkerService.add(systemWorker);		
	}
}
