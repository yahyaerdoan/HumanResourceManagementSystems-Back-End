package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;	
	
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Column(name="password")
	private String password;
	
	@Column(name="verifyCode")
	private String verifyCode;
	
	@Column(name="verified")
	private boolean verified;

}
