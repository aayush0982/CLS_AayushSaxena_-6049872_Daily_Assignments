package com.cg.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.demo.DTO.DeptEmployeeCountDTO;
import com.cg.demo.DTO.EmpDeptByManager;
import com.cg.demo.DTO.EmpDetailsByDeptDTO;
import com.cg.demo.DTO.EmployeeDepartmentDTO;
import com.cg.demo.entities.Employee;

@Repository
public interface IEmployee extends JpaRepository<Employee, Integer> {
//	@Query("SELECT e.empName, d.deptManager FROM Employee e JOIN e.dept d")
	@Query("SELECT new com.cg.demo.DTO.EmpDeptByManager(e.empName, d.deptManager, e.empId, e.empSal, d.deptName) "
			+ "FROM Employee e JOIN e.dept d")
	List<EmpDeptByManager> getEmpDeptMg();

//	@Query("SELECT COUNT(e),d.deptName FROM Employee e join e.dept d GROUP BY d.deptName")
	@Query("SELECT new com.cg.demo.DTO.DeptEmployeeCountDTO(d.deptName,COUNT(e)) FROM Employee e JOIN e.dept d GROUP BY d.deptName")
	List<DeptEmployeeCountDTO> getEmpCountByDept();

//	@Query("SELECT e FROM Employee e JOIN e.dept d  WHERE d.deptName = :deptName")
	@Query("SELECT new com.cg.demo.DTO.EmpDetailsByDeptDTO("
			+ "e.empId, e.empName, e.empSal, d.deptName, d.deptManager) "
			+ "FROM Employee e JOIN e.dept d WHERE d.deptName = :deptName")
	List<EmpDetailsByDeptDTO> getEmpByDeptName(@Param("deptName") String deptName);

//	@Query("SELECT e.empId, e.empName, d FROM Employee e JOIN e.dept d JOIN e.empPhone p WHERE p = :empPhone")
	@Query("SELECT new com.cg.demo.DTO.EmployeeDepartmentDTO(e.empId, e.empName, d.deptName, d.deptManager, d.deptId) "
			+ "FROM Employee e JOIN e.dept d JOIN e.empPhone p WHERE p = :empPhone")
	List<EmployeeDepartmentDTO> getEmpByPhone(@Param("empPhone") String empPhone);
}
