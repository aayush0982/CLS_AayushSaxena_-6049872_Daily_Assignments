package Assignment_17th_March;

import java.util.List;

public interface EmployeeService {
	void addEmp(int id, Employee emp);

	Employee findByID(int id);
	
	void removeByID(int id);
	
	List<Employee> fetchAll();
	
	void updateById(int id,Employee emp);

	void destroy() throws Exception;

	void afterPropertiesSet() throws Exception;

}
