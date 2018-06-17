package com.niit.EmployeeDao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.EmployeeDao.Userdao.EmployeeDao;
import com.niit.EmployeeDao.model.EmployeeMaster;
import com.niit.EmployeeDao.model.SkillSet;

@Service
public class EmployeeServImpl implements EmployeeServInter{

	@Autowired
	private EmployeeDao employeedao;

	//@Override
	public boolean addServe(EmployeeMaster employeeObj) {
		
		return employeedao.AddEmployee(employeeObj);	
	}
	
	public boolean updateEmployee(EmployeeMaster employeeObj) {
		
		return employeedao.UpdateEmployee(employeeObj);
	}

	//@Override
	public boolean deleteServe(int emp_id) {
	
		return employeedao.deleteEmployee(emp_id);
	}

	//@Override
	public EmployeeMaster showEmployeeData(int emp_id) {
		
		return (EmployeeMaster) employeedao.getEmployeeId(emp_id);
	}
	//@Override
	public List<EmployeeMaster> getEmployee() {
		return (List<EmployeeMaster>) employeedao.getEmployeeObj();
	}
	public boolean addSkillService(SkillSet addSkillset) {
		
		return employeedao.AddSkillSet(addSkillset);
	}

	
	public List<SkillSet> getSkills1(String skill) {
		// TODO Auto-generated method stub
		return employeedao.getSkill(skill);
	}

	//@Override
	public List<SkillSet> getSkills(String skill) {
		// TODO Auto-generated method stub
		return employeedao.getSkill(skill);
	}

	//@Override
	public List<EmployeeMaster> getforskil() {
		
		return (List<EmployeeMaster>) employeedao.getforSkillUpdate();
	}
	
}




//
//@Override
//public boolean AddEmployee(EmployeeMaster empObj) {
//	// TODO Auto-generated method stub
//	
//}
//
//@Override
//public boolean deleteEmployee(int emp_id) {
//	
//	return employeedao.deleteEmployee(emp_id);
//}
//
//@Override
//public EmployeeMaster getEmployeeId(int emp_id) {
//	
//	return (EmployeeMaster) employeedao.getEmployeeId(emp_id);
//}

