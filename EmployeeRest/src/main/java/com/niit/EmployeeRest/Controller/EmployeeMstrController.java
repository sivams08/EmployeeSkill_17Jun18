package com.niit.EmployeeRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.EmployeeDao.model.EmployeeMaster;
import com.niit.EmployeeDao.model.SkillSet;
import com.niit.EmployeeDao.service.EmployeeServInter;

@RestController
@RequestMapping("/employees/api")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeMstrController {

	@Autowired
	private EmployeeServInter employeeServ;
	
	
	@GetMapping
	public List<EmployeeMaster>  EmployeeList() {
		
		List<EmployeeMaster> EmpObj = employeeServ.getEmployee();
		return EmpObj;
	}
	
	@GetMapping("/skillupdate")
	public List<EmployeeMaster>  EmployeeListskillUpdate() {
		
		List<EmployeeMaster> EmpObj = employeeServ.getforskil();
		return EmpObj;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EmployeeMaster>  DeleteEmployee(@PathVariable("id") String emp_id) {

			int id = Integer.parseInt(emp_id);
			boolean status = employeeServ.deleteServe(id);
			return new ResponseEntity<EmployeeMaster>(HttpStatus.OK);
			
		
	}
	@GetMapping("/show/{id}")
	public ResponseEntity<EmployeeMaster> getCustomer(@PathVariable("id") String emp_id) {
		
		int id = Integer.parseInt(emp_id);
		EmployeeMaster empObj = employeeServ.showEmployeeData(id);		
		if (empObj == null) {
			return new ResponseEntity<EmployeeMaster>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<EmployeeMaster>(empObj, HttpStatus.OK);
	}
	
	@GetMapping("/getSkill/{id}")
	public List<SkillSet> getSkill(@PathVariable("id") String skill) {
		
//		int id = Integer.parseInt(skill_id);
		List<SkillSet> skillObj = employeeServ.getSkills(skill);	

		return skillObj;
	}
	
	@PostMapping("/add{id}")
	public ResponseEntity<String> AddEmployee(@RequestBody EmployeeMaster empObj) {
		
		//EmployeeMaster empObj = employeeServ.showEmployeeData(id);		
		if (empObj != null) {
			employeeServ.addServe(empObj);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
	}
	
	@PostMapping("/addskill{id}")
	public ResponseEntity<String> AddSkill(@RequestBody SkillSet skillObj) {
		
		//EmployeeMaster empObj = employeeServ.showEmployeeData(id);		
		if (skillObj != null) {
			employeeServ.addSkillService(skillObj);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("/update{id}")
	public ResponseEntity<String> UpdateEmployee(@RequestBody EmployeeMaster empObj) {
				
		if (empObj != null) {
			employeeServ.updateEmployee(empObj);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
	}
	
}
