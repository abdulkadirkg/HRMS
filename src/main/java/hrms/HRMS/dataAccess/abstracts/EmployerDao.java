package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getByCompanyName(String companyName);

	Employer getByWebSite(String webSite);

	Employer getByConfirmationByMail(int Id);

	Employer getByConfirmationByStaff(int Id);
	
	Employer getById(int Id);
	
	Employer getByeMail(String eMail);
}
