package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;


import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Employer;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobSeeker;

public interface AuthService {

	Result registerEmployer(Employer employer, String confirmPassword);

	Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword);
}
