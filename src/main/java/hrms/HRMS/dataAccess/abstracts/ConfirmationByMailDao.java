package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.ConfirmationByMail;

public interface ConfirmationByMailDao extends JpaRepository<ConfirmationByMail, Integer>{
	ConfirmationByMail getById(int Id);
	ConfirmationByMail getByConfirmationCode(String eMail);
	List<ConfirmationByMail> getByIsConfirmed(Boolean isConfirmed); 
}
