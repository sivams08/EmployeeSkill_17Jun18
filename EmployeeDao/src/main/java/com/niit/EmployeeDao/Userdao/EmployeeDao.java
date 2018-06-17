package com.niit.EmployeeDao.Userdao;

import com.niit.EmployeeDao.model.EmployeeMaster;
import com.niit.EmployeeDao.model.SkillSet;
import java.util.List;

public interface EmployeeDao {
	public boolean AddEmployee(EmployeeMaster empObj);
	public boolean deleteEmployee(int emp_id);
	public EmployeeMaster getEmployeeId(int emp_id);
	public List<SkillSet> getSkill(String skill);
	public List<EmployeeMaster> getEmployeeObj();
	public List<EmployeeMaster> getforSkillUpdate();
	public boolean UpdateEmployee(EmployeeMaster empObj);
	public boolean AddSkillSet(SkillSet addskill);
	List<SkillSet> getEmployeeSkill();
}