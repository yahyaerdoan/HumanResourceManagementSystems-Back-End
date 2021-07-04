package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.User;

public interface UserService {

	Result add(User user);

	Result delete(int id);

	Result update(User user);

	DataResult<User> getById(int id);

	DataResult<List<User>> getAll();

	DataResult<User> getUserByEmailAddress(String emailAddress);
}
