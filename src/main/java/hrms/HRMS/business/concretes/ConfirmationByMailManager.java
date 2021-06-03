package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.ConfirmationByMailService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.ConfirmationByMailDao;
import hrms.HRMS.entites.concretes.ConfirmationByMail;

@Service
public class ConfirmationByMailManager implements ConfirmationByMailService {
	@Autowired
	ConfirmationByMailDao confirmationByMailDao;

	@Override
	public IResult add(ConfirmationByMail confirmationByMail) {
		confirmationByMailDao.save(confirmationByMail);
		return new SuccessResult("Doğrulama Kodu Oluşturuldu.");
	}

	@Override
	public IResult update(ConfirmationByMail confirmationByMail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult delete(ConfirmationByMail confirmationByMail) {
		this.confirmationByMailDao.delete(confirmationByMail);
		return new SuccessResult("Doğrulama Silindi.");
	}

	@Override
	public IDataResult<ConfirmationByMail> get(int Id) {
		return new SuccessDataResult<ConfirmationByMail>(this.confirmationByMailDao.getById(Id));
	}

	@Override
	public IDataResult<List<ConfirmationByMail>> getAll() {
		return new SuccessDataResult<List<ConfirmationByMail>>(this.confirmationByMailDao.findAll());
	}

}
