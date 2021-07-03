package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@JsonIgnore
	@Column(name = "createdAt", columnDefinition = "Date default current_date")
	private LocalDate createAt = LocalDate.now();

	@JsonIgnore
	@Column(name = "isActive", columnDefinition = "boolean default false")
	private boolean isActive = false;

	@JsonIgnore
	@Column(name = "isDeleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

}
