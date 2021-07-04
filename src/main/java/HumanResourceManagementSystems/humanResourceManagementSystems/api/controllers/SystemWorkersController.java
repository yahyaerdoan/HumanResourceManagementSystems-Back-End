package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/add")
	public Result add(@RequestBody SystemWorker systemWorker) {
		return this.systemWorkerService.add(systemWorker);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.systemWorkerService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody SystemWorker systemWorker) {
		return this.systemWorkerService.update(systemWorker);
	}

	@GetMapping("/getById")
	public DataResult<SystemWorker> getById(@RequestParam("id") int id) {
		return this.systemWorkerService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<SystemWorker>> getAll() {
		return this.systemWorkerService.getAll();
	}
}
