package com.niit.EmployeeDao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import com.niit.EmployeeDao.config.EmployeDAOConfig;
import com.niit.EmployeeDao.model.EmployeeMaster;
import com.niit.EmployeeDao.model.SkillSet;
import com.niit.EmployeeDao.service.EmployeeServImpl;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=EmployeDAOConfig.class) 
public class AppTest
{

@Autowired
	private EmployeeServImpl employeeAction;

	EmployeeMaster employeeModel;
	SkillSet skillOperation;
	@Before
	public void setUp() throws Exception 
	{
		employeeModel=new EmployeeMaster();
		skillOperation = new SkillSet();
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}
	
	@Test
	public void AddEmployee() 
	{
//		employeeModel.setEmployee_Id(556);
		employeeModel.setEmplyeeName("guru");
		employeeModel.setGender("Male");
		String dateOfBirth =null,joinDate = null;
		long mobile = 12345;
		employeeModel.setDateOfBirth(dateOfBirth );
		employeeModel.setMobileNumber(mobile);
		employeeModel.setEmailId("guru@gmail.com");
		employeeModel.setJoinDate(joinDate);
		employeeModel.setDesignation("Trainer");
		employeeModel.setAddress("DGL");
		employeeModel.setQualification("BE");
//		employeeModel.setBatchCount(23);
//		employeeModel.setExperiance(2);
//		employeeModel.setPlacementCount(230);
		
	assertEquals("Success",true,employeeAction.addServe(employeeModel));
	}
	
//	@Test
	public void pub() {
		
		EmployeeMaster emp = new EmployeeMaster();
		emp.setEmployee_Id(1);
		skillOperation.setEmpMaster(emp);
		
		skillOperation.setCertificate("OCJP");
		skillOperation.setSkill("BigData");
		assertEquals("success",true,employeeAction.addSkillService(skillOperation));
	}
//	@Test
	public void SelectEmployee() {
		
		@SuppressWarnings("unchecked")
		List<SkillSet> skillmdl = (List<SkillSet>) new SkillSet();
		skillmdl = employeeAction.getSkills("JSP");
		assertEquals("Found data", true,skillmdl!=null);

	}
//	@Test
//	public void deleteEmployeeValid()
//	{
//		assertEquals("Record deleted",true,employeeAction.deleteServe(1001));
//	}
	
//	
//	@Test
//	public void SelectEmployee() {
//		
//		EmployeeMaster employeemdl = new EmployeeMaster();
//		employeemdl = employeeAction.showEmployeeData(1001);
//		assertEquals("Found data", true,employeemdl!=null);
//
//	}
//	
//	@Test
//	public void SelectEmployees() {
//
//		List<EmployeeMaster> employeeList = new ArrayList<EmployeeMaster>();
//		employeeList = employeeAction.getEmployee();
//		assertEquals("Success", true, employeeList.size() != 0);
//	}
//	
//	@Test
//	public void updateEmployee() 
//	{
//		employeeModel.setEmployee_Id(222);
//		employeeModel.setEmplyeeName("Thamizhavan");
//		employeeModel.setGender("Male");
//		Date dateOfBirth =null,joinDate = null;
//		long mobile = 12345;
//		employeeModel.setDateOfBirth(dateOfBirth );
//		employeeModel.setMobileNumber(mobile);
//		employeeModel.setEmailId("tamizhgovindh@gmail.com");
//		employeeModel.setJoinDate(joinDate);
//		employeeModel.setDesignation("Trainer");
//		employeeModel.setAddress("Chennai");
//		employeeModel.setQualification("MCA");
//		employeeModel.setUserName("Tamizh1100");
//		assertEquals("Success", true, employeeAction.updateEmployee(employeeModel));		
//	}
	
	
	
}