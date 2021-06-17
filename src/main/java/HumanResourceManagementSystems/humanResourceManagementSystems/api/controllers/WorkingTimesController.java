package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping("/getall")
	public DataResult<List<WorkingTime>> getAll() {
		return this.workingTimesService.getAll();
	}

}