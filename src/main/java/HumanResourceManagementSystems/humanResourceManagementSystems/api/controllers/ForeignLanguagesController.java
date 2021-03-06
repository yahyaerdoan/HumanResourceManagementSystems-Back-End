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

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ForeignLanguageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ForeignLanguage;

@CrossOrigin
@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguage foreignLanguage) {
		return this.foreignLanguageService.add(foreignLanguage);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.foreignLanguageService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody ForeignLanguage foreignLanguage) {
		return this.foreignLanguageService.update(foreignLanguage);
	}

	@GetMapping("/getall")
	public DataResult<List<ForeignLanguage>> getAll() {
		return this.foreignLanguageService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<ForeignLanguage> getById(@RequestParam("id") int id) {
		return this.foreignLanguageService.getById(id);
	}

	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<ForeignLanguage>> getAllByJobSeekerId(@RequestParam int id) {
		return this.foreignLanguageService.getAllByJobSeekerId(id);
	}
}
