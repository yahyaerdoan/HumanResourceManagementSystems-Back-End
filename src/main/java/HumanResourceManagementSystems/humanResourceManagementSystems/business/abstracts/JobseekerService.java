package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Jobseeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobSeekerCurriculumVitaeDto;

public interface JobseekerService {

	DataResult<List<Jobseeker>> getAll();

	Result add(Jobseeker jobseeker);

	DataResult<Jobseeker> getById(int id);

	DataResult<Jobseeker> getJobseekerByNationalId(String nationalityId);
	
	DataResult<JobSeekerCurriculumVitaeDto> getJobSeekerCurriculumVitaeDtosById(int id);
}
