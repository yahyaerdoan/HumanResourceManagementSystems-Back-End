package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite")
@EqualsAndHashCode(callSuper = true)
public class Favorite extends Base {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id")
	// private int id;

	@ManyToOne()
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;

	@ManyToOne()
	@JoinColumn(name = "jobAdvertId")
	private JobAdvert jobAdvert;
}
