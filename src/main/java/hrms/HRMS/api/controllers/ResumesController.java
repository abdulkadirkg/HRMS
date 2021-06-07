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

import hrms.HRMS.business.abstracts.ResumeService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Resume;

@RequestMapping("/api/resumes")
@RestController
@CrossOrigin
public class ResumesController {
	@Autowired
	ResumeService resumeService;

	@PostMapping("/add")
	IResult add(@RequestBody Resume resume) {
		return resumeService.add(resume);
	}

	@PostMapping("/update")
	IResult update(@RequestBody Resume resume) {
		return resumeService.update(resume);
	}

	@PostMapping("/delete")
	IResult delete(@RequestBody Resume resume) {
		return resumeService.delete(resume);
	}

	@GetMapping("/getByResumeText")
	IDataResult<List<Resume>> getByResumeText(@RequestParam String resumeText) {
		return resumeService.getByResumeText(resumeText);
	}

	@GetMapping("/getByResumeTextContains")
	IDataResult<List<Resume>> getByResumeTextContains(@RequestParam String resumeText) {
		return resumeService.getByResumeTextContains(resumeText);
	}

	@GetMapping("/getByResumeTextStartsWith")
	IDataResult<List<Resume>> getByResumeTextStartsWith(@RequestParam String resumeText) {
		return resumeService.getByResumeTextStartsWith(resumeText);
	}

	@GetMapping("/getByResumeTextEndsWith")
	IDataResult<List<Resume>> getByResumeTextEndsWith(@RequestParam String resumeText) {
		return resumeService.getByResumeTextEndsWith(resumeText);
	}

	@GetMapping("/getByCandidate_Id")
	IDataResult<List<Resume>> getByCandidate_Id(@RequestParam int candidateId) {
		return resumeService.getByCandidate_Id(candidateId);
	}

	@GetMapping("/getAll")
	IDataResult<List<Resume>> getAll() {
		return resumeService.getAll();
	}

	@GetMapping("/getById")
	IDataResult<Resume> getById(@RequestParam int id) {
		return resumeService.getById(id);
	}
}
