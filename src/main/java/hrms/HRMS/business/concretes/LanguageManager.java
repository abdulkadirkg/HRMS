package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.LanguageService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.LanguageDao;
import hrms.HRMS.entites.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	@Autowired
	LanguageDao languageDao;

	@Override
	public IResult add(Language language) {
		languageDao.save(language);
		return new SuccessResult("Dil Başarıyla Eklendi");
	}

	@Override
	public IResult update(Language language) {
		Language languageToUpdate = languageDao.getById(language.getId());
		languageToUpdate = language;
		languageDao.save(languageToUpdate);
		return new SuccessResult("Dil Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(Language language) {
		languageDao.delete(language);
		return new SuccessResult("Dil Başarıyla Silindi");
	}

	@Override
	public IDataResult<List<Language>> getByLanguageName(String languageName) {
		return new SuccessDataResult<List<Language>>(languageDao.getByLanguageName(languageName));
	}

	@Override
	public IDataResult<List<Language>> getByLanguageNameContains(String languageName) {
		return new SuccessDataResult<List<Language>>(languageDao.getByLanguageNameContains(languageName));

	}

	@Override
	public IDataResult<List<Language>> getByLanguageNameStartsWith(String languageName) {
		return new SuccessDataResult<List<Language>>(languageDao.getByLanguageNameStartsWith(languageName));

	}

	@Override
	public IDataResult<List<Language>> getByLanguageNameEndsWith(String languageName) {
		return new SuccessDataResult<List<Language>>(languageDao.getByLanguageNameEndsWith(languageName));

	}

	@Override
	public IDataResult<List<Language>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<Language>>(languageDao.getByCandidate_Id(candidateId));

	}

	@Override
	public IDataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(languageDao.findAll());

	}

	@Override
	public IDataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(languageDao.getById(id));

	}

}
