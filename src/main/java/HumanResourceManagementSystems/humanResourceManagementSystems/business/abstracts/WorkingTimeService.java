package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.WorkingTime;

public interface WorkingTimeService {

	Result add(WorkingTime workingTime);

	Result update(WorkingTime workingTime);

	Result delete(int id);

	DataResult<WorkingTime> getById(int id);

	DataResult<List<WorkingTime>> getAll();

	DataResult<WorkingTime> getWorkingByTime(String workingTime);
}
