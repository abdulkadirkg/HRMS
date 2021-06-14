package hrms.HRMS.business.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	IResult add(JobAdvertisement jobAdvertisement);
	IResult update(JobAdvertisement jobAdvertisement);
	IResult delete(JobAdvertisement jobAdvertisement);
	IDataResult<JobAdvertisement> get(int Id);
	IDataResult<List<JobAdvertisement>> getAll();
	IDataResult<List<JobAdvertisement>> getAllByPage(int pageNumber, int pageSize);
	IDataResult<List<JobAdvertisement>> getByApplicationDeadline(Date applicationDeadline);
	IDataResult<List<JobAdvertisement>> getByIsActive(Boolean isActive);
	IDataResult<List<JobAdvertisement>> getByCityPlateNumber(int plateNumber);
	IDataResult<List<JobAdvertisement>> getAllSorted(Sort sort);
	IDataResult<List<JobAdvertisement>> getAllByConfirmedByStaff();
}
