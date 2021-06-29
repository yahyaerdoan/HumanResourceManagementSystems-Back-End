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

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.FavoriteService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Favorite;

@CrossOrigin
@RestController
@RequestMapping("/api/favorities")
public class FavoritiesController {

	private FavoriteService favoriteService;

	@Autowired
	public FavoritiesController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Favorite favorite) {

		return this.favoriteService.add(favorite);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {

		return this.favoriteService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Favorite favorite) {

		return this.favoriteService.update(favorite);
	}

	@GetMapping("/getById")
	public DataResult<Favorite> getById(@RequestParam int id) {
		return this.favoriteService.getById(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<Favorite>> getAll() {
		return this.favoriteService.getAll();
	}

	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<Favorite>> getAllByJobSeekerId(@RequestParam int id) {
		return this.favoriteService.getAllByJobSeekerId(id);
	}

	@GetMapping("/getByJobSeekerIdAndJobAdvertId")
	public DataResult<Favorite> findByJobSeekerIdAndJobAdvertId(@RequestParam int jobSeekerId,
			@RequestParam int jobAdvertId) {
		return this.favoriteService.getByJobSeekerIdAndJobAdvertId(jobSeekerId, jobAdvertId);
	}
}
