package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobadverts")
@EqualsAndHashCode(callSuper = true)
public class JobAdvert extends Base {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	//private int id;

	// @Column(name = "typeOfWorkId")
	// private int typeOfWorkId;

	// @Column(name = "employerId")
	// private int employerId;

	// @Column(name = "cityId")
	// private int cityId;
	
	// @Column(name = "typeOfWorkplaceId")
	// private int typeOfWorkplaceId;
	
	// @Column(name = "workingTimeId")
	// private int workingTimeId;

	@Column(name = "description")
	private String description;

	@Column(name = "salaryMin")
	private int salaryMin;

	@Column(name = "salaryMax")
	private int salaryMax;

	@Column(name = "openPositionCount")
	private int openPositionCount;

	@Column(name = "deadline")
	private LocalDate deadline;

	@Column(name = "publishedAt")
	private LocalDate publishedAt;
	
	@Column(name = "isOpen")
	private boolean isOpen;
	
	
	@ManyToOne
	@JoinColumn(name = "typeOfWorkId")
	private TypeOfWork typeOfWork;

	@ManyToOne
	@JoinColumn(name = "employerId")
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "cityId")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "typeOfWorkplaceId")
	private TypeOfWorkplace typeOfWorkplace;
	
	@ManyToOne
	@JoinColumn(name = "workingTimeId")
	private WorkingTime workingTime;
	
	@OneToMany(mappedBy = "jobAdvert")
	@JsonIgnore
	private List<Favorite> favorite;

}
