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

import hrms.HRMS.business.abstracts.ConfirmationByStaffService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.ConfirmationByStaff;

@RestController
@CrossOrigin
@RequestMapping("/api/confirmation")
public class ConfirmationByStaffController {
	@Autowired ConfirmationByStaffService confirmationByStaffService;
	@PostMapping("/add")
	public IResult add(@RequestBody ConfirmationByStaff confirmationByStaff){
		return confirmationByStaffService.add(confirmationByStaff);
	}
	@PostMapping("/update")
	public IResult update(@RequestBody ConfirmationByStaff confirmationByStaff){
		return confirmationByStaffService.update(confirmationByStaff);
	}
	@PostMapping("/delete")
	public IResult delete(@RequestBody ConfirmationByStaff confirmationByStaff){
		return confirmationByStaffService.delete(confirmationByStaff);
	}
	@PostMapping("/confirm")
	public IResult confirm(@RequestBody ConfirmationByStaff confirmationByStaff){
		return confirmationByStaffService.confirm(confirmationByStaff);
	}
	
	@GetMapping("/get")
	public IDataResult<ConfirmationByStaff> get(@RequestParam int  id){
		return confirmationByStaffService.get(id);
	}
	
	@GetMapping("/getAll")
	public IDataResult<List<ConfirmationByStaff>> getAll(){
		return confirmationByStaffService.getAll();
	}
}
