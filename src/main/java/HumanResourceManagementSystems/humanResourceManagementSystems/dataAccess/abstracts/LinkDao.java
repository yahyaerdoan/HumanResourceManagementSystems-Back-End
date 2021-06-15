package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {

	Link getById(int id);

	List<Link> getAllByJobSeekerId(int id);
}
