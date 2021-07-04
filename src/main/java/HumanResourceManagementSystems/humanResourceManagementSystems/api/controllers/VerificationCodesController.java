package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.VerificationCodeService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.VerificationCode;

@CrossOrigin
@RestController
@RequestMapping("/api/verificationCodes")
public class VerificationCodesController {
	private VerificationCodeService verificationCodeService;

	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody VerificationCode code) {
		return this.verificationCodeService.add(code);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.verificationCodeService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody VerificationCode code) {
		return this.verificationCodeService.update(code);
	}

	@GetMapping("/getAll")
	public DataResult<List<VerificationCode>> getAll() {
		return this.verificationCodeService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<VerificationCode> getById(@RequestParam("id") int id) {
		return this.verificationCodeService.getById(id);
	}
}
