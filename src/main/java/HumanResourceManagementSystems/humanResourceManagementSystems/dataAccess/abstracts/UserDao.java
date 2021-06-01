package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findUserByEmailAddress(String emailAddress);

	User getById(int id);
}
