package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.JobExperience;
import hrms.HRMS.entites.concretes.Language;
import hrms.HRMS.entites.concretes.ProgrammingLanguage;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	List<Language> getByLanguageName(String languageName);

	List<Language> getByLanguageNameContains(String languageName);

	List<Language> getByLanguageNameStartsWith(String languageName);

	List<Language> getByLanguageNameEndsWith(String languageName);

	List<Language> getByCandidate_Id(int candidateId);
	
	List<Language> findAll();

	Language getById(int id);
}
