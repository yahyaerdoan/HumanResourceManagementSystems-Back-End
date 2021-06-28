package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/api/programmingskills")
public class ProgrammingSkillsController {

	private ProgrammingSkillService programmingSkillService;

	@Autowired
	public ProgrammingSkillsController(ProgrammingSkillService programmingSkillService) {
		super();
		this.programmingSkillService = programmingSkillService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingSkill programmingSkill) {
		return this.programmingSkillService.add(programmingSkill);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.programmingSkillService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody ProgrammingSkill programmingSkill) {
		return this.programmingSkillService.update(programmingSkill);
	}

	@GetMapping("/getAll")
	public DataResult<List<ProgrammingSkill>> getAll() {
		return this.programmingSkillService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<ProgrammingSkill> getById(@RequestParam("id") int id) {
		return this.programmingSkillService.getById(id);
	}

	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<ProgrammingSkill>> getAllByJobSeekerId(@RequestParam int id) {
		return this.programmingSkillService.getAllByJobSeekerId(id);
	}
}
