package HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="typeofworks")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Typeofwork {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	@Column(name= "createdAt", columnDefinition = "Date defult current_date")
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name= "isActive", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@Column(name= "isDeleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
	
	@OneToMany(mappedBy = "typeofwork") // jobAdverts tablosu typeofwork tablosu ile ilişkilendirilmiş durumda
	private List<JobAdvert> jobAdverts; 
	
}
