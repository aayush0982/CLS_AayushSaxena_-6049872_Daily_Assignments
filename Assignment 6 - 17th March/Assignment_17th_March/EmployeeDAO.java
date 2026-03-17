package Assignment_17th_March;

import java.util.List;

public interface EmployeeDAO {
	void add(int id, Employee emp);

	Employee fecthByID(int id);
	
	void remove(int id);
	
	List<Employee> fetchAll();
	
	void update(int id,Employee emp);
}
