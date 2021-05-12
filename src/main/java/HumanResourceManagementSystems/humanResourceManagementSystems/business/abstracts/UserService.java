package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.User;

public interface UserService {

	List<User>getAll();
}
