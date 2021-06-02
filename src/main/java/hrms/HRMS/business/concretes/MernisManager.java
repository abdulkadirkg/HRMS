package hrms.HRMS.business.concretes;

import java.util.Date;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;

public class MernisManager {
	IDataResult<Boolean> checkMernis(String name, String surname, Date birthDate){
		
		return new SuccessDataResult<Boolean>(true,"Doğrulama Başarılı");
	}
}
