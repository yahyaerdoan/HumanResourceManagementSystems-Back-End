package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWork;

public interface TypeOfWorkService {

	Result add(TypeOfWork typeOfWork);

	Result delete(int id);

	Result update(TypeOfWork typeOfWork);

	DataResult<TypeOfWork> getById(int id);

	DataResult<List<TypeOfWork>> getAll();

	DataResult<TypeOfWork> getWorkByTitle(String title);
}
