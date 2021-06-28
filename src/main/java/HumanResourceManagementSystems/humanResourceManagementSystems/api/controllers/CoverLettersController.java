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

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.CoverLetterService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.CoverLetter;

@CrossOrigin
@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.coverLetterService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.update(coverLetter);
	}

	@GetMapping("/getall")
	public DataResult<List<CoverLetter>> getAll() {
		return this.coverLetterService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<CoverLetter> getById(@RequestParam("id") int id) {
		return this.coverLetterService.getById(id);
	}
}
