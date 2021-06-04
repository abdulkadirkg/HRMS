package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Language;
import hrms.HRMS.entites.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	IResult add(ProgrammingLanguage language);

	IResult update(ProgrammingLanguage language);

	IResult delete(ProgrammingLanguage language);

	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageName(String programmingLanguageName);

	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameContains(String programmingLanguageName);

	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameStartsWith(String programmingLanguageName);

	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameEndsWith(String programmingLanguageName);

	IDataResult<List<ProgrammingLanguage>> getByCandidate_Id(int candidateId);

	IDataResult<List<ProgrammingLanguage>> getAll();

	IDataResult<ProgrammingLanguage> getById(int id);
}
