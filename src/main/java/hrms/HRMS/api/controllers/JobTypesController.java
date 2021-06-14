package hrms.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.concretes.JobTypeManager;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.JobType;

@RestController
@RequestMapping("/api/job-types")
@CrossOrigin
public class JobTypesController {
	@Autowired
	JobTypeManager jobTypeManager;

	@PostMapping("/add")
	public IResult add(@RequestBody final JobType jobType) {
		return jobTypeManager.add(jobType);
	}

	@PostMapping("/update")
	public IResult update(@RequestBody final JobType jobType) {
		return jobTypeManager.update(jobType);
	}

	@PostMapping("/delete")
	public IResult delete(@RequestBody final JobType jobType) {
		return jobTypeManager.delete(jobType);
	}

	@GetMapping("/get")
	public IDataResult<JobType> get(@RequestParam final int Id) {
		return jobTypeManager.get(Id);
	}
	@GetMapping("/getAll")
	public IDataResult<List<JobType>> getAll() {
		return jobTypeManager.getAll();
	}
	@GetMapping("/getAllByPage")
	public IDataResult<List<JobType>> getAllByPage(@Valid @RequestParam int pageNo, @RequestParam int pageSize) {
		return jobTypeManager.getAllByPage(pageNo,pageSize);
	}
	@GetMapping("/getByJobTypeName")
	public IDataResult<JobType> getByJobTypeName(@RequestParam String jobType) {
		return jobTypeManager.getByJobTypeName(jobType);
	}
}
