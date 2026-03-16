package Assignment_5_and_6.springcorebeans;

public class Employee6 {
	private int empid;
	private String empname;
	private double empsalary;
	private int empage;
	private Department empdept;

	public Employee6() {
	};

	public Employee6(int empid, String empname, double empsalary, int empage, Department empdept) {
		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
		this.empage = empage;
		this.empdept = empdept;
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

	public int getEmpage() {
		return empage;
	}

	public void setEmpage(int empage) {
		this.empage = empage;
	}

	public Department getEmpdept() {
		return empdept;
	}

	public void setEmpdept(Department empdept) {
		this.empdept = empdept;
	}

	@Override
	public String toString() {
		return "Employee [empAge=" + empage + ", empId=" + empid + ", empName=" + empname + ", empSalary=" + empsalary
				+ "\nsbu details " + empdept + "]";
	}
}
