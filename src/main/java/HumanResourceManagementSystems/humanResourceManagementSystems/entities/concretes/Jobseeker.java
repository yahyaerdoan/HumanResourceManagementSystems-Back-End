package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseekers")
@PrimaryKeyJoinColumn(name = "userId")
@EqualsAndHashCode(callSuper = true)
public class Jobseeker extends User {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	//private int id;

	//@Column(name="userId")
	//private int userId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "nationalityId")
	private String nationalityId;

	@Column(name = "dateOfBirth")
	private LocalDate dateOfBirth;

	@Column(name = "isVerified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	
	@OneToMany(mappedBy = "jobseeker")
	@JsonIgnore
	private List<School> schools;

	
	@OneToMany(mappedBy = "jobseeker")
	@JsonIgnore
	private List<Experience> experiences;

	
	@OneToMany(mappedBy = "jobseeker")
	@JsonIgnore
	private List<ForeignLanguage> foreignLanguages;

	
	@OneToOne(mappedBy = "jobseeker", fetch = FetchType.LAZY)
	@JsonIgnore
	private Image images;

	
	@OneToMany(mappedBy = "jobseeker")
	@JsonIgnore
	private List<Link> links;

	
	@OneToMany(mappedBy = "jobseeker")
	@JsonIgnore
	private List<ProgrammingSkill> programmingSkills;

	
	@OneToMany(mappedBy = "jobseeker")
	@JsonIgnore
	private List<CoverLetter> coverLetters;
}
