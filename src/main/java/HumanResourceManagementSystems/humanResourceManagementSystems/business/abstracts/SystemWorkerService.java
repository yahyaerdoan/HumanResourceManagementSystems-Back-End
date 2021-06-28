package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.SystemWorker;

public interface SystemWorkerService {

	Result add(SystemWorker systemWorker);

	Result delete(int id);

	Result update(SystemWorker systemWorker);

	DataResult<SystemWorker> getById(int id);

	DataResult<List<SystemWorker>> getAll();

}
