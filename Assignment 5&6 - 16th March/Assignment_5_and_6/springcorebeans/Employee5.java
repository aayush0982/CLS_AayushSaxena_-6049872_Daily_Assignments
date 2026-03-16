package Assignment_5_and_6.springcorebeans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee5 {
	@Id
	private int empid;
	private String empname;
	private double empsalary;
	private String empdept;
	private int empage;

	public Employee5() {}

	public Employee5(int empid, String empname, double empsalary, String empdept, int empage) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
		this.empdept = empdept;
		this.empage = empage;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}

	public String getEmpdept() {
		return empdept;
	}

	public void setEmpdept(String empdept) {
		this.empdept = empdept;
	}

	public int getEmpage() {
		return empage;
	}

	public void setEmpage(int empage) {
		this.empage = empage;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + ", empdept=" + empdept
				+ ", empage=" + empage + "]";
	};
	
	
}
