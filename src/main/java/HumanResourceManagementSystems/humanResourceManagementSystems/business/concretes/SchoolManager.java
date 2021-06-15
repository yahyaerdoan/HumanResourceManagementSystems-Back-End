package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SchoolService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.SchoolDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgileri eklendi.");
	}

	@Override
	public DataResult<School> getById(int id) {
		return new SuccessDataResult<School>(this.schoolDao.getById(id));
	}


	@Override
	public DataResult<List<School>> getAllByJobSeekerIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByJobSeekerId(id));
	}

	@Override
	public DataResult<List<School>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByJobSeekerIdOrderByEndAtDesc(id));
	}

}
