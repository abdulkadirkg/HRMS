package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Position;

public interface PositionService {
	IResult add(Position position);
	IResult update(Position position);
	IResult delete(Position position);
	IDataResult<Position> get(int Id);
	IDataResult<List<Position>> getAll();
	List<Position> GetAllList();
}
