package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Favorite;

public interface FavoriteService {

	Result add(Favorite favorite);

	Result delete(int id);

	Result update(Favorite favorite);

	DataResult<Favorite> getById(int id);

	DataResult<List<Favorite>> getAll();

	DataResult<List<Favorite>> getAllByJobSeekerId(int id);

	DataResult<Favorite> getByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId);

}
