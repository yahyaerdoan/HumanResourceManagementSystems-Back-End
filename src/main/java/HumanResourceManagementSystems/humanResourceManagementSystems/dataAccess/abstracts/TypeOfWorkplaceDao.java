package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWorkplace;

public interface TypeOfWorkplaceDao extends JpaRepository<TypeOfWorkplace, Integer> {

	TypeOfWorkplace findByTypeOfWorkplace(String typeOfWorkplace);

	TypeOfWorkplace getById(int id);
}
