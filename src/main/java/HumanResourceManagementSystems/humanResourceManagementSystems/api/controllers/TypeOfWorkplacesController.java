package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeOfWorkplaceService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWorkplace;

@CrossOrigin
@RestController
@RequestMapping("/api/typeofworkplaces")
public class TypeOfWorkplacesController {

	private TypeOfWorkplaceService typeOfWorkplaceService;

	@Autowired
	public TypeOfWorkplacesController(TypeOfWorkplaceService typeOfWorkplaceService) {
		super();
		this.typeOfWorkplaceService = typeOfWorkplaceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody TypeOfWorkplace typeOfWorkplace) {
		return this.typeOfWorkplaceService.add(typeOfWorkplace);
	}

	@GetMapping("/getall")
	public DataResult<List<TypeOfWorkplace>> getAll() {
		return this.typeOfWorkplaceService.getAll();
	}
}
