package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.CoverLetterService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ExperienceService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ForeignLanguageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ImageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobSeekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.LinkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ProgrammingSkillService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SchoolService;
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
	private SchoolService schoolService;
	private ExperienceService experienceService;
	private ForeignLanguageService foreignLanguageService;
	private LinkService linkService;
	private ProgrammingSkillService programmingSkillService;
	private CoverLetterService coverLetterService;
	private ImageService imageService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, 
			SchoolService schoolService, 
			ExperienceService experienceService, 
			ForeignLanguageService foreignLanguageService, 
			LinkService linkService, 
			ProgrammingSkillService programmingSkillService, 
			CoverLetterService coverLetterService,
			ImageService imageService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi.");
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
