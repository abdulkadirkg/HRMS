package hrms.HRMS.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.ConfirmationByStaffService;
import hrms.HRMS.business.abstracts.JobAdvertisementService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import hrms.HRMS.entites.concretes.ConfirmationByStaff;
import hrms.HRMS.entites.concretes.JobAdvertisement;
import hrms.HRMS.entites.concretes.Position;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	@Autowired JobAdvertisementDao jobAdvertisementDao;
	@Autowired ConfirmationByStaffService confirmationByStaffService;
	
	@Override
	public IResult add(JobAdvertisement jobAdvertisement) {
		// THIS BLOCK GONNA BE WRAPPED BY TRANSACTION !!! IMPORTANT 
		ConfirmationByStaff confirmationByStaff = new ConfirmationByStaff();
		confirmationByStaffService.add(confirmationByStaff);
		jobAdvertisement.setConfirmationByStaff(confirmationByStaff);
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan Başarıyla Eklendi");
	}

	@Override
	public IResult update(JobAdvertisement jobAdvertisement) {
		JobAdvertisement jobAdvertisementToUpdate = jobAdvertisementDao.getById(jobAdvertisement.getId());
		jobAdvertisementToUpdate = jobAdvertisement;
		jobAdvertisementDao.save(jobAdvertisementToUpdate);
		return new SuccessResult("İlan Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İlan Başarıyla Silindi");
	}

	@Override
	public IDataResult<JobAdvertisement> get(int Id) {
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.getById(Id));
	}

	@Override
	public IDataResult<List<JobAdvertisement>> getByApplicationDeadline(Date applicationDeadline) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByApplicationDeadline(applicationDeadline));
	}

	@Override
	public IDataResult<List<JobAdvertisement>> getByIsActive(Boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActive(isActive));
	}

	@Override
	public IDataResult<List<JobAdvertisement>> getByCityPlateNumber(int plateNumber) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByCityPlateNumber(plateNumber));
	}

	@Override
	public IDataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}

	@Override
	public IDataResult<List<JobAdvertisement>> getAllSorted(Sort sort) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(sort));
	}

	@Override
	public IDataResult<List<JobAdvertisement>> getAllByConfirmedByStaff() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByConfirmationByStaff_isConfirmed(true));
	}

	@Override
	public IDataResult<List<JobAdvertisement>> getAllByPage(int pageNumber, int pageSize) {
		pageNumber = (pageNumber > 0) ? pageNumber : 1;
		pageSize = (pageSize > 0) ? pageSize : 1;
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent());
	}

}
