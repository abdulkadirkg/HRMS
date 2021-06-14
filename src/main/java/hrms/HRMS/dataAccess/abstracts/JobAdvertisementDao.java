package hrms.HRMS.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	JobAdvertisement getById(int id);
	List<JobAdvertisement> getByApplicationDeadline(Date applicationDeadline);
	List<JobAdvertisement> getByIsActive(Boolean isActive);
	List<JobAdvertisement> getByCityPlateNumber(int plateNumber);
	List<JobAdvertisement> getByConfirmationByStaff_isConfirmed(Boolean isConfirmed);
	//List<JobAdvertisement> getByEmployer(Employer employer);
}
