package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.FavoriteService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.FavoriteDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Favorite;

@Service
public class FavoriteManager implements FavoriteService {

	private FavoriteDao favoriteDao;

	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao) {
		super();
		this.favoriteDao = favoriteDao;
	}

	@Override
	public Result add(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult("Favorilerime eklendi.");
	}

	@Override
	public Result delete(int id) {
		this.favoriteDao.deleteById(id);
		return new SuccessResult("Favorilerimden silindi.");
	}

	@Override
	public Result update(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult("Favorilerim güncellendi.");
	}

	@Override
	public DataResult<Favorite> getById(int id) {
		return new SuccessDataResult<Favorite>(this.favoriteDao.getById(id));
	}

	@Override
	public DataResult<List<Favorite>> getAll() {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.findAll());
	}

	@Override
	public DataResult<List<Favorite>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getAllByJobSeekerId(id));
	}

	@Override
	public DataResult<Favorite> getByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId) {
		return new SuccessDataResult<Favorite>(
				this.favoriteDao.findByJobSeekerIdAndJobAdvertId(jobSeekerId, jobAdvertId));
	}

}