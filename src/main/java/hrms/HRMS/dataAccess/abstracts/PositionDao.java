package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.HRMS.entites.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {
	Position getById(int Id);
	
	Position getByJobName(String jobName);

	List<Position> getByJobNameContains(String jobName);

	List<Position> getByJobNameStartsWith(String jobName);

	@Query("FROM Position WHERE job_name=:jobName")
	List<Position> getByName(String jobName);
}
