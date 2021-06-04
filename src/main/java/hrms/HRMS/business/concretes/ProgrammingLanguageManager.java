package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.ProgrammingLanguageService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.ProgrammingLanguageDao;
import hrms.HRMS.entites.concretes.ProgrammingLanguage;
@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	@Autowired
	ProgrammingLanguageDao programmingLanguageDao;

	@Override
	public IResult add(ProgrammingLanguage language) {
		programmingLanguageDao.save(language);
		return new SuccessResult("Programlama Dili Başarıyla Eklendi");
	}

	@Override
	public IResult update(ProgrammingLanguage language) {
		ProgrammingLanguage programmingLanguageToUpdate = programmingLanguageDao.getById(language.getId());
		programmingLanguageToUpdate = language;
		programmingLanguageDao.save(programmingLanguageToUpdate);
		return new SuccessResult("Programlama Dili Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(ProgrammingLanguage language) {
		programmingLanguageDao.delete(language);
		return new SuccessResult("Programlama Dili Başarıyla Eklendi");
	}

	@Override
	public IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageName(String programmingLanguageName) {
		return new SuccessDataResult<List<ProgrammingLanguage>>(
				programmingLanguageDao.getByProgrammingLanguageName(programmingLanguageName));
	}

	@Override
	public IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameContains(String programmingLanguageName) {
		return new SuccessDataResult<List<ProgrammingLanguage>>(
				programmingLanguageDao.getByProgrammingLanguageNameContains(programmingLanguageName));
	}

	@Override
	public IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameStartsWith(
			String programmingLanguageName) {
		return new SuccessDataResult<List<ProgrammingLanguage>>(
				programmingLanguageDao.getByProgrammingLanguageNameStartsWith(programmingLanguageName));
	}

	@Override
	public IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameEndsWith(String programmingLanguageName) {
		return new SuccessDataResult<List<ProgrammingLanguage>>(
				programmingLanguageDao.getByProgrammingLanguageNameEndsWith(programmingLanguageName));
	}

	@Override
	public IDataResult<List<ProgrammingLanguage>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<ProgrammingLanguage>>(
				programmingLanguageDao.getByCandidate_Id(candidateId));
	}

	@Override
	public IDataResult<List<ProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguage>>(
				programmingLanguageDao.findAll());
	}

	@Override
	public IDataResult<ProgrammingLanguage> getById(int id) {
		return new SuccessDataResult<ProgrammingLanguage>(
				programmingLanguageDao.getById(id));
	}

}
