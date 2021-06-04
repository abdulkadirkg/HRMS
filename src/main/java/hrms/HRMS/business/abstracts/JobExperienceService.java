package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.JobExperience;

public interface JobExperienceService {
	IResult add(JobExperience jobExperience);

	IResult update(JobExperience jobExperience);

	IResult delete(JobExperience jobExperience);

	IDataResult<List<JobExperience>> getByWorkplace(String workplaceName);

	IDataResult<List<JobExperience>> getByWorkplaceContains(String workplaceName);

	IDataResult<List<JobExperience>> getByWorkplaceStartsWith(String workplaceName);

	IDataResult<List<JobExperience>> getByWorkplaceEndsWith(String workplaceName);

	IDataResult<List<JobExperience>> getByJobPosition(String jobPositionName);

	IDataResult<List<JobExperience>> getByJobPositionContains(String jobPositionName);

	IDataResult<List<JobExperience>> getByJobPositionStartsWith(String jobPositionName);

	IDataResult<List<JobExperience>> getByJobPositionEndsWith(String jobPositionName);

	IDataResult<List<JobExperience>> getByCandidate_Id(int candidateId);

	IDataResult<List<JobExperience>> getAll();

	IDataResult<JobExperience> getById(int id);
}
