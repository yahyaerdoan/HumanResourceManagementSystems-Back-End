package HumanResourceManagementSystems.humanResourceManagementSystems.core.verification;

public interface VerificationService {

	void sendLink(String emailAddress);

	String sendCode();
}
