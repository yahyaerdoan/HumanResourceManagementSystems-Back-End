package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobAdvertService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobAdvert;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertDto;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertFilterDto;

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

	@PutMapping("/update")
	public Result update(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.update(jobAdvert);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.jobAdvertService.delete(id);
	}

	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(int id) {
		return this.jobAdvertService.getById(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertService.getAll();
	}

	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id) {
		return this.jobAdvertService.changeOpenToClose(id);
	}

	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}

	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAdvert>> getAllByOrderByPublishedAt() {
		return this.jobAdvertService.getAllByOrderByPublishedAt();
	}

	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id) {
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}

	@PostMapping("/activateAndConfirm")
	@Transactional
	public Result activateAndConfirm(@RequestParam int id) {
		return this.jobAdvertService.activateAndConfirm(id);
	}

	@PostMapping("/updateconfirmStatus")
	@Transactional
	public Result updateconfirmStatus(@RequestParam int id) {
		return this.jobAdvertService.updateconfirmStatus(id);
	}

	@GetMapping("/getAllByIsActiveFalse")
	public ResponseEntity<?> getAllByIsActiveFalse() {
		return ResponseEntity.ok(this.jobAdvertService.getAllByIsActiveFalse());
	}

	@GetMapping("/getAllByIsActiveTrue")
	public ResponseEntity<?> getAllByIsActiveTrue() {
		return ResponseEntity.ok(this.jobAdvertService.getAllByIsActiveTrue());
	}

	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvert>> getAllSorted() {
		return this.jobAdvertService.getAllSorted();
	}

	@GetMapping("/getByEmployerId")
	public ResponseEntity<?> getByEmployerId(@RequestParam int id) {
		return ResponseEntity.ok(this.jobAdvertService.getByEmployerId(id));
	}

	@GetMapping("/getByisActiveTrueAndConfirmStatusTrue")
	public ResponseEntity<?> getByisActiveTrueAndConfirmStatusTrue() {
		return ResponseEntity.ok(this.jobAdvertService.getByisActiveTrueAndConfirmStatusTrue());
	}

	@GetMapping("/getByPage")
	public ResponseEntity<?> getByisActiveTrueAndConfirmStatusTrue(@RequestParam int pageNo,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(this.jobAdvertService.getByisActiveTrueAndConfirmStatusTrue(pageNo, pageSize));
	}

	@PostMapping("/getByisActiveTrueAndConfirmStatusTrueAndFilter")
	public Result getByisActiveTrueAndConfirmStatusTrueAndFilter(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestBody JobAdvertFilterDto jobAdvertFilterDto) {
		return jobAdvertService.getByisActiveTrueAndConfirmStatusTrueAndFilter(pageNo, pageSize, jobAdvertFilterDto);
	}
}
