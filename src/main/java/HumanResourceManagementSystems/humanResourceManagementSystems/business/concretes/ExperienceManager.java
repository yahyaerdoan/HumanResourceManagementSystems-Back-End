package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ExperienceService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.ExperienceDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("İş tecrübeleri eklendi.");
	}

	@Override
	public DataResult<Experience> getById(int id) {
		return new SuccessDataResult<Experience>(this.experienceDao.getById(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByJobSeekerIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByJobSeekerIdOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByJobSeekerId(id));
	}

}
