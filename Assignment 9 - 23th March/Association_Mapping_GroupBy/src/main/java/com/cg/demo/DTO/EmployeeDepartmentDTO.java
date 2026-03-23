package com.cg.demo.DTO;

public class EmployeeDepartmentDTO {
	private Integer empId;
	private String empName;
	private String deptName;
	private String deptManager;
	private int deptId;
	
	public EmployeeDepartmentDTO(int empId, String empName, String deptName, String deptManager, int deptId) {
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.deptManager = deptManager;
		this.deptId = deptId;
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
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getDeptManager() {
		return deptManager;
	}
	
	public void setDeptManager(String deptManager) {
		this.deptManager = deptManager;
	}
	
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	@Override
	public String toString() {
		return "EmployeeDepartmentDTO [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName
				+ ", deptManager=" + deptManager + ", deptId=" + deptId + "]";
	}
	
}
