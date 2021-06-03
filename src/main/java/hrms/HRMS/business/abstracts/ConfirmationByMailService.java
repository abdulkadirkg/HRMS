package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.ConfirmationByMail;

public interface ConfirmationByMailService {
	IResult add(ConfirmationByMail confirmationByMail);
	IResult update(ConfirmationByMail confirmationByMail);
	IResult delete(ConfirmationByMail confirmationByMail);
	IDataResult<ConfirmationByMail> get(int Id);
	IDataResult<List<ConfirmationByMail>> getAll();
}
