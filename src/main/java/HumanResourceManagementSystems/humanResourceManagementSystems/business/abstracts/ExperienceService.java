package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Experience;

public interface ExperienceService {

	Result add(Experience experience);

	DataResult<Experience> getById(int id);

	DataResult<List<Experience>> getAllByJobseekerIdOrderByEndAtDesc(int id);

	DataResult<List<Experience>> getAllByJobseekerId(int id);
}
