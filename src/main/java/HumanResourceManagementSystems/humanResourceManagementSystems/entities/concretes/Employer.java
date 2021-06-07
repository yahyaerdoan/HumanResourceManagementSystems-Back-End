package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "userId")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts" }) // Datanın sonsuz döngü içine girip
																				// aktarılmasının önünü kesiyor ve data
																				// ne kadarsa onu aktarıyor.
public class Employer extends User {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	// @Column(name="id")
	// private int id;

	// @Column(name="userId")
	// private int userId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "webSiteDomainName")
	private String webSiteDomainName;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "isVerified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
}
