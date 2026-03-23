package com.cg.demo.DTO;

import java.util.List;

public class EmpDetailsByDeptDTO {
	private Integer empId;
	private String empName;
	private double empSal;
	private String deptName;
	private String managerName;

	public EmpDetailsByDeptDTO() {
	}

	public EmpDetailsByDeptDTO(Integer empId, String empName, double empSal, String deptName, String managerName) {
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.deptName = deptName;
		this.managerName = managerName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "EmpDetailsByDeptDTO [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", deptName="
				+ deptName + ", managerName=" + managerName + "]";
	}

}
