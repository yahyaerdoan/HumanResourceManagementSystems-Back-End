package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobSeekerCurriculumVitaeDto;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);

	Result delete(int id);

	Result update(JobSeeker jobSeeker);

	DataResult<List<JobSeeker>> getAll();

	DataResult<JobSeeker> getById(int id);

	DataResult<JobSeeker> getJobSeekerByNationalId(String nationalityId);

	DataResult<JobSeekerCurriculumVitaeDto> getJobSeekerCurriculumVitaeDtosById(int id);
}
