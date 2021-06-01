package HumanResourceManagementSystems.humanResourceManagementSystems.mernisService;

public class FakeMernisService {

	public boolean ValidateByPersonalInfo(long nationalId, String firstName, String lastName, int dateOfBirth)
	{
		System.out.println(firstName + " " + lastName + " isimli kişi doğrulandı." );
		return true;
	}
}
