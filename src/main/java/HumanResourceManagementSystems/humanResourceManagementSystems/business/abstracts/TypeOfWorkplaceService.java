package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWorkplace;

public interface TypeOfWorkplaceService {

	Result add(TypeOfWorkplace typeOfWorkplace);

	DataResult<List<TypeOfWorkplace>> getAll();

	DataResult<TypeOfWorkplace> getTypeByWorkplace(String typeOfWorkplace);
}
