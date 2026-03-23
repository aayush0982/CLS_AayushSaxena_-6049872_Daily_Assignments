package com.cg.demo.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;

//import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@NotEmpty(message = "Employee name must not be empty")
	private String empName;
	@Min(value = 25000, message = "Employee salary must be non-negative and greater than or equal to 25000")
	private double empSal;
	@ElementCollection
	private List<String> empPhone;
	@ManyToOne
	private Department dept;

	public Employee() {
	}

	public Employee(String empName, double empSal, List<String> empPhone) {
		this.empName = empName;
		this.empSal = empSal;
		this.empPhone = empPhone;
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

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public List<String> getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(List<String> empPhone) {
		this.empPhone = empPhone;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empPhone=" + empPhone
				+ "]";
	}
}
