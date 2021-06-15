package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping("/getall")
	public DataResult<List<TypeOfWork>> getAll() {
		return this.typeOfWorkService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody TypeOfWork typeOfWork) {
		return this.typeOfWorkService.add(typeOfWork);
	}
}
