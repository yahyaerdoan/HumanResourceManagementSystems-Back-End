package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SystemWorkerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.SystemWorkerDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.SystemWorker;

@Service
public class SystemWorkerManager implements SystemWorkerService {

	private SystemWorkerDao systemWorkerDao;

	@Autowired
	public SystemWorkerManager(SystemWorkerDao systemWorkerDao) {
		super();
		this.systemWorkerDao = systemWorkerDao;
	}

	@Override
	public DataResult<List<SystemWorker>> getAll() {

		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(),
				"Sistem çalışanları listelendi.");
	}

	@Override
	public Result add(SystemWorker systemWorker) {
		this.systemWorkerDao.save(systemWorker);
		return new SuccessResult("Sistem çalışını eklendi.");
	}

}
