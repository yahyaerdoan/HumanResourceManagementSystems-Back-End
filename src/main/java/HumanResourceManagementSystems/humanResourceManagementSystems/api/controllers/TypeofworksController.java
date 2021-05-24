package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeofworkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Typeofwork;

@RestController
@RequestMapping("/api/typeofworks")
public class TypeofworksController {
	
	@Autowired
	private TypeofworkService typeofworkService;

	public TypeofworksController(TypeofworkService typeofworkService) {
		super();
		this.typeofworkService = typeofworkService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Typeofwork>> getAll(){
		return this.typeofworkService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Typeofwork typeofwork) {
		return this.typeofworkService.add(typeofwork);		
	}
}
