package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobSeekerCurriculumVitaeDto;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();

	Result add(JobSeeker jobSeeker);

	DataResult<JobSeeker> getById(int id);

	DataResult<JobSeeker> getJobSeekerByNationalId(String nationalityId);
	
	DataResult<JobSeekerCurriculumVitaeDto> getJobSeekerCurriculumVitaeDtosById(int id);
}
