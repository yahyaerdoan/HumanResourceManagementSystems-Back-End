package HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.adapters;

public interface ValidationService {

	boolean validateByMernis(long nationalId, String firstName, String lastName, int dateOfBirth);
}
