package hrms.HRMS.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.ConfirmationByMailService;
import hrms.HRMS.business.abstracts.EmployerService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.ErrorResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.EmployerDao;
import hrms.HRMS.entites.concretes.ConfirmationByMail;
import hrms.HRMS.entites.concretes.Employer;
import hrms.HRMS.entites.concretes.JobAdvertisement;
import hrms.HRMS.entites.dtos.EmployerRegisterDto;
@Service
public class EmployerManager implements EmployerService {
	@Autowired
	EmployerDao employerDao;
	@Autowired
	ConfirmationByMailService confirmationByMailService;
	@Override
	public IResult add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult("İşveren Başarıyla Eklendi");
	}

	@Override
	public IResult update(Employer employer) {
		Employer employerToUpdate = employerDao.getById(employer.getId());
		employerToUpdate = employer;
		employerDao.save(employerToUpdate);
		return new SuccessResult("İşveren Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(Employer employer) {
		employerDao.delete(employer);
		return new SuccessResult("İşveren Başarıyla Silindi");
	}

	@Override
	public IDataResult<Employer> get(int Id) {
		return new SuccessDataResult<Employer>(employerDao.getById(Id));
	}

	@Override
	public IDataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public IResult register(EmployerRegisterDto employerRegisterDto) {
		if (employerRegisterDto.getCompanyName() == null) {
			return new ErrorResult("Lütfen Şirket Adınızı Giriniz");
		}
		
		if (employerRegisterDto.getWebSite() == null) {
			return new ErrorResult("Lütfen Web Sitenizi Giriniz");
		}
		
		if (employerRegisterDto.geteMail() == null) {
			return new ErrorResult("Lütfen Mail Adresinizi Giriniz");
		}
		
		if (this.employerDao.getByeMail(employerRegisterDto.geteMail()) != null) {
			return new ErrorResult("Bu Mail Adresi Zaten Kayıtlı");
		}
		
		if (employerRegisterDto.getPhone() == null) {
			return new ErrorResult("Lütfen Telefon Numaranızı Giriniz");
		}
		
		// THIS BLOCK IS GONNA BE WRAPPED WITH TRANSACTION !!! IMPORTANT !!!
		ConfirmationByMail confirmationByMail = new ConfirmationByMail();
		confirmationByMail.setConfirmationCode(UUID.randomUUID().toString());
		confirmationByMail.setConfirmed(false);
		this.confirmationByMailService.add(confirmationByMail);
		
		Employer employer = new Employer();
		employer.setCompanyName(employerRegisterDto.getCompanyName());
		employer.seteMail(employerRegisterDto.geteMail());
		employer.setPassword(employerRegisterDto.getPassword());
		employer.setPhone(employerRegisterDto.getPhone());
		employer.setWebSite(employerRegisterDto.getWebSite());
		employer.setConfirmationByMail(confirmationByMail);
		this.employerDao.save(employer);
		return new SuccessResult("Kayıt Başarılı. Lütfen Kaydınızın Geçerli Olabilmesi İçin Mail Adresinize Gönderdiğimiz Doğrulama Adımlarını Tamamlayınız.");
	}
}
