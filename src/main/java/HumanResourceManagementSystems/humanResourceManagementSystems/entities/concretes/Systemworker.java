package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "systemworkers")
@PrimaryKeyJoinColumn(name = "userId")
@EqualsAndHashCode(callSuper = true)
public class Systemworker extends User {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	//private int id;

	// @Column(name="userId")
	// private int userId;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastNme")
	private String lastName;
	
	@Column(name = "systemWorkerName")
	private String systemWorkerName;

}
