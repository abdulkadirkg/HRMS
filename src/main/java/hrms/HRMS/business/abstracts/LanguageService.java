package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Language;

public interface LanguageService {
	
	IResult add(Language language);

	IResult update(Language language);

	IResult delete(Language language);

	IDataResult<List<Language>> getByLanguageName(String languageName);

	IDataResult<List<Language>> getByLanguageNameContains(String languageName);

	IDataResult<List<Language>> getByLanguageNameStartsWith(String languageName);

	IDataResult<List<Language>> getByLanguageNameEndsWith(String languageName);

	IDataResult<List<Language>> getByCandidate_Id(int candidateId);

	IDataResult<List<Language>> getAll();

	IDataResult<Language> getById(int id);
}
