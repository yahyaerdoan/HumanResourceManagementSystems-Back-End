package HumanResourceManagementSystems.humanResourceManagementSystems.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.LinkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Link;

@CrossOrigin
@RestController
@RequestMapping("/api/links")
public class LinksController {

	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Link link) {
		return this.linkService.add(link);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.linkService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Link link) {
		return this.linkService.update(link);
	}

	@GetMapping("/getAll")
	public DataResult<List<Link>> getAll() {
		return this.linkService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Link> getById(@RequestParam("id") int id) {
		return this.linkService.getById(id);
	}

	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<Link>> getAllByJobSeekerId(@RequestParam int id) {
		return this.linkService.getAllByJobSeekerId(id);
	}
}
