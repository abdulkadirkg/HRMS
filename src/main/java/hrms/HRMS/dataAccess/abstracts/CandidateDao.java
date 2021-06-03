package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.concretes.Employer;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	Candidate getById(int Id);
	Candidate getByeMail(String eMail);
	Candidate getByeMailOrIdentifyNumber(String eMail, String identifyNumber);
}
