package com.niit.EmployeeDao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="SkillSetReg")
public class SkillSet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int skillId;	
	@OneToOne	
	private EmployeeMaster empMaster;	
	private String certificate;
	private String skill;
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public EmployeeMaster getEmpMaster() {
		return empMaster;
	}
	public void setEmpMaster(EmployeeMaster empMaster) {
		this.empMaster = empMaster;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
