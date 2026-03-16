package Assignment_7.sprincorebeans;

import java.util.List;

public class Department {
	private String sbuID;
	private String sbuName;
	private String sbuHead;
	private List<Employee> employeeList;

	public Department() {
	};

	public Department(String sbuID, String sbuName, String sbuHead, List<Employee> employeeList) {
		super();
		this.sbuID = sbuID;
		this.sbuName = sbuName;
		this.sbuHead = sbuHead;
		this.employeeList = employeeList;
	}

	public String getSbuID() {
		return sbuID;
	}

	public void setSbuID(String sbuID) {
		this.sbuID = sbuID;
	}

	public String getSbuName() {
		return sbuName;
	}

	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}

	public String getSbuHead() {
		return sbuHead;
	}

	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}

	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [sbuID=" + sbuID + ", sbuName=" + sbuName + ", sbuHead=" + sbuHead + ", employeeList="
				+ employeeList + "]";
	}

}
