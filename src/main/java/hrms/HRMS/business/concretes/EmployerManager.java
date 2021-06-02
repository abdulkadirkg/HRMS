package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.EmployerService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.dataAccess.abstracts.EmployerDao;
import hrms.HRMS.entites.concretes.Employer;
@Service
public class EmployerManager implements EmployerService {
	EmployerDao employerDao;
	@Autowired
	public EmployerManager(EmployerDao employerDao) 
	{
		super();
		this.employerDao = employerDao;
	}

	@Override
	public IResult add(Employer employer) {
		employerDao.save(employer);
		//return new SuccessResult("İşlem Başarılı");
		return null;
	}

	@Override
	public IResult update(Employer employer) {
		//positionDao.(position);
		return null;
	}

	@Override
	public IResult delete(Employer employer) {
		employerDao.delete(employer);
		return null;
	}

	@Override
	public IDataResult<Employer> get(int Id) {
		//return new SuccessDataResult<Position>(positionDao.findById(Id));
		return null;
	}

	@Override
	public IDataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employer> GetAllList(){
		return employerDao.findAll();
	}
}
