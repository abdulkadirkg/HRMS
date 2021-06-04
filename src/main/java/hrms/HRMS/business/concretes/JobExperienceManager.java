package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.JobExperienceService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.JobExperienceDao;
import hrms.HRMS.entites.concretes.Employer;
import hrms.HRMS.entites.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {
	@Autowired
	JobExperienceDao jobExperienceDao;

	@Override
	public IDataResult<List<JobExperience>> getByWorkplace(String workplaceName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByWorkplace(workplaceName));
	}

	@Override
	public IDataResult<List<JobExperience>> getByWorkplaceContains(String workplaceName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByWorkplaceContains(workplaceName));

	}

	@Override
	public IDataResult<List<JobExperience>> getByWorkplaceStartsWith(String workplaceName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByWorkplaceStartsWith(workplaceName));

	}

	@Override
	public IDataResult<List<JobExperience>> getByWorkplaceEndsWith(String workplaceName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByWorkplaceEndsWith(workplaceName));

	}

	@Override
	public IDataResult<List<JobExperience>> getByJobPosition(String jobPositionName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByJobPosition(jobPositionName));

	}

	@Override
	public IDataResult<List<JobExperience>> getByJobPositionContains(String jobPositionName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByJobPositionContains(jobPositionName));

	}

	@Override
	public IDataResult<List<JobExperience>> getByJobPositionStartsWith(String jobPositionName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByJobPositionStartsWith(jobPositionName));

	}

	@Override
	public IDataResult<List<JobExperience>> getByJobPositionEndsWith(String jobPositionName) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByJobPositionEndsWith(jobPositionName));

	}

	@Override
	public IDataResult<List<JobExperience>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByCandidate_Id(candidateId));

	}

	@Override
	public IDataResult<JobExperience> getById(int id) {
		return new SuccessDataResult<JobExperience>(jobExperienceDao.getById(id));

	}

	@Override
	public IDataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findAll());
	}

	@Override
	public IResult add(JobExperience jobExperience) {
		jobExperienceDao.save(jobExperience);
		return new SuccessResult("Deneyim Başarıyla Eklendi");
	}

	@Override
	public IResult update(JobExperience jobExperience) {
		JobExperience jobExperienceToUpdate = jobExperienceDao.getById(jobExperience.getId());
		jobExperienceToUpdate = jobExperience;
		jobExperienceDao.save(jobExperienceToUpdate);
		return new SuccessResult("Deneyim Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(JobExperience jobExperience) {
		jobExperienceDao.delete(jobExperience);
		return new SuccessResult("Deneyim Başarıyla Silindi");
	}

}
