package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SystemworkerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.SystemworkerDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Systemworker;

@Service
public class SystemworkerManager implements SystemworkerService{

	private SystemworkerDao systemworkerDao;
	
	@Autowired
	public SystemworkerManager(SystemworkerDao systemworkerDao) {
		super();
		this.systemworkerDao = systemworkerDao;
	}

	@Override
	public DataResult<List<Systemworker>> getAll() {
		
		return new SuccessDataResult<List<Systemworker>>
		(this.systemworkerDao.findAll(), "Sistem Çalışanları Listelendi!");				
	}

	@Override
	public Result add(Systemworker systemworker) {
		this.systemworkerDao.save(systemworker);
		return new SuccessResult("Sistem Çalışını Eklendi!");
	}

}
