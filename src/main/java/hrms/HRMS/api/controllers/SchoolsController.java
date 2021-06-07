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

import hrms.HRMS.business.abstracts.SchoolService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.School;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolsController {
	@Autowired
	SchoolService schoolService;

	@PostMapping("/add")
	IResult add(@RequestBody School school) {
		return schoolService.add(school);
	}

	@PostMapping("/update")
	IResult update(@RequestBody School school) {
		return schoolService.update(school);
	}

	@PostMapping("/delete")
	IResult delete(@RequestBody School school) {
		return schoolService.delete(school);
	}

	@GetMapping("/getBySchoolName")
	IDataResult<List<School>> getBySchoolName(@RequestParam String school) {
		return schoolService.getBySchoolName(school);
	}

	@GetMapping("/getBySchoolNameContains")
	IDataResult<List<School>> getBySchoolNameContains(@RequestParam String school) {
		return schoolService.getBySchoolNameContains(school);
	}

	@GetMapping("/getBySchoolNameStartsWith")
	IDataResult<List<School>> getBySchoolNameStartsWith(@RequestParam String school) {
		return schoolService.getBySchoolNameStartsWith(school);
	}

	@GetMapping("/getBySchoolNameEndsWith")
	IDataResult<List<School>> getBySchoolNameEndsWith(@RequestParam String school) {
		return schoolService.getBySchoolNameEndsWith(school);
	}
 
	@GetMapping("/getByDepartmentNameContains")
	IDataResult<List<School>> getByDepartmentNameContains(@RequestParam String department) {
		return schoolService.getByDepartmentNameContains(department);
	}

	@GetMapping("/getByDepartmentNameStartsWith")
	IDataResult<List<School>> getByDepartmentNameStartsWith(@RequestParam String department) {
		return schoolService.getByDepartmentNameStartsWith(department);
	}

	@GetMapping("/getByDepartmentNameEndsWith")
	IDataResult<List<School>> getByDepartmentNameEndsWith(@RequestParam String department) {
		return schoolService.getByDepartmentNameEndsWith(department);
	}

	@GetMapping("/getByCandidate_Id")
	IDataResult<List<School>> getByCandidate_Id(@RequestParam int candidateId) {
		return schoolService.getByCandidate_Id(candidateId);
	}

	@GetMapping("/getAll")
	IDataResult<List<School>> getAll() {
		return schoolService.getAll();
	}

	@GetMapping("/getById")
	IDataResult<School> getById(@RequestParam int id) {
		return schoolService.getById(id);
	}
}
