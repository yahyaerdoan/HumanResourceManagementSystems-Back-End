package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

	School getById(int id);

	List<School> getAllByJobSeekerIdOrderByEndAtDesc(int id);

	List<School> getAllByJobSeekerId(int id);
}
