package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.City;
import hrms.HRMS.entites.concretes.JobAdvertisement;

public interface CityService {
	IResult add(City city);
	IResult update(City city);
	IResult delete(City city);
	IDataResult<City> get(int Id);
	IDataResult<City> getByCityName(String cityName);
	IDataResult<City> getByPlateNumber(int plateNumber);
	IDataResult<List<City>> getByCityNameContains(String cityName);
	IDataResult<List<City>> getByCityNameStartsWith(String cityName);
	IDataResult<List<City>> getByCityNameEndsWith(String cityName);
	IDataResult<List<City>> getAll();
	IDataResult<List<City>> getAllByPage(int pageNumber, int pageSize);
}
