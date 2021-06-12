package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.ConfirmationByStaff;

public interface ConfirmationByStaffService {
	IResult add(ConfirmationByStaff confirmationByStaff);
	IResult update(ConfirmationByStaff confirmationByStaff);
	IResult delete(ConfirmationByStaff confirmationByStaff);
	IDataResult<List<ConfirmationByStaff>> getAll();
	IDataResult<ConfirmationByStaff> get(final int id);
	IResult confirm(ConfirmationByStaff confirmationByStaff);
}
