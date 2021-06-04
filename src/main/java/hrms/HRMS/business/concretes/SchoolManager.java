package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.SchoolService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.SchoolDao;
import hrms.HRMS.entites.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	@Autowired
	SchoolDao schoolDao;
	@Override
	public IResult add(School school) {
		schoolDao.save(school);
		return new SuccessResult("Okul Başarıyla Eklendi");
	}

	@Override
	public IResult update(School school) {
		School schoolToUpdate = schoolDao.getById(school.getId());
		schoolToUpdate = school;
		schoolDao.save(schoolToUpdate);
		return new SuccessResult("Okul Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(School school) {
		schoolDao.delete(school);
		return new SuccessResult("Okul Başarıyla Silindi");
	}

	@Override
	public IDataResult<List<School>> getBySchoolName(String school) {
		return new SuccessDataResult<List<School>>(schoolDao.getBySchoolName(school));
	}

	@Override
	public IDataResult<List<School>> getBySchoolNameContains(String school) {
		return new SuccessDataResult<List<School>>(schoolDao.getBySchoolNameContains(school));

	}

	@Override
	public IDataResult<List<School>> getBySchoolNameStartsWith(String school) {
		return new SuccessDataResult<List<School>>(schoolDao.getBySchoolNameStartsWith(school));

	}

	@Override
	public IDataResult<List<School>> getBySchoolNameEndsWith(String school) {
		return new SuccessDataResult<List<School>>(schoolDao.getBySchoolNameEndsWith(school));

	}

	@Override
	public IDataResult<List<School>> getByDepartmentNameContains(String department) {
		return new SuccessDataResult<List<School>>(schoolDao.getByDepartmentNameContains(department));

	}

	@Override
	public IDataResult<List<School>> getByDepartmentNameStartsWith(String department) {
		return new SuccessDataResult<List<School>>(schoolDao.getByDepartmentNameStartsWith(department));

	}

	@Override
	public IDataResult<List<School>> getByDepartmentNameEndsWith(String department) {
		return new SuccessDataResult<List<School>>(schoolDao.getByDepartmentNameEndsWith(department));

	}

	@Override
	public IDataResult<List<School>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<School>>(schoolDao.getByCandidate_Id(candidateId));

	}

	@Override
	public IDataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(schoolDao.findAll());

	}

	@Override
	public IDataResult<School> getById(int id) {
		return new SuccessDataResult<School>(schoolDao.getById(id));

	}

}
