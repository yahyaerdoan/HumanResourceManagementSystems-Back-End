package HumanResourceManagementSystems.humanResourceManagementSystems.core.verification;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class VerificationManager implements VerificationService {

	@Override
	public void sendLink(String emailAddress) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmailaddress/" + uuid.toString();
		System.out.println("Doğrulama bağlantısı şu adrese gönderildi: " + emailAddress);
		System.out.println("Hesabınızı doğrulamak için lütfen bağlantıya tıklayın:  " + verificationLink);
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Aktivasyon kodunuz:  " + verificationCode);
		return verificationCode;
	}
}
