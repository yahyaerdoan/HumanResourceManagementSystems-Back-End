package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Experience;

public interface ExperienceService {

	Result add(Experience experience);

	Result delete(int id);

	Result update(Experience experience);

	DataResult<List<Experience>> getAll();

	DataResult<Experience> getById(int id);

	DataResult<List<Experience>> getAllByJobSeekerIdOrderByEndAtDesc(int id);

	DataResult<List<Experience>> getAllByJobSeekerId(int id);
}
