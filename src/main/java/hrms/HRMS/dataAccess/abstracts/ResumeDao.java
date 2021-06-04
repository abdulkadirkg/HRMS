package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.ProgrammingLanguage;
import hrms.HRMS.entites.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	List<Resume> getByResumeText(String resumeName);

	List<Resume> getByResumeTextContains(String resumeName);

	List<Resume> getByResumeTextStartsWith(String resumeName);

	List<Resume> getByResumeTextEndsWith(String resumeName);

	List<Resume> getByCandidate_Id(int candidateId);

	List<Resume> getByIsActive(Boolean isActive);

	List<Resume> findAll();

	Resume getById(int id);
}
