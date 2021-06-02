package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Employer;

public interface EmployerService {
	IResult add(Employer employer);
	IResult update(Employer employer);
	IResult delete(Employer employer);
	IDataResult<Employer> get(int Id);
	IDataResult<List<Employer>> getAll();
	List<Employer> GetAllList();
}
