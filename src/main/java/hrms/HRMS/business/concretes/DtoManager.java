package hrms.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.DtoService;
import hrms.HRMS.business.abstracts.EmployerService;
import hrms.HRMS.business.abstracts.JobAdvertisementService;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Employer;
import hrms.HRMS.entites.concretes.JobAdvertisement;
import hrms.HRMS.entites.dtos.JobAdvertisementPostDto;

@Service
public class DtoManager implements DtoService {
	@Autowired JobAdvertisementService jobAdvertisementService;
	@Autowired EmployerService employerService; // SİLİNECEK. GEÇİCİ OLARAK EMPLOYER[0] OLARAK AYARLANDI
	@Override
	public IResult saveJobAdvertisement(JobAdvertisementPostDto jobAdvertisementPostDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setCity(jobAdvertisementPostDto.getCity());
		jobAdvertisement.setJobDescription(jobAdvertisementPostDto.getJobDescription());
		jobAdvertisement.setPosition(jobAdvertisementPostDto.getPosition());
		jobAdvertisement.setJobType(jobAdvertisementPostDto.getJobType());
		jobAdvertisement.setSalaryMax(jobAdvertisementPostDto.getSalaryMax());
		jobAdvertisement.setSalaryMin(jobAdvertisementPostDto.getSalaryMin());
		jobAdvertisement.setPositionCount(jobAdvertisementPostDto.getPositionCount());
		jobAdvertisement.setIsActive(jobAdvertisementPostDto.getIsActive());
		jobAdvertisement.setApplicationDeadline(jobAdvertisementPostDto.getApplicationDeadline());
		jobAdvertisement.setEmployer(employerService.getAll().getData().get(0));
		return jobAdvertisementService.add(jobAdvertisement);
	}

}
