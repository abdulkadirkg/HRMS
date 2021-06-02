package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.EmployerService;
import hrms.HRMS.entites.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	EmployerService employerService;
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public List<Employer> getAll() {
		return this.employerService.GetAllList();
	}
}
