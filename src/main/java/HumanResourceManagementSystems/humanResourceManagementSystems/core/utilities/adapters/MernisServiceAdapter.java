package HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.adapters;

import org.springframework.stereotype.Component;

import HumanResourceManagementSystems.humanResourceManagementSystems.mernisService.FakeMernisService;

@Component
public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean validateByMernis(long nationalityId, String firstName, String lastName, int dateOfBirth) {

		FakeMernisService client = new FakeMernisService();

		boolean result = true;
		try {
			result = client.ValidateByPersonalInfo(nationalityId, firstName, lastName, dateOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
