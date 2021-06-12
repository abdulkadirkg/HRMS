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
	public IResult add(ConfirmationByStaff confirmationByStaff) {
		confirmationByStaffDao.save(confirmationByStaff);
		return new SuccessResult("Eklendi");
	}

	@Override
	public IResult update(ConfirmationByStaff confirmationByStaff) {
		confirmationByStaffDao.save(confirmationByStaff);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public IResult delete(ConfirmationByStaff confirmationByStaff) {
		confirmationByStaffDao.delete(confirmationByStaff);
		return new SuccessResult("Silindi");
	}

	@Override
	public IDataResult<List<ConfirmationByStaff>> getAll() {
		return new SuccessDataResult<List<ConfirmationByStaff>>(confirmationByStaffDao.findAll());
	}

	@Override
	public IDataResult<ConfirmationByStaff> get(int id) {
		return new SuccessDataResult<ConfirmationByStaff>(confirmationByStaffDao.getById(id));

	}

	@Override
	public IResult confirm(ConfirmationByStaff confirmationByStaff) {
		ConfirmationByStaff confirmationByStaffUpdate = get(confirmationByStaff.getId()).getData();
		confirmationByStaffUpdate = confirmationByStaff;
		confirmationByStaffUpdate.setConfirmed(true);
		confirmationByStaffDao.save(confirmationByStaffUpdate);
		return new SuccessResult("Onaylama Başarılı");
	}

}
