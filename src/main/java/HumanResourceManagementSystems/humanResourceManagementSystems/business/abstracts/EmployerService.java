package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);

	Result delete(int id);

	Result update(Employer employer);

	DataResult<Employer> getById(int id);

	DataResult<List<Employer>> getAll();
}
