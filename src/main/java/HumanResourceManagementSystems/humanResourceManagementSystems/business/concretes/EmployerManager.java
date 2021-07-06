package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.EmployerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.EmployerDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private ObjectMapper objectMapper;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ObjectMapper objectMapper) {
		super();
		this.employerDao = employerDao;
		this.objectMapper = objectMapper;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İş veren bilgisi eklendi.");
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("İş veren bilgisi silindi.");
	}

	@Override
	public Result updateWaiting(Employer employer) {
		Employer updateEmployer = this.getById(employer.getId()).getData();
		@SuppressWarnings("unchecked")
		Map<String, Object> update = this.objectMapper.convertValue(employer, Map.class);
		updateEmployer.setEmployerUpdate(update);
		this.employerDao.save(updateEmployer);
		return new SuccessResult("iş veren bilgisi doğrulanmayı bekliyor.");
	}

	@Override
	public Result updateIsVerified(int id) {
		Employer employerToIsVerified = this.getById(id).getData();
		Employer tempEmployer = this.objectMapper.convertValue(employerToIsVerified.getEmployerUpdate(),
				Employer.class);
		tempEmployer.setEmployerUpdate(null);
		this.employerDao.save(tempEmployer);
		return new SuccessResult("iş veren bilgisi güncellendi.");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}

	@Override
	public DataResult<List<Employer>> getByIsVerifiedFalse() {
		return new SuccessDataResult<List<Employer>>(employerDao.getByIsVerifiedFalse());
	}

}
