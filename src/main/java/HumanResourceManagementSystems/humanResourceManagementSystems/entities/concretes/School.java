package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
@EqualsAndHashCode(callSuper = true)
public class School extends Base {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	//private int id;
	
	@Column(name = "schoolName")
	private String schoolName;

	@Column(name = "department")
	private String department;

	@Column(name = "startAt")
	private LocalDate startAt;

	@Column(name = "endAt", nullable = true)
	private LocalDate endAt;
	
	@ManyToOne()
	@JoinColumn(name = "jobseekerId")
	private Jobseeker jobseeker;
}
