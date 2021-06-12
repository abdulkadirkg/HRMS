package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer> {
	JobType getById(int Id);

	JobType getByJobType(String jobType);

}
