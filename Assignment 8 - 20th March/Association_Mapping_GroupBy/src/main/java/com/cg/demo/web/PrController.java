package com.cg.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entities.Department;
import com.cg.demo.entities.Employee;
import com.cg.demo.repo.IDepartment;
import com.cg.demo.repo.IEmployee;

@RestController
public class PrController {
	@Autowired
	private IEmployee empRepo;

	@Autowired
	private IDepartment deptRepo;

	@PostMapping("/emp")
	public String addEmployee(@RequestBody Employee emp) {
		empRepo.save(emp);
		return "Employee Added...";
	}

	@PostMapping("/dept")
	public String addDepartment(@RequestBody Department dept) {
		deptRepo.save(dept);
		return "Department Added...";
	}

	@GetMapping("/emp")
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@GetMapping("/dept")
	public List<Department> getAllDepartments() {
		return deptRepo.findAll();
	}

	@GetMapping("/emp/deptmg")
	public List<Object[]> getEmpDeptMg() {
		return empRepo.getEmpDeptMg();
	}

	@GetMapping("/emp/countbydept")
	public List<Object[]> getEmpCountByDept() {
		return empRepo.getEmpCountByDept();
	}
	
	@GetMapping("/emp/deptname")
	public List<Employee> getEmpByDeptName(@RequestParam String deptName) {
		return empRepo.getEmpByDeptName(deptName);
	}
	
	@GetMapping("/emp/byPhone")
	public List<Object[]> getEmpByPhone(@RequestParam String empPhone) {
		return empRepo.getEmpByPhone(empPhone);
	}

}
