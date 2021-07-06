package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;

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
@TypeDef(name = "json", typeClass = JsonType.class)
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
	@JsonIgnore
	private boolean isVerified = false;

	@Column(name = "employerUpdate", columnDefinition = "jsonb")
	@Type(type = "json")
	@JsonIgnore
	private Map<String, Object> employerUpdate;

	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
}
