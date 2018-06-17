package com.niit.EmployeeDao.service;

import java.util.List;

import com.niit.EmployeeDao.model.*;
public interface EmployeeServInter {

	  public boolean addServe(EmployeeMaster employeeObj);
	  public boolean deleteServe(int emp_id);
	  public EmployeeMaster showEmployeeData(int emp_id);
//	  public List<SkillSet> getSkills(String skill);
	  public boolean updateEmployee(EmployeeMaster employeeObj);
	  public List<EmployeeMaster> getEmployee();
	  public List<EmployeeMaster> getforskil();
	  public boolean addSkillService(SkillSet addSkillset);
	List<SkillSet> getSkills(String skill);
	
}
