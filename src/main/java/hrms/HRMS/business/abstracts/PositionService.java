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
	
	IDataResult<List<Position>> getAll(int pageNumber, int pageSize);
	
	IDataResult<List<Position>> getAllSorted();

	IDataResult<Position> getByJobName(String jobName);

	IDataResult<List<Position>> getByJobNameContains(String jobName);

	IDataResult<List<Position>> getByJobNameStartsWith(String jobName);

	IDataResult<List<Position>> getByName(String jobName);
}
