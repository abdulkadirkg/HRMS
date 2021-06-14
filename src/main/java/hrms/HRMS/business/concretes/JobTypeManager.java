package hrms.HRMS.business.concretes;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.JobTypeService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.JobTypeDao;
import hrms.HRMS.entites.concretes.JobAdvertisement;
import hrms.HRMS.entites.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService {
	@Autowired
	JobTypeDao jobTypeDao;

	@Override
	public IResult add(final JobType jobType) {
		jobTypeDao.save(jobType);
		return new SuccessResult("İş Tipi Ekleme Başarılı");
	}

	@Override
	public IResult update(final JobType jobType) {
		jobTypeDao.save(jobType);
		return new SuccessResult("İş Tipi Güncellendi");
	}

	@Override
	public IResult delete(JobType jobType) {
		jobTypeDao.delete(jobType);
		return new SuccessResult("İş Tipi Başarıyla Silindi");
	}

	@Override
	public IDataResult<JobType> get(final int Id) {
		return new SuccessDataResult<JobType>(jobTypeDao.getById(Id));
	}

	@Override
	public IDataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(jobTypeDao.findAll());
	}

	@Override
	public IDataResult<JobType> getByJobTypeName(String jobType) {
		return new SuccessDataResult<JobType>(jobTypeDao.getByJobType(jobType));
	}

	@Override
	public IDataResult<List<JobType>> getAllByPage(int pageNumber, int pageSize) {
		pageNumber = (pageNumber > 0) ? pageNumber : 1;
		pageSize = (pageSize > 0) ? pageSize : 1;
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(pageable).getContent());
	}

}
