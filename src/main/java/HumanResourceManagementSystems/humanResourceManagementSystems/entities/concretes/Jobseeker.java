package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobseekers")
@PrimaryKeyJoinColumn(name = "userId")
@EqualsAndHashCode(callSuper=false)
public class Jobseeker extends User{

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	//private int id;
	
	//@Column(name="userId")
	//private int userId;
	
	@Column(name="typeOfWorkId")
	private int typeOfWorkId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="nationalityId")
	private String nationalityId;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;
	
	@Column(name = "isVerified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
	
}
