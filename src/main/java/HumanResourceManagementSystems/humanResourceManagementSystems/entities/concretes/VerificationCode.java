package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verificationcodes")
public class VerificationCode {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="code")
	private String code;
	
	@Column(name="isConfirmed")
	private boolean isConfirmed;
	
	@Column(name="createdAt", columnDefinition = "Date default current_date")
	private LocalDate createAt = LocalDate.now();
	
	@Column(name= "isActive", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@Column(name= "isDeleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	public VerificationCode(int userId, String code, boolean isConfirmed, LocalDate createAt) {
		super();
		this.userId = userId;
		this.code = code;
		this.isConfirmed = isConfirmed;
		this.createAt = createAt;
	}
	
}
