package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ProgrammingSkillService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ProgrammingSkill;

@RestController
@RequestMapping("/api/programmingskills")
public class ProgrammingSkillsController {

	private ProgrammingSkillService programmingSkillService;

	public ProgrammingSkillsController(ProgrammingSkillService programmingSkillService) {
		super();
		this.programmingSkillService = programmingSkillService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingSkill programmingSkill) {
		return this.programmingSkillService.add(programmingSkill);
	}

	@GetMapping("/getById")
	public DataResult<ProgrammingSkill> getById(@RequestParam("id") int id) {
		return this.programmingSkillService.getById(id);
	}

	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ProgrammingSkill>> getAllByJobseekerId(@RequestParam int id) {
		return this.programmingSkillService.getAllByJobseekerId(id);
	}
}
