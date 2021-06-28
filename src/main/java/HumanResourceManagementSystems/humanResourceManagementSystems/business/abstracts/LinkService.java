package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);

	Result delete(int id);

	Result update(Link link);

	DataResult<List<Link>> getAll();

	DataResult<Link> getById(int id);

	DataResult<List<Link>> getAllByJobSeekerId(int id);
}
