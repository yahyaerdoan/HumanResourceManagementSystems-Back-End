package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWork;

public interface TypeOfWorkDao extends JpaRepository<TypeOfWork, Integer> {

	TypeOfWork findByTitle(String title);

	TypeOfWork getById(String id);
}
