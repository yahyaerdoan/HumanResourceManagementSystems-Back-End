package HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.CoverLetter;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Experience;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ForeignLanguage;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Image;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Link;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ProgrammingSkill;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.School;

public class JobSeekerCurriculumVitaeDto {

	public JobSeeker jobSeeker;
	
	public List<School> schools;
	
	public List<Experience> experiences;
	
	public List<ForeignLanguage> foreignLanguages;
	
	public List<Link> links;
	
	public List<ProgrammingSkill> programingSkills;
	
	public List<CoverLetter> coverLetter;
	
	public Image image;
}
