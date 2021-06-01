package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Typeofwork;

public interface TypeofworkDao extends JpaRepository<Typeofwork, Integer> {

	Typeofwork findByTitle(String title);

	Typeofwork getById(String id);
}
