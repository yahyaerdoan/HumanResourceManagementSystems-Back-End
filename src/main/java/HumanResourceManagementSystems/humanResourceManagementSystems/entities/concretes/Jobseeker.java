package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobseekers")
public class Jobseeker {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="typeofworksId")
	private int typeofworksId;
	
	@Column(name="nationalityId")
	private int nationalityId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;

}
