package hrms.HRMS.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.CandidateService;
import hrms.HRMS.business.abstracts.ConfirmationByMailService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.ErrorResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.CandidateDao;
import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.concretes.ConfirmationByMail;
import hrms.HRMS.entites.dtos.CandidateRegisterDto;

@Service
public class CandidateManager implements CandidateService {
	@Autowired
	CandidateDao candidateDao;
	@Autowired
	ConfirmationByMailService confirmationByMailService;

	@Override
	public IResult add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday Başarıyla Eklendi");
	}

	@Override
	public IResult update(Candidate candidate) {
		// TODO Auto-generated method stub
		return null;
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
	public IResult register(CandidateRegisterDto candidateRegisterDto) {
		// "MERNIS" Validation
		MernisManager mernisManager = new MernisManager();
		mernisManager.checkMernis(candidateRegisterDto.getName(), candidateRegisterDto.getSurname(),
				candidateRegisterDto.getBirthDate());
		// Required All Fields
		if (candidateRegisterDto.getBirthDate() == null) {
			return new ErrorResult("Lütfen Doğum Tarihinizi Giriniz");
		}
		if (candidateRegisterDto.geteMail() == null) {
			return new ErrorResult("Lütfen E-Mail Adresinizi Giriniz");
		}
		if (candidateRegisterDto.getIdentifyNumber() == null) {
			return new ErrorResult("Lütfen TC Kimlik Numaranızı Giriniz");
		}
		if (candidateRegisterDto.getName() == null) {
			return new ErrorResult("Lütfen Adınızı Giriniz");
		}
		if (candidateRegisterDto.getSurname() == null) {
			return new ErrorResult("Lütfen Soyadınızı Giriniz");
		}
		if (candidateRegisterDto.getPassword() == null) {
			return new ErrorResult("Lütfen Şifrenizi Giriniz");
		}
		if (candidateRegisterDto.getPasswordRepeat() == null) {
			return new ErrorResult("Lütfen Şifre Tekrarınızı Giriniz");
		}

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
		confirmationByMail.setConfirmationCode(UUID.randomUUID().toString());
		confirmationByMail.setConfirmed(false);
		confirmationByMailService.add(confirmationByMail);
		Candidate registerCandidate = new Candidate();
		registerCandidate.setName(candidateRegisterDto.getName());
		registerCandidate.setSurname(candidateRegisterDto.getSurname());
		registerCandidate.setBirth(candidateRegisterDto.getBirthDate());
		registerCandidate.seteMail(candidateRegisterDto.geteMail());
		registerCandidate.setPassword(candidateRegisterDto.getPassword());
		registerCandidate.setIdentifyNumber(candidateRegisterDto.getIdentifyNumber());
		registerCandidate.setConfirmationByMail(confirmationByMail);
		this.candidateDao.save(registerCandidate);
		return new SuccessResult(
				"Kayıt Başarılı. Lütfen Kaydınızın Geçerli Olabilmesi İçin Mail Adresinize Gönderdiğimiz Doğrulama Adımlarını Tamamlayınız.");
	}

}
