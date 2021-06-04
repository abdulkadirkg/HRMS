package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {	
	List<JobExperience> findAll();
	
	List<JobExperience> getByWorkplace(String workplaceName);

	List<JobExperience> getByWorkplaceContains(String workplaceName);

	List<JobExperience> getByWorkplaceStartsWith(String workplaceName);

	List<JobExperience> getByWorkplaceEndsWith(String workplaceName);

	List<JobExperience> getByJobPosition(String jobPositionName);

	List<JobExperience> getByJobPositionContains(String jobPositionName);

	List<JobExperience> getByJobPositionStartsWith(String jobPositionName);

	List<JobExperience> getByJobPositionEndsWith(String jobPositionName);

	List<JobExperience> getByCandidate_Id(int candidateId);

	JobExperience getById(int id);
}
