package HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilterDto {
	
	private List<Integer> cityId;
	private List<Integer> typeOfWorkId;
	private List<Integer> typeOfWorkplaceId;
	private List<Integer> workingTimeId;
}
