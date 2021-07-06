package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getById(int id);

	List<Employer> getByIsVerifiedFalse();
}
