package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ProgrammingSkillService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.ProgrammingSkillDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ProgrammingSkill;

@Service
public class ProgrammingSkillManager implements ProgrammingSkillService {

	private ProgrammingSkillDao programmingSkillDao;

	@Autowired
	public ProgrammingSkillManager(ProgrammingSkillDao programmingSkillDao) {
		super();
		this.programmingSkillDao = programmingSkillDao;
	}

	@Override
	public Result add(ProgrammingSkill programmingSkill) {
		this.programmingSkillDao.save(programmingSkill);
		return new SuccessResult("Programlama becerileri eklendi.");
	}

	@Override
	public DataResult<ProgrammingSkill> getById(int id) {
		return new SuccessDataResult<ProgrammingSkill>(this.programmingSkillDao.getById(id));
	}

	@Override
	public DataResult<List<ProgrammingSkill>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<ProgrammingSkill>>(this.programmingSkillDao.getAllByJobSeekerId(id));
	}

}
