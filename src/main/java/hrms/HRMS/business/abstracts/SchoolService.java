package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.School;

public interface SchoolService {
	IResult add(School school);

	IResult update(School school);

	IResult delete(School school);

	IDataResult<List<School>> getBySchoolName(String school);

	IDataResult<List<School>> getBySchoolNameContains(String school);

	IDataResult<List<School>> getBySchoolNameStartsWith(String school);

	IDataResult<List<School>> getBySchoolNameEndsWith(String school);

	IDataResult<List<School>> getByDepartmentNameContains(String department);

	IDataResult<List<School>> getByDepartmentNameStartsWith(String department);

	IDataResult<List<School>> getByDepartmentNameEndsWith(String department);

	IDataResult<List<School>> getByCandidate_Id(int candidateId);

	IDataResult<List<School>> getAll();

	IDataResult<School> getById(int id);
}
