package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.dtos.DetailedCandidateDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getById(int Id);

	Candidate getByeMail(String eMail);

	Candidate getByeMailOrIdentifyNumber(String eMail, String identifyNumber);

//	@Query("SELECT new hrms.HRMS.entites.dtos.DetailedCandidateDto "
//			+ "(candidates,schools,languages,programming_languages,cities,resumes,job_experiences) "
//			+ "FROM Candidate INNER JOIN Candidate.id c")
//	DetailedCandidateDto getDetailedCandidate(int Id);
}
