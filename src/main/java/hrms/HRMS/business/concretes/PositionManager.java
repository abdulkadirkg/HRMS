package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.PositionService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.ErrorResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.PositionDao;
import hrms.HRMS.entites.concretes.Position;
import net.bytebuddy.asm.Advice.This;

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
		if (this.positionDao.getByJobName(position.getJobName()) != null) {
			return new ErrorResult("Bu Pozisyon Zaten Var");
		}
		positionDao.save(position);
		return new SuccessResult("Pozisyon Başarıyla Eklendi");
	}

	@Override
	public IResult update(Position position) {
		// positionDao.update(position);
		return new ErrorResult("Güncelleme İşlemi Henüz Geliştirilmedi");
	}

	@Override
	public IResult delete(Position position) {
		positionDao.delete(position);
		return new SuccessResult("Silme İşlemi Başarılı");

	}

	@Override
	public IDataResult<Position> get(int Id) {
		return new SuccessDataResult<Position>(positionDao.getById(Id));
	}

	@Override
	public IDataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(positionDao.findAll());
	}

	@Override
	public IDataResult<Position> getByJobName(String jobName) {
		return new SuccessDataResult<Position>(positionDao.getByJobName(jobName));
	}

	@Override
	public IDataResult<List<Position>> getByJobNameContains(String jobName) {
		return new SuccessDataResult<List<Position>>(positionDao.getByJobNameContains(jobName));
	}

	@Override
	public IDataResult<List<Position>> getByJobNameStartsWith(String jobName) {
		return new SuccessDataResult<List<Position>>(positionDao.getByJobNameStartsWith(jobName));

	}

	@Override
	public IDataResult<List<Position>> getByName(String jobName) {
		return new SuccessDataResult<List<Position>>(positionDao.getByName(jobName));
	}

	@Override
	public IDataResult<List<Position>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(pageable).getContent());
	}

	@Override
	public IDataResult<List<Position>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC,"jobName"); // parametre olarak gönderilebilir.
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(sort),"İşlem Başarılı");
	}

}
