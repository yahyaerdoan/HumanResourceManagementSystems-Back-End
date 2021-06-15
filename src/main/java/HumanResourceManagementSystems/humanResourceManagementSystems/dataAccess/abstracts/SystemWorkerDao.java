package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.SystemWorker;

public interface SystemWorkerDao extends JpaRepository<SystemWorker, Integer> {

	SystemWorker getById(int id);
}
