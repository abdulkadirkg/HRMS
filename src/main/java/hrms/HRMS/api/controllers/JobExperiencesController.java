package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.JobExperienceService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin
public class JobExperiencesController {
	@Autowired
	JobExperienceService jobExperienceService;

	@GetMapping("/getByWorkplace")
	IDataResult<List<JobExperience>> getByWorkplace(@RequestParam String workplaceName) {
		return jobExperienceService.getByWorkplace(workplaceName);
	}

	@GetMapping("/getByWorkplaceContains")
	IDataResult<List<JobExperience>> getByWorkplaceContains(@RequestParam String workplaceName) {
		return jobExperienceService.getByWorkplaceContains(workplaceName);
	}

	@GetMapping("/getByWorkplaceStartsWith")
	IDataResult<List<JobExperience>> getByWorkplaceStartsWith(@RequestParam String workplaceName) {
		return jobExperienceService.getByWorkplaceStartsWith(workplaceName);
	}

	@GetMapping("/getByWorkplaceEndsWith")
	IDataResult<List<JobExperience>> getByWorkplaceEndsWith(@RequestParam String workplaceName) {
		return jobExperienceService.getByWorkplaceEndsWith(workplaceName);
	}

	@GetMapping("/getByJobPosition")
	IDataResult<List<JobExperience>> getByJobPosition(@RequestParam String jobPositionName) {
		return jobExperienceService.getByJobPosition(jobPositionName);
	}

	@GetMapping("/getByJobPositionContains")
	IDataResult<List<JobExperience>> getByJobPositionContains(@RequestParam String jobPositionName) {
		return jobExperienceService.getByJobPositionContains(jobPositionName);
	}

	@GetMapping("/getByJobPositionStartsWith")
	IDataResult<List<JobExperience>> getByJobPositionStartsWith(String jobPositionName) {
		return jobExperienceService.getByJobPositionStartsWith(jobPositionName);
	}

	@GetMapping("getByJobPositionEndsWith")
	IDataResult<List<JobExperience>> getByJobPositionEndsWith(@RequestParam String jobPositionName) {
		return jobExperienceService.getByJobPositionEndsWith(jobPositionName);
	}

	@GetMapping("/getByCandidate_Id")
	IDataResult<List<JobExperience>> getByCandidate_Id(@RequestParam int candidateId) {
		return jobExperienceService.getByCandidate_Id(candidateId);
	}

	@GetMapping("/getAll")
	IDataResult<List<JobExperience>> getAll() {
		return jobExperienceService.getAll();
	}

	@GetMapping("/getById")
	IDataResult<JobExperience> getById(@RequestParam int id) {
		return jobExperienceService.getById(id);
	}
	@PostMapping("/add")
	IResult add(@RequestBody JobExperience jobExperience) {
		return jobExperienceService.add(jobExperience);
	}
	@PostMapping("/update")
	IResult update(@RequestBody JobExperience jobExperience) {
		return jobExperienceService.update(jobExperience);
	}
	@PostMapping("/delete")
	IResult delete(@RequestBody JobExperience jobExperience) {
		return jobExperienceService.delete(jobExperience);
	}
}
