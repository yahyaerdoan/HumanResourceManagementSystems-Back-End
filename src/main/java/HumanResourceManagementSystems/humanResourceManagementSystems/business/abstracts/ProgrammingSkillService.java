package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillService {

	Result add(ProgrammingSkill programmingSkill);

	DataResult<ProgrammingSkill> getById(int id);

	DataResult<List<ProgrammingSkill>> getAllByJobseekerId(int id);
}
