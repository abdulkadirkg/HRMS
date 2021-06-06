package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.CityService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
	@Autowired
	CityService cityService;

	@GetMapping("/get")
	public IDataResult<City> get(@RequestParam int Id) {
		return cityService.get(Id);
	}

	@GetMapping("/getAll")
	public IDataResult<List<City>> getAll() {
		return cityService.getAll();
	}

	@GetMapping("/getByPlateNumber")
	public IDataResult<City> getByPlateNumber(@RequestParam int plateNumber) {
		return cityService.getByPlateNumber(plateNumber);
	}

	@PostMapping("/add")
	public IResult add(@RequestBody City city) {
		return cityService.add(city);
	}

	@PostMapping("/delete")
	public IResult delete(@RequestBody City city) {
		return cityService.delete(city);
	}
}
