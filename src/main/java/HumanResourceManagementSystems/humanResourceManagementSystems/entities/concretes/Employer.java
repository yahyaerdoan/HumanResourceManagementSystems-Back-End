package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="webSiteDomainName")
	private String webSiteDomainName;
	
	@Column(name="phoneNumber")
	private String phoneNumber;

}
