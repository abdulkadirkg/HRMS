package hrms.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.EmployerService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Employer;
import hrms.HRMS.entites.dtos.EmployerRegisterDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	EmployerService employerService;
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/get")
	public IDataResult<Employer> get(int Id){
		return this.employerService.get(Id);
	}
	
	@GetMapping("/getall")
	public IDataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
	
	@PostMapping("/delete")
	public IResult delete(@RequestBody Employer employer) {
		return this.employerService.delete(employer);
	}
	
	@PostMapping("/register")
	public IResult register(@Valid @RequestBody EmployerRegisterDto employerRegisterDto) {
		return this.employerService.register(employerRegisterDto);
	}
}
