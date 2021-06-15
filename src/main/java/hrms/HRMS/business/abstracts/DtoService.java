package hrms.HRMS.business.abstracts;

import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.dtos.JobAdvertisementPostDto;

public interface DtoService {
	IResult saveJobAdvertisement(JobAdvertisementPostDto jobAdvertisementPostDto);
}
