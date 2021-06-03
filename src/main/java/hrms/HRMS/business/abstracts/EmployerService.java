package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Employer;
import hrms.HRMS.entites.dtos.EmployerRegisterDto;

public interface EmployerService {
	IResult add(Employer employer);
	IResult update(Employer employer);
	IResult delete(Employer employer);
	IResult register(EmployerRegisterDto employer);
	IDataResult<Employer> get(int Id);
	IDataResult<List<Employer>> getAll();
	
}
