package com.niit.EmployeeDao.Userdao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.niit.EmployeeDao.model.EmployeeMaster;
import com.niit.EmployeeDao.model.SkillSet;

@Repository("employeedao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFact;
	
	public boolean UpdateEmployee(EmployeeMaster empObj) {
			sessionFact.getCurrentSession().saveOrUpdate(empObj);
			return true;
	}
	//@Override
	public boolean AddEmployee(EmployeeMaster empObj) {
		
			sessionFact.getCurrentSession().save(empObj);
			return true;		
	}
	
	//@Override
	public boolean deleteEmployee(int emp_id) {
		// TODO Auto-generated method stub	
				EmployeeMaster employeeObj = getEmployeeId(emp_id);
				sessionFact.getCurrentSession().delete(employeeObj);
				return true;
	}

	//@Override
	public EmployeeMaster getEmployeeId(int emp_id) {
		return (EmployeeMaster) sessionFact.getCurrentSession().createQuery("from EmployeeMaster where employee_id="+emp_id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<SkillSet> getSkill(String skill) {
		
		return (List<SkillSet>) sessionFact.getCurrentSession().createQuery("from SkillSet where skill='"+skill+"'").list();
	}
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<EmployeeMaster> getEmployeeObj() {
		
		return (List<EmployeeMaster>) sessionFact.getCurrentSession().createQuery("from EmployeeMaster where batchCount="+0).list();
	}
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<EmployeeMaster> getforSkillUpdate() {
		
		return (List<EmployeeMaster>) sessionFact.getCurrentSession().createQuery("from EmployeeMaster where batchCount!="+0).list();
	}
		
	
	//@Override
	public boolean AddSkillSet(SkillSet addskillset) {
		
		sessionFact.getCurrentSession().save(addskillset);		
		return true;	
	}
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<SkillSet> getEmployeeSkill() {
		// TODO Auto-generated method stub
		return (List<SkillSet>) sessionFact.getCurrentSession().createQuery("from SkillSet").list();
	}		
}
