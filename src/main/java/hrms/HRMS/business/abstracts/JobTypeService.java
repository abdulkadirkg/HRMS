package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.JobType;

public interface JobTypeService {
	IResult add(JobType jobType);
	IResult update(JobType jobType);
	IResult delete(JobType jobType);
	IDataResult<JobType> get(int Id);
	IDataResult<List<JobType>> getAll();
	IDataResult<JobType> getByJobTypeName(String jobType);
	IDataResult<List<JobType>> getAllByPage(int pageNumber, int pageSize);
}
