package MappingDemo.Association_Mapping;



//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empID;
	private String ename;
	private double salary;
	private String dept;
	private long Phoneno;

	@ManyToOne
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.Phoneno = phoneno;
	}

	@Override
	public String toString() {
	    return "Employee [empID=" + empID +
	           ", ename=" + ename +
	           ", salary=" + salary +
	           ", dept=" + dept +
	           ", phoneno=" + Phoneno + "]";
	}

}
