package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobAdvertService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobAdvert;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/add")

	public Result add(@RequestBody JobAdvertDto jobAdvertDto) {
		return this.jobAdvertService.add(jobAdvertDto);
	}
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(int id){
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){		
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id){
		return this.jobAdvertService.changeOpenToClose(id);
	}
	
	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList(){
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}
	
	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAdvert>> getAllByOrderByPublishedAt(){
		return this.jobAdvertService.getAllByOrderByPublishedAt();
	}
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id){
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}
	@PostMapping("/activateAndConfirm")
	@Transactional
	public Result activateAndConfirm(@RequestParam int id) {
		return this.jobAdvertService.activateAndConfirm(id);
	}
	@GetMapping("/getByIsActiveFalse")
	public ResponseEntity<?> getByIsActiveFalse(){
		return ResponseEntity.ok(this.jobAdvertService.getByIsActiveFalse());
	}
	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvert>> getAllSorted() {
		return this.jobAdvertService.getAllSorted();
	}
}
