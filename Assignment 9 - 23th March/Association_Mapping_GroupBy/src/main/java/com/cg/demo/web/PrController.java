package com.cg.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.DTO.DeptEmployeeCountDTO;
import com.cg.demo.DTO.EmpDeptByManager;
import com.cg.demo.DTO.EmpDetailsByDeptDTO;
import com.cg.demo.DTO.EmployeeDepartmentDTO;
import com.cg.demo.entities.Department;
import com.cg.demo.entities.Employee;
import com.cg.demo.exception.DepartmentNotFoundException;
import com.cg.demo.exception.EmployeeNotFoundException;
import com.cg.demo.repo.IDepartment;
import com.cg.demo.repo.IEmployee;

import jakarta.validation.Valid;

@RestController
public class PrController {
	@Autowired
	private IEmployee empRepo;

	@Autowired
	private IDepartment deptRepo;

	@PostMapping("/emp")
	public String addEmployee(@Valid @RequestBody Employee emp) {
		empRepo.save(emp);
		return "Employee Added...";
	}

	@PostMapping("/dept")
	public String addDepartment(@Valid @RequestBody Department dept) {
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
	public List<EmpDeptByManager> getEmpDeptMg() {
		List<EmpDeptByManager> list = empRepo.getEmpDeptMg();
		if (list == null || list.isEmpty()) {
			throw new EmployeeNotFoundException("No employee found with department manager information");
		}
		return list;
	}

	@GetMapping("/emp/countbydept")
	public List<DeptEmployeeCountDTO> getEmpCountByDept() {
		return empRepo.getEmpCountByDept();
	}

	@GetMapping("/emp/deptname")
	public List<EmpDetailsByDeptDTO> getEmpByDeptName(@RequestParam String deptName) {
		List<EmpDetailsByDeptDTO> list = empRepo.getEmpByDeptName(deptName);
		if (list == null || list.isEmpty()) {
			throw new DepartmentNotFoundException("Department with name " + deptName + " not found");
		}
		return list;
	}

	@GetMapping("/emp/byPhone")
	public List<EmployeeDepartmentDTO> getEmpByPhone(@RequestParam String empPhone) {

		List<EmployeeDepartmentDTO> result = empRepo.getEmpByPhone(empPhone);

		if (result == null || result.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with phone number " + empPhone + " not found");
		}

		return result;
	}

}
