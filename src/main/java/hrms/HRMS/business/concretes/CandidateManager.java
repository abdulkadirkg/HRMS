package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.CandidateService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.ErrorResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.CandidateDao;
import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.dtos.CandidateRegisterDto;

@Service
public class CandidateManager implements CandidateService {
	@Autowired
	CandidateDao candidateDao;

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
		// "Mernis" Validation
		MernisManager mernisManager = new MernisManager();
		mernisManager.checkMernis(candidateRegisterDto.getName(), candidateRegisterDto.getSurname(), candidateRegisterDto.getBirthDate());
		// Required All Fields
		// ------------------
		// Unique E-Mail
		Candidate candidate = this.candidateDao.getByeMail(candidateRegisterDto.geteMail());
		if (candidate != null) {
			return new ErrorResult("Bu Mail Zaten Kayıtlı.");
		}
		
		// Password Repeat
		if (candidateRegisterDto.getPassword() != candidateRegisterDto.getPasswordRepeat()) {
			return new ErrorResult("Lütfen Şifre Tekrarını Doğru Giriniz.");
		}
		
		Candidate registerCandidate = new Candidate();
		registerCandidate.setName(candidateRegisterDto.getName());
		registerCandidate.setSurname(candidateRegisterDto.getSurname());
		registerCandidate.setBirth(candidateRegisterDto.getBirthDate());
		registerCandidate.seteMail(candidateRegisterDto.geteMail());
		registerCandidate.setPassword(candidateRegisterDto.getPassword());
		registerCandidate.setIdentifyNumber(candidateRegisterDto.getIdentifyNumber());
		this.candidateDao.save(registerCandidate);
		return new SuccessResult("Aday Başarıyla Kaydedildi");
	}
	

}
