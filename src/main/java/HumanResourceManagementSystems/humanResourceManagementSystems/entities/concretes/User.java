package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Column(name="password")
	private String password;
	
	//@Column(name="verifyCode")
	//private String verifyCode;
	
	//@Column(name="verified")
	//private boolean verified;
	
	@Column(name= "createdAt", columnDefinition = "Date defult current_date")
	private LocalDate createdAt = LocalDate.now();
	
	@Column(name= "isActive", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@Column(name= "isDeleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
		
}
