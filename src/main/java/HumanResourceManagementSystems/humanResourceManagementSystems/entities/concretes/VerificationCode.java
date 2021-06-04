package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verificationcodes")
@EqualsAndHashCode(callSuper = true)
public class VerificationCode extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "userId")
	private int userId;

	@Column(name = "code")
	private String code;

	@Column(name = "isConfirmed")
	private boolean isConfirmed;
	
}
