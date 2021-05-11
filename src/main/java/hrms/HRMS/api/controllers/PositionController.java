package hrms.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HRMS.business.abstracts.PositionService;
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

	@GetMapping("/getall")
	public List<Position> getAll() {
		return this.positionService.GetAllList();
	}
}
