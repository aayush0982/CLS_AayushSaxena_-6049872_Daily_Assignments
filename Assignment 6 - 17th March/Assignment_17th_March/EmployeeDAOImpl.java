package Assignment_17th_March;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private Map<Integer, Employee> m = new HashMap<>();

	@Override
	public void add(int id, Employee emp) {
		m.put(id, emp);
		System.out.println("Employee Details Added Successfully");

	}

	@Override
	public Employee fecthByID(int id) {
		return m.get(id);
	}

	@Override
	public void remove(int id) {
		m.remove(id);
		System.out.println("Employee Details Deleted Successfully");

		
	}

	@Override
	public List<Employee> fetchAll() {
		List<Employee> list = new ArrayList<>();
		for(int i:m.keySet()) {
			list.add(m.get(i));
		}
		return list;
	}

	@Override
	public void update(int id, Employee emp) {
		m.put(id, emp);
		System.out.println("Employee Details Updated Successfully");

		
	}

}
