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

import hrms.HRMS.business.abstracts.ProgrammingLanguageService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
@CrossOrigin
public class ProgrammingLanguagesController {
	@Autowired
	ProgrammingLanguageService programmingLanguageService;
	@PostMapping("/add")
	IResult add(@RequestBody ProgrammingLanguage language) {
		return programmingLanguageService.add(language);
	}
	@PostMapping("/update")
	IResult update(@RequestBody ProgrammingLanguage language) {
		return programmingLanguageService.update(language);
	}
	@PostMapping("/delete")
	IResult delete(@RequestBody ProgrammingLanguage language) {
		return programmingLanguageService.delete(language);
	}
	@GetMapping("/getByProgrammingLanguageName")
	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageName(@RequestParam String programmingLanguageName) {
		return programmingLanguageService.getByProgrammingLanguageName(programmingLanguageName);
	}
	@GetMapping("/getByProgrammingLanguageNameContains")
	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameContains(@RequestParam String programmingLanguageName) {
		return programmingLanguageService.getByProgrammingLanguageNameContains(programmingLanguageName);

	}
	@GetMapping("/getByProgrammingLanguageNameStartsWith")
	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameStartsWith(@RequestParam String programmingLanguageName) {
		return programmingLanguageService.getByProgrammingLanguageNameStartsWith(programmingLanguageName);

	}
	@GetMapping("/getByProgrammingLanguageNameEndsWith")
	IDataResult<List<ProgrammingLanguage>> getByProgrammingLanguageNameEndsWith(@RequestParam String programmingLanguageName) {
		return programmingLanguageService.getByProgrammingLanguageNameEndsWith(programmingLanguageName);

	}
	@GetMapping("/getByCandidate_Id")
	IDataResult<List<ProgrammingLanguage>> getByCandidate_Id(@RequestParam int candidateId) {
		return programmingLanguageService.getByCandidate_Id(candidateId);
	}
	@GetMapping("/getAll")
	IDataResult<List<ProgrammingLanguage>> getAll() {
		return programmingLanguageService.getAll();
	}
	@GetMapping("/getById")
	IDataResult<ProgrammingLanguage> getById(@RequestParam int id) {
		return programmingLanguageService.getById(id);
	}
}
