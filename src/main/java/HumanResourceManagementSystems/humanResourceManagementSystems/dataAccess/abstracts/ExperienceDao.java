package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {

	Experience getById(int id);

	List<Experience> getAllByJobseekerIdOrderByEndAtDesc(int id);

	List<Experience> getAllByJobseekerId(int id);
}
