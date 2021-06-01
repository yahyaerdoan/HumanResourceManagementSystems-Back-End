package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Typeofwork;

public interface TypeofworkService {

	DataResult<List<Typeofwork>> getAll();

	Result add(Typeofwork typeofwork);	

	DataResult<Typeofwork> getWorkByTitle(String title);
}
