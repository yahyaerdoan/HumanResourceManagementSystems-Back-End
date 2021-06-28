package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobSeekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.JobSeekerDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobSeekerCurriculumVitaeDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi.");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerByNationalId(String nationalityId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findJobSeekerByNationalityId(nationalityId),
				"İş arayan kimlik id'ye göre getirildi.");
	}

	@Override
	public DataResult<JobSeekerCurriculumVitaeDto> getJobSeekerCurriculumVitaeDtosById(int id) {
		JobSeeker jobSeeker = this.jobSeekerDao.getById(id);
		JobSeekerCurriculumVitaeDto curriculumVitaeDto = new JobSeekerCurriculumVitaeDto();
		curriculumVitaeDto.schools = jobSeeker.getSchools();
		curriculumVitaeDto.experiences = jobSeeker.getExperiences();
		curriculumVitaeDto.foreignLanguages = jobSeeker.getForeignLanguages();
		curriculumVitaeDto.links = jobSeeker.getLinks();
		curriculumVitaeDto.programingSkills = jobSeeker.getProgrammingSkills();
		curriculumVitaeDto.coverLetter = jobSeeker.getCoverLetters();
		curriculumVitaeDto.image = jobSeeker.getImages();
		return new SuccessDataResult<JobSeekerCurriculumVitaeDto>(curriculumVitaeDto);
	}

}
