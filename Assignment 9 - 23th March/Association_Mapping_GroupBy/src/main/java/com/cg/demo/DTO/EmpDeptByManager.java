package com.cg.demo.DTO;

import java.util.List;

public class EmpDeptByManager {
	private Integer empId;
	private String empName;
	private String deptManager;
	private double empSalary;
	private String deptName;
	private List<String> empPhones;

	public EmpDeptByManager() {
		super();
	}

	public EmpDeptByManager(String empName, String deptManager, Integer empId, double empSalary, String deptName) {
		this.empName = empName;
		this.deptManager = deptManager;
		this.empId = empId;
		this.empSalary = empSalary;
		this.deptName = deptName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(String deptManager) {
		this.deptManager = deptManager;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<String> getEmpPhones() {
		return empPhones;
	}

	public void setEmpPhones(List<String> empPhones) {
		this.empPhones = empPhones;
	}

	@Override
	public String toString() {
		return "EmpDeptByManager [empId=" + empId + ", empName=" + empName + ", deptManager=" + deptManager
				+ ", empSalary=" + empSalary + ", deptName=" + deptName + "]";
	}

}
