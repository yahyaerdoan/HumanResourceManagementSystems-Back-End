package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.EmployerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.EmployerDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	@Override
	public List<Employer> getAll() {
		
		return this.employerDao.findAll();
	}

}
