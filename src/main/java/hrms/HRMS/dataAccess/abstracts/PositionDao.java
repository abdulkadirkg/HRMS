package hrms.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {

}
