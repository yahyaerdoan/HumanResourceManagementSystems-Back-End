package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {

	Result add(ForeignLanguage foreignLanguage);

	Result delete(int id);

	Result update(ForeignLanguage foreignLanguage);

	DataResult<List<ForeignLanguage>> getAll();

	DataResult<ForeignLanguage> getById(int id);

	DataResult<List<ForeignLanguage>> getAllByJobSeekerId(int id);
}
