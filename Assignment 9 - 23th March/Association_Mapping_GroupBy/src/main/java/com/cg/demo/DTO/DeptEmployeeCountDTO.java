package com.cg.demo.DTO;

public class DeptEmployeeCountDTO {
	private String deptName;
	private long empCount;

	public DeptEmployeeCountDTO(String deptName, long empCount) {
		this.deptName = deptName;
		this.empCount = empCount;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getEmpCount() {
		return empCount;
	}

	public void setEmpCount(long empCount) {
		this.empCount = empCount;
	}
	
	@Override
	public String toString() {
		return "DeptEmployeeCountDTO [deptName=" + deptName + ", empCount=" + empCount + "]";
	}

}
