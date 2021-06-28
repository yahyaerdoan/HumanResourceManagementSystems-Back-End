package HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {

	private int cityId;
	private int employerId;
	private int typeOfWorkId;
	private int workingTimeId;
	private int typeOfWorkplaceId;	
	
	private int salaryMin;
	private int salaryMax;	
	private boolean isOpen;
	private boolean isActive;
	private int openPositionCount;	
	private String description;
	private LocalDate deadline;
	private LocalDate publishedAt;
}
