package hrms.HRMS.business.concretes;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.HRMS.business.abstracts.CandidateService;
import hrms.HRMS.business.abstracts.ConfirmationByMailService;
import hrms.HRMS.business.abstracts.ConfirmationByStaffService;
import hrms.HRMS.business.abstracts.JobExperienceService;
import hrms.HRMS.business.abstracts.LanguageService;
import hrms.HRMS.business.abstracts.ProgrammingLanguageService;
import hrms.HRMS.business.abstracts.ResumeService;
import hrms.HRMS.business.abstracts.SchoolService;
import hrms.HRMS.core.helpers.ImageUploadService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.ErrorResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.CandidateDao;
import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.concretes.ConfirmationByMail;
import hrms.HRMS.entites.concretes.ConfirmationByStaff;
import hrms.HRMS.entites.dtos.CandidateRegisterDto;
import hrms.HRMS.entites.dtos.DetailedCandidateDto;

@Service
public class CandidateManager implements CandidateService {
	@Autowired
	CandidateDao candidateDao;
	@Autowired
	ConfirmationByMailService confirmationByMailService;
	@Autowired
	ConfirmationByStaffService confirmationByStaffService;
	@Autowired
	ImageUploadService imageUploadHelper;
	@Autowired
	JobExperienceService jobExperienceService;
	@Autowired
	LanguageService languageService;
	@Autowired
	ResumeService resumeService;
	@Autowired
	SchoolService schoolService;
	@Autowired
	ProgrammingLanguageService programmingLanguageService;

	@Override
	public IResult add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday Başarıyla Eklendi");
	}

	@Override
	public IResult update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult("Aday Başarıyla Silindi");
	}

	@Override
	public IDataResult<Candidate> get(int Id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(Id));
	}

	@Override
	public IDataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	@Transactional
	public IResult register(CandidateRegisterDto candidateRegisterDto) {
		// "MERNIS" Validation
		MernisManager mernisManager = new MernisManager();
		mernisManager.checkMernis(candidateRegisterDto.getName(), candidateRegisterDto.getSurname(),
				candidateRegisterDto.getBirthDate());

		// Unique E-Mail
		if (this.candidateDao.getByeMailOrIdentifyNumber(candidateRegisterDto.geteMail(),
				candidateRegisterDto.getIdentifyNumber()) != null) {
			return new ErrorResult("Bu Mail veya TC No Zaten Kayıtlı.");
		}

		// Password Repeat
//		if (candidateRegisterDto.getPassword().toString() != candidateRegisterDto.getPasswordRepeat().toString()) {
//			return new ErrorResult("Lütfen Şifre Tekrarını Doğru Giriniz.");
//		}

		// THIS BLOCK IS GONNA WRAPPED BY TRANSACTION !!! IMPORTANT !!!
		ConfirmationByMail confirmationByMail = new ConfirmationByMail();
		confirmationByMailService.add(confirmationByMail);
		ConfirmationByStaff confirmationByStaff = new ConfirmationByStaff();
		confirmationByStaffService.add(confirmationByStaff);
		Candidate registerCandidate = new Candidate();
		registerCandidate.setName(candidateRegisterDto.getName());
		registerCandidate.setSurname(candidateRegisterDto.getSurname());
		registerCandidate.setBirth(candidateRegisterDto.getBirthDate());
		registerCandidate.seteMail(candidateRegisterDto.geteMail());
		registerCandidate.setPassword(candidateRegisterDto.getPassword());
		registerCandidate.setIdentifyNumber(candidateRegisterDto.getIdentifyNumber());
		registerCandidate.setConfirmationByMail(confirmationByMail);
		registerCandidate.setConfirmationByStaff(confirmationByStaff);
		this.candidateDao.save(registerCandidate);
		return new SuccessResult(
				"Kayıt Başarılı. Lütfen Kaydınızın Geçerli Olabilmesi İçin Mail Adresinize Gönderdiğimiz Doğrulama Adımlarını Tamamlayınız.");
	}

	@Override
	public IResult uploadImage(int candidateId, MultipartFile image) {
		Map<String, String> result = imageUploadHelper.uploadImage(image).getData();
		String url = result.get("url");
		Candidate candidate = candidateDao.getById(candidateId);
		candidate.setProfilePicture(url);
		this.candidateDao.save(candidate);
		return new SuccessResult("Resim Ekleme Başarılı");
	}

	@Override
	public IDataResult<DetailedCandidateDto> getDetailedCandidate(int Id) {
		DetailedCandidateDto detailedCandidateDto = new DetailedCandidateDto();
		detailedCandidateDto.setCandidate(get(Id).getData());
		detailedCandidateDto.setJobExperiences(jobExperienceService.getByCandidate_Id(Id).getData());
		detailedCandidateDto.setLanguages(languageService.getByCandidate_Id(Id).getData());
		detailedCandidateDto.setProgrammingLanguages(programmingLanguageService.getByCandidate_Id(Id).getData());
		detailedCandidateDto.setSchools(schoolService.getByCandidate_Id(Id).getData());
		detailedCandidateDto.setResumes(resumeService.getByCandidate_Id(Id).getData());
		return new SuccessDataResult<DetailedCandidateDto>(detailedCandidateDto);
	}

}
