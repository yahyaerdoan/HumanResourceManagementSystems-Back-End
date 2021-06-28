package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.School;

public interface SchoolService {

	Result add(School school);

	Result delete(int id);

	Result update(School school);

	DataResult<List<School>> getAll();

	DataResult<School> getById(int id);

	DataResult<List<School>> getAllByJobSeekerId(int id);

	DataResult<List<School>> getAllByJobSeekerIdOrderByEndAtDesc(int id);

}
