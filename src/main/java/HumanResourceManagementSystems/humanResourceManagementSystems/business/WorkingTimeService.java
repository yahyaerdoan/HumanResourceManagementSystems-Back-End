package HumanResourceManagementSystems.humanResourceManagementSystems.business;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.WorkingTime;

public interface WorkingTimeService {

	Result add(WorkingTime workingTime);

	DataResult<List<WorkingTime>> getAll();

	DataResult<WorkingTime> getWorkingByTime(String workingTime);
}
