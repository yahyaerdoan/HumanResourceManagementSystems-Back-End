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

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.typeOfWorkplaceService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody TypeOfWorkplace typeOfWorkplace) {
		return this.typeOfWorkplaceService.update(typeOfWorkplace);
	}

	@GetMapping("/getById")
	public DataResult<TypeOfWorkplace> getById(@RequestParam("id") int id) {
		return this.typeOfWorkplaceService.getById(id);
	}

	@GetMapping("/getTypeByWorkplace")
	public DataResult<TypeOfWorkplace> getTypeByWorkplace(@RequestParam("typeOfWorkplace") String typeOfWorkplace) {
		return this.typeOfWorkplaceService.getTypeByWorkplace(typeOfWorkplace);
	}

	@GetMapping("/getall")
	public DataResult<List<TypeOfWorkplace>> getAll() {
		return this.typeOfWorkplaceService.getAll();
	}
}
