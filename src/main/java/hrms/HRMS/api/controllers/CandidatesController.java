package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.HRMS.business.abstracts.CandidateService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.dtos.CandidateRegisterDto;
import hrms.HRMS.entites.dtos.DetailedCandidateDto;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
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
	public IDataResult<Candidate> get(@RequestParam int Id) {
		return this.candidateService.get(Id);
	}

	@GetMapping("/getAll")
	public IDataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getDetailedCandidate")
	public IDataResult<DetailedCandidateDto> getDetailedCandidate(@RequestParam int id) {
		return this.candidateService.getDetailedCandidate(id);
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@ResponseBody 
	public IResult uploadImage(@RequestParam int candidateId, @RequestPart("file") MultipartFile image) {
		return this.candidateService.uploadImage(candidateId, image);
	}
}
