package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.PositionService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.dataAccess.abstracts.PositionDao;
import hrms.HRMS.entites.concretes.Position;
@Service
public class PositionManager implements PositionService {
	PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public IResult add(Position position) {
		positionDao.save(position);
		//return new SuccessResult("İşlem Başarılı");
		return null;
	}

	@Override
	public IResult update(Position position) {
		//positionDao.(position);
		return null;
	}

	@Override
	public IResult delete(Position position) {
		positionDao.delete(position);
		return null;
	}

	@Override
	public IDataResult<Position> get(int Id) {
		//return new SuccessDataResult<Position>(positionDao.findById(Id));
		return null;
	}

	@Override
	public IDataResult<List<Position>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Position> GetAllList(){
		return positionDao.findAll();
	}
	
}
