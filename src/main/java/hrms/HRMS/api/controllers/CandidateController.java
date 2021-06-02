package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.CandidateService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.dtos.CandidateRegisterDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	@Autowired
	CandidateService candidateService;
	
	@PostMapping("/register")
	public IResult register(@RequestBody CandidateRegisterDto candidateRegisterDto) {
		return this.candidateService.register(candidateRegisterDto);
	}
	
	@PostMapping("/add")
	public IResult add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@PostMapping("/update")
	public IResult update(@RequestBody Candidate candidate) {
		return this.candidateService.update(candidate);
	}
	
	@PostMapping("/delete")
	public IResult delete(@RequestBody Candidate candidate) {
		return this.candidateService.delete(candidate);
	}
	
	@GetMapping("/get")
	public IDataResult<Candidate> get(@RequestParam int Id){
		return this.candidateService.get(Id);
	}
	@GetMapping("/getAll")
	public IDataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
}
