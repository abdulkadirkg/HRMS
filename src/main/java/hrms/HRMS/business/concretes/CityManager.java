package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.CityService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.CityDao;
import hrms.HRMS.entites.concretes.City;
import hrms.HRMS.entites.concretes.JobAdvertisement;

@Service
public class CityManager implements CityService {
	@Autowired
	CityDao cityDao;

	@Override
	public IResult add(City city) {
		cityDao.save(city);
		return new SuccessResult("Şehir Başarıyla Eklendi");
	}

	@Override
	public IResult update(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult delete(City city) {
		cityDao.delete(city);
		return new SuccessResult("Şehir Başarıyla Silindi");
	}

	@Override
	public IDataResult<City> get(int Id) {
		return new SuccessDataResult<City>(cityDao.getById(Id));
	}

	@Override
	public IDataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public IDataResult<City> getByCityName(String cityName) {
		return new SuccessDataResult<City>(cityDao.getByCityName(cityName));
	}

	@Override
	public IDataResult<City> getByPlateNumber(int plateNumber) {
		return new SuccessDataResult<City>(cityDao.getByPlateNumber(plateNumber));
	}

	@Override
	public IDataResult<List<City>> getByCityNameContains(String cityName) {
		return new SuccessDataResult<List<City>>(cityDao.getByCityNameContains(cityName));
	}

	@Override
	public IDataResult<List<City>> getByCityNameStartsWith(String cityName) {
		return new SuccessDataResult<List<City>>(cityDao.getByCityNameStartsWith(cityName));
	}

	@Override
	public IDataResult<List<City>> getByCityNameEndsWith(String cityName) {
		return new SuccessDataResult<List<City>>(cityDao.getByCityNameEndsWith(cityName));

	}

	@Override
	public IDataResult<List<City>> getAllByPage(int pageNumber, int pageSize) {
		pageNumber = (pageNumber > 0) ? pageNumber : 1;
		pageSize = (pageSize > 0) ? pageSize : 1;
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(pageable).getContent());
	}
}
