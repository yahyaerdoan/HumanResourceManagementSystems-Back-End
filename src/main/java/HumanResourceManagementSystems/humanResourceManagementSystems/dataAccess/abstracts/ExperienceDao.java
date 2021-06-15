package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {

	Experience getById(int id);

	List<Experience> getAllByJobSeekerIdOrderByEndAtDesc(int id);

	List<Experience> getAllByJobSeekerId(int id);
}
