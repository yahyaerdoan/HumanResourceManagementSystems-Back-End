package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

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
@Table(name = "programmingskills")
@EqualsAndHashCode(callSuper = true)
public class ProgrammingSkill extends Base {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	//private int id;

	@Column(name = "skillName")
	private String skillName;

	@ManyToOne()
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;
}
