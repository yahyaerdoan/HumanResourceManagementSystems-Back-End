package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode code);

	Result delete(int id);

	Result update(VerificationCode code);

	DataResult<VerificationCode> getById(int id);

	DataResult<List<VerificationCode>> getAll();
}
