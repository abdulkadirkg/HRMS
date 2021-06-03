package hrms.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HRMS.entites.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	City getById(int Id);
	City getByPlateNumber(int plateNumber);
	City getByCityName(String cityName);
	List<City> getByCityNameStartsWith(String cityName);
	List<City> getByCityNameContains(String cityName);
	List<City> getByCityNameEndsWith(String cityName);
}
