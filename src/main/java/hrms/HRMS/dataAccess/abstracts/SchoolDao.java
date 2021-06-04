package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
	List<School> getBySchoolName(String schoolName);

	List<School> getByDepartmentName(String departmentName);

	List<School> getBySchoolNameContains(String schoolName);

	List<School> getBySchoolNameStartsWith(String schoolName);

	List<School> getBySchoolNameEndsWith(String schoolName);

	List<School> getByDepartmentNameContains(String departmentName);

	List<School> getByDepartmentNameStartsWith(String departmentName);

	List<School> getByDepartmentNameEndsWith(String departmentName);

	List<School> getByCandidate_Id(int candidateId);

	List<School> findAll();

	School getById(int id);
}
