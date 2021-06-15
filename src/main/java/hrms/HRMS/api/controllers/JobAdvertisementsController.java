package hrms.HRMS.api.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.DtoService;
import hrms.HRMS.business.abstracts.JobAdvertisementService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.entites.concretes.JobAdvertisement;
import hrms.HRMS.entites.dtos.JobAdvertisementPostDto;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	@Autowired JobAdvertisementService jobAdvertisementService;
	@Autowired DtoService dtoService;
	
//	@PostMapping("/add")
//	public IResult add(@RequestBody JobAdvertisement jobAdvertisement) {
//		return jobAdvertisementService.add(jobAdvertisement);
//	}
	
	@PostMapping("/add")
	public IResult add(@Valid @RequestBody JobAdvertisementPostDto jobAdvertisementPostDto) {
		return dtoService.saveJobAdvertisement(jobAdvertisementPostDto);
	}

	@PostMapping("/update")
	public IResult update(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.update(jobAdvertisement);
	}

	@PostMapping("/delete")
	public IResult delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.delete(jobAdvertisement);
	}

	@GetMapping("/get")
	public IDataResult<JobAdvertisement> get(@RequestParam int Id) {
		return jobAdvertisementService.get(Id);
	}

	@GetMapping("/getAll")
	public IDataResult<List<JobAdvertisement>> getAll() {
		return jobAdvertisementService.getAll();
	}

	@GetMapping("/getAllByPage")
	public IDataResult<List<JobAdvertisement>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize) {
		return jobAdvertisementService.getAllByPage(pageNo, pageSize);
	}

	@GetMapping("/getRecently")
	public IDataResult<List<JobAdvertisement>> getRecently(@RequestParam int count) {
		count = (count > 0) ? count : 10;
		return jobAdvertisementService.getAllByPage(1, count);
	}

	@GetMapping("/getAllByConfirmedByStaff")
	public IDataResult<List<JobAdvertisement>> getAllByConfirmedByStaff() {
		return jobAdvertisementService.getAllByConfirmedByStaff();
	}

	@GetMapping("/getAllByDateDesc")
	public IDataResult<List<JobAdvertisement>> getAllByDateDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
		return jobAdvertisementService.getAllSorted(sort);
	}

	@GetMapping("/getAllByDateAsc")
	public IDataResult<List<JobAdvertisement>> getAllByDateAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "createdAt");
		return jobAdvertisementService.getAllSorted(sort);
	}

	@GetMapping("/getByApplicationDeadline")
	public IDataResult<List<JobAdvertisement>> getByApplicationDeadline(@RequestParam Date applicationDeadline) {
		return jobAdvertisementService.getByApplicationDeadline(applicationDeadline);
	}

	@GetMapping("/getByIsActive")
	public IDataResult<List<JobAdvertisement>> getByIsActive(@RequestParam Boolean isActive) {
		return jobAdvertisementService.getByIsActive(isActive);
	}
}
