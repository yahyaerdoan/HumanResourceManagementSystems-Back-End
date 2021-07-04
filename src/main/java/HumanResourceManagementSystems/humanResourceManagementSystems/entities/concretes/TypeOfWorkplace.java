package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "typeofworkplaces")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts" })
public class TypeOfWorkplace extends Base {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id")
	// private int id;
	
	@Column(name = "typeOfWorkplace")
	private String typeOfWorkplace;

	@OneToMany(mappedBy = "typeOfWorkplace") // jobAdverts tablosu typeofwork tablosu ile ilişkilendirilmiş durumda
	private List<JobAdvert> jobAdverts;
	
}
