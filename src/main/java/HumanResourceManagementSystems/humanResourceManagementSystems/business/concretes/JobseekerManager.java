package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.CoverLetterService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ExperienceService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ForeignLanguageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ImageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobseekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.LinkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ProgrammingSkillService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SchoolService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.JobseekerDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Jobseeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobSeekerCurriculumVitaeDto;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;
	private SchoolService schoolService;
	private ExperienceService experienceService;
	private ForeignLanguageService foreignLanguageService;
	private LinkService linkService;
	private ProgrammingSkillService programmingSkillService;
	private CoverLetterService coverLetterService;
	private ImageService imageService;

	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao, 
			SchoolService schoolService, 
			ExperienceService experienceService, 
			ForeignLanguageService foreignLanguageService, 
			LinkService linkService, 
			ProgrammingSkillService programmingSkillService, 
			CoverLetterService coverLetterService,
			ImageService imageService) {
		super();
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {

		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll(), "İş arayanlar listelendi.");
	}

	@Override
	public Result add(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("İş arayan eklendi.");
	}

	@Override
	public DataResult<Jobseeker> getById(int id) {
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.getById(id));
	}

	@Override
	public DataResult<Jobseeker> getJobseekerByNationalId(String nationalityId) {
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.findJobseekerByNationalityId(nationalityId),
				"İş arayan kimlik id'ye göre getirildi.");
	}

	@Override
	public DataResult<JobSeekerCurriculumVitaeDto> getJobSeekerCurriculumVitaeDtosById(int id) {
		Jobseeker jobseeker = this.jobseekerDao.getById(id);
		JobSeekerCurriculumVitaeDto curriculumVitaeDto = new JobSeekerCurriculumVitaeDto();
		curriculumVitaeDto.schools = jobseeker.getSchools();
		curriculumVitaeDto.experiences = jobseeker.getExperiences();
		curriculumVitaeDto.foreignLanguages = jobseeker.getForeignLanguages();
		curriculumVitaeDto.links = jobseeker.getLinks();
		curriculumVitaeDto.programingSkills = jobseeker.getProgrammingSkills();
		curriculumVitaeDto.coverLetter = jobseeker.getCoverLetters();
		curriculumVitaeDto.image = jobseeker.getImages();
		return new SuccessDataResult<JobSeekerCurriculumVitaeDto>(curriculumVitaeDto);
	}

}
