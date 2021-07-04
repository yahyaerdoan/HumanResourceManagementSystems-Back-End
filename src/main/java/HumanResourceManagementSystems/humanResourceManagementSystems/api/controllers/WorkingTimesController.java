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

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.WorkingTimeService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.WorkingTime;

@CrossOrigin
@RestController
@RequestMapping("/api/workingtimes")
public class WorkingTimesController {

	private WorkingTimeService workingTimesService;

	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimesService) {
		super();
		this.workingTimesService = workingTimesService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkingTime workingTime) {
		return this.workingTimesService.add(workingTime);
	}

	@PutMapping("/update")
	public Result update(@RequestBody WorkingTime workingTime) {
		return this.workingTimesService.update(workingTime);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.workingTimesService.delete(id);
	}

	@GetMapping("/getById")
	public DataResult<WorkingTime> getById(@RequestParam("id") int id) {
		return this.workingTimesService.getById(id);
	}

	@GetMapping("/getWorkingByTime")
	public DataResult<WorkingTime> getWorkingByTime(@RequestParam("workingTime") String workingTime) {
		return this.workingTimesService.getWorkingByTime(workingTime);
	}

	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll() {
		return this.workingTimesService.getAll();
	}

}
