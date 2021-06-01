package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.AuthService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.EmployerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobseekerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.UserService;
import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.VerificationCodeService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.adapters.ValidationService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.ErrorResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.verification.VerificationService;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Employer;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Jobseeker;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private JobseekerService jobseekerService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobseekerService jobseekerService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobseekerService = jobseekerService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("Eksik bilgi girdiniz. lütfen bütün alanları doldurun.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmailAddress(), employer.getWebSiteDomainName())) {

			return new ErrorResult("Geçersiz e-posta adresi.");
		}

		if (!checkIfEmailExists(employer.getEmailAddress())) {

			return new ErrorResult(employer.getEmailAddress() + " Geçerli e-posta adresi var.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Parolalar uyuşmuyor.");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmailAddress());
		return new SuccessResult("Kayıt başarıyla tamamlandı.");

	}

	@Override
	public Result registerJobseeker(Jobseeker jobseeker, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(jobseeker.getNationalityId()), jobseeker.getFirstName(),
				jobseeker.getLastName(), jobseeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN doğrulanamadı.");
		}

		if (!checkIfNullInfoForJobseeker(jobseeker, confirmPassword)) {

			return new ErrorResult("Eksik bilgi girdiniz. lütfen bütün alanları doldurun.");
		}

		if (!checkIfExistsTcNo(jobseeker.getNationalityId())) {

			return new ErrorResult(jobseeker.getNationalityId() + " zaten var.");
		}

		if (!checkIfEmailExists(jobseeker.getEmailAddress())) {

			return new ErrorResult(jobseeker.getEmailAddress() + " zaten var.");
		}

		jobseekerService.add(jobseeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobseeker.getId(), jobseeker.getEmailAddress());
		return new SuccessResult("Kayıt başarıyla tamamlandı.");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebSiteDomainName() != null
				&& employer.getEmailAddress() != null && employer.getPhoneNumber() != null
				&& employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String emailAddress, String webSiteDomainName) {
		String[] emailArr = emailAddress.split("@", 2);
		String domain = webSiteDomainName.substring(4, webSiteDomainName.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	// Validation for employer register ---END---

	// Validation for jobseeker register ---START---

	private boolean checkIfNullInfoForJobseeker(Jobseeker jobseeker, String confirmPassword) {

		if (jobseeker.getFirstName() != null && jobseeker.getLastName() != null && jobseeker.getNationalityId() != null
				&& jobseeker.getDateOfBirth() != null && jobseeker.getPassword() != null
				&& jobseeker.getEmailAddress() != null && confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalityId) {

		if (this.jobseekerService.getJobseekerByNationalId(nationalityId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, int dateOfBirth) {

		if (validationService.validateByMernis(nationalityId, firstName, lastName, dateOfBirth)) {
			return true;
		}
		return false;
	}

	// Validation for jobseeker register ---END---

	// Common Validation

	private boolean checkIfEmailExists(String emailAddress) {

		if (this.userService.getUserByEmailAddress(emailAddress).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	private void verificationCodeRecord(String code, int id, String emailAddress) {

		VerificationCode verificationCode = new VerificationCode(id, code, false, LocalDate.now());
		this.verificationCodeService.add(verificationCode);
		System.out.println("Doğrulama kodu gönderildi. " + emailAddress);

	}

}
