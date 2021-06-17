package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.WorkingTimeService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.WorkingTimeDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService {

	private WorkingTimeDao workingTimeDao;

	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		super();
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public Result add(WorkingTime workingTime) {
		this.workingTimeDao.save(workingTime);
		return new SuccessResult("Çalışma zamanı türü eklendi.");
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll(),
				"Çalışma zamanı türleri listelendi.");
	}

	@Override
	public DataResult<WorkingTime> getWorkingByTime(String workingTime) {
		return new SuccessDataResult<WorkingTime>(this.workingTimeDao.findByWorkingTime(workingTime),
				"Çalışma zamanı türleri getirildi.");
	}

}
