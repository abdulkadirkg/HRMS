package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.ConfirmationByStaff;

public interface ConfirmationByStaffDao extends JpaRepository<ConfirmationByStaff, Integer> {
	ConfirmationByStaff getById(int id);
}
