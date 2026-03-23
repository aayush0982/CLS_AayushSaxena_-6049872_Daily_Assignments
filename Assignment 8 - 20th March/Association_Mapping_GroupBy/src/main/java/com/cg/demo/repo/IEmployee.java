package com.cg.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.demo.entities.Employee;

@Repository
public interface IEmployee extends JpaRepository<Employee, Integer> {
	@Query("SELECT e.empName, d.deptManager, d.deptName FROM Employee e JOIN e.dept d")
	List<Object[]> getEmpDeptMg();
	
	@Query("SELECT COUNT(e),d.deptName FROM Employee e join e.dept d GROUP BY d.deptName")
	List<Object[]> getEmpCountByDept();
	
	@Query("SELECT e FROM Employee e JOIN e.dept d WHERE d.deptName = :deptName")
	List<Employee> getEmpByDeptName(@Param("deptName") String deptName);
	
	@Query("SELECT e.empId, e.empName, d FROM Employee e JOIN e.dept d JOIN e.empPhone p WHERE p = :empPhone")
	List<Object[]> getEmpByPhone(@Param("empPhone") String empPhone);
}
