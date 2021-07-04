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

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeOfWorkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWork;

@CrossOrigin
@RestController
@RequestMapping("/api/typeofworks")
public class TypeOfWorksController {

	private TypeOfWorkService typeOfWorkService;

	@Autowired
	public TypeOfWorksController(TypeOfWorkService typeOfWorkService) {
		super();
		this.typeOfWorkService = typeOfWorkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody TypeOfWork typeOfWork) {
		return this.typeOfWorkService.add(typeOfWork);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.typeOfWorkService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody TypeOfWork typeOfWork) {
		return this.typeOfWorkService.update(typeOfWork);
	}

	@GetMapping("/getById")
	public DataResult<TypeOfWork> getById(@RequestParam("id") int id) {
		return this.typeOfWorkService.getById(id);
	}

	@GetMapping("/getWorkByTitle")
	public DataResult<TypeOfWork> getWorkByTitle(@RequestParam("title") String title) {
		return this.typeOfWorkService.getWorkByTitle(title);
	}

	@GetMapping("/getAll")
	public DataResult<List<TypeOfWork>> getAll() {
		return this.typeOfWorkService.getAll();
	}

}
