package Assignment_17th_March;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImpl edao;

	@Override
	public void addEmp(int id, Employee emp) {
		edao.add(id, emp);

	}

	@Override
	public Employee findByID(int id) {
		return edao.fecthByID(id);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean Method Executed");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean Method Executed");

	}

	@PostConstruct
	public void customInit() {
		System.out.println("Custom Initializing Method");
	}

	@PreDestroy
	public void cutomDestroy() {
		System.out.println("Custom Destroy Method");
	}

	@Override
	public void removeByID(int id) {
		edao.remove(id);
		
	}

	@Override
	public List<Employee> fetchAll() {
		return edao.fetchAll();
	}

	@Override
	public void updateById(int id, Employee emp) {
		edao.update(id, emp);
		
	}

}
