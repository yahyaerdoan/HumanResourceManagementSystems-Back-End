package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	JobSeeker findJobSeekerByNationalityId(String nationalityId);

	JobSeeker getById(int id);

}
