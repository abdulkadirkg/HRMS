package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.PositionService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.entites.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
	private PositionService positionService;

	@Autowired
	public PositionController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}

	@PostMapping("/add")
	public IResult add(@RequestBody Position position) {
		this.positionService.add(position);
		return new SuccessResult("Pozisyon Ekleme İşlemi Başarılı");
	}

	@GetMapping("/getAll")
	public IDataResult<List<Position>> getAll() {
		return this.positionService.getAll();
	}

	@GetMapping("/getAllByPage")
	public IDataResult<List<Position>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.positionService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getAllSorted")
	public IDataResult<List<Position>> getAllSorted() {
		return this.positionService.getAllSorted();
	}

	@GetMapping("/getByName")
	public IDataResult<Position> getByName(@RequestParam String jobName) {
		return this.positionService.getByJobName(jobName);
	}

	@GetMapping("/getById")
	public IDataResult<Position> getById(@RequestParam int Id) {
		return this.positionService.get(Id);
	}

	@GetMapping("/getByContains")
	public IDataResult<List<Position>> getByContains(@RequestParam String jobName) {
		return this.positionService.getByJobNameContains(jobName);
	}
}
