package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.Language;
import hrms.HRMS.entites.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer> {
	List<ProgrammingLanguage> getByProgrammingLanguageName(String programmingLanguageName);

	List<ProgrammingLanguage> getByProgrammingLanguageNameContains(String programmingLanguageName);

	List<ProgrammingLanguage> getByProgrammingLanguageNameStartsWith(String programmingLanguageName);

	List<ProgrammingLanguage> getByProgrammingLanguageNameEndsWith(String programmingLanguageName);

	List<ProgrammingLanguage> getByCandidate_Id(int candidateId);
	
	List<ProgrammingLanguage> findAll();

	ProgrammingLanguage getById(int id);
}
