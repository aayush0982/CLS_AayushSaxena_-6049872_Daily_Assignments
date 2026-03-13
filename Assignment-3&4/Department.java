package MappingDemo.Association_Mapping;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private int deptid;
	private String deptname;
	private String dmanager;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> list;

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDmanager() {
		return dmanager;
	}

	public void setDmanager(String dmanager) {
		this.dmanager = dmanager;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

	@Override
	public String toString() {
	    return "Department [deptid=" + deptid +
	           ", deptname=" + deptname +
	           ", dmanager=" + dmanager + "]";
	}

}
