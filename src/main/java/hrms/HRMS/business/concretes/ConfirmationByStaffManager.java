package hrms.HRMS.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.ConfirmationByStaffService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.ConfirmationByStaffDao;
import hrms.HRMS.entites.concretes.ConfirmationByStaff;
@Service
public class ConfirmationByStaffManager implements ConfirmationByStaffService {
	@Autowired ConfirmationByStaffDao confirmationByStaffDao;
	@Override
	public IResult add(final ConfirmationByStaff confirmationByStaff) {
		confirmationByStaffDao.save(confirmationByStaff);
		return new SuccessResult("Eklendi");
	}

	@Override
	public IResult update(final ConfirmationByStaff confirmationByStaff) {
		confirmationByStaffDao.save(confirmationByStaff);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public IResult delete(final ConfirmationByStaff confirmationByStaff) {
		confirmationByStaffDao.delete(confirmationByStaff);
		return new SuccessResult("Silindi");
	}

	@Override
	public IDataResult<List<ConfirmationByStaff>> getAll() {
		return new SuccessDataResult<List<ConfirmationByStaff>>(confirmationByStaffDao.findAll());
	}

	@Override
	public IDataResult<ConfirmationByStaff> get(final int id) {
		return new SuccessDataResult<ConfirmationByStaff>(confirmationByStaffDao.getById(id));

	}

	@Override
	public IResult confirm(ConfirmationByStaff confirmationByStaff) {
		confirmationByStaff = confirmationByStaffDao.getById(confirmationByStaff.getId());
		confirmationByStaff.setConfirmed(true);
		confirmationByStaffDao.save(confirmationByStaff);
		return new SuccessResult("Onaylama Başarılı");
	}

}
