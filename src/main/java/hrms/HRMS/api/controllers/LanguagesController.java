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

import hrms.HRMS.business.abstracts.LanguageService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Language;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
	@Autowired
	LanguageService languageService;

	@PostMapping("/add")
	IResult add(@RequestBody Language language) {
		return languageService.add(language);
	}

	@PostMapping("/update")
	IResult update(@RequestBody Language language) {
		return languageService.update(language);
	}

	@PostMapping("/delete")
	IResult delete(@RequestBody Language language) {
		return languageService.delete(language);
	}

	@GetMapping("/getByLanguageName")
	IDataResult<List<Language>> getByLanguageName(@RequestParam String languageName) {
		return languageService.getByLanguageName(languageName);
	}

	@GetMapping("/getByLanguageNameContains")
	IDataResult<List<Language>> getByLanguageNameContains(@RequestParam String languageName) {
		return languageService.getByLanguageNameContains(languageName);
	}

	@GetMapping("/getByLanguageNameStartsWith")
	IDataResult<List<Language>> getByLanguageNameStartsWith(@RequestParam String languageName) {
		return languageService.getByLanguageNameStartsWith(languageName);
	}

	@GetMapping("/getByLanguageNameEndsWith")
	IDataResult<List<Language>> getByLanguageNameEndsWith(@RequestParam String languageName) {
		return languageService.getByLanguageNameEndsWith(languageName);
	}

	@GetMapping("/getByCandidate_Id")
	IDataResult<List<Language>> getByCandidate_Id(@RequestParam int candidateId) {
		return languageService.getByCandidate_Id(candidateId);
	}

	@GetMapping("/getAll")
	IDataResult<List<Language>> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/getById")
	IDataResult<Language> getById(@RequestParam int id) {
		return languageService.getById(id);
	}
}
