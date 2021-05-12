package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeofworkService;
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
	public List<Typeofwork>getAll(){
		return this.typeofworkService.getAll();
	}	
}
