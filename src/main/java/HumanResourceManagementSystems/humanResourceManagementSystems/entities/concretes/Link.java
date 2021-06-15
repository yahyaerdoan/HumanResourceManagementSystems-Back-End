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
@Table(name = "links")
@EqualsAndHashCode(callSuper = true)
public class Link extends Base {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	//private int id;

	@Column(name = "linkName")
	private String linkName;

	@Column(name = "url")
	private String url;

	@ManyToOne()
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;
}
