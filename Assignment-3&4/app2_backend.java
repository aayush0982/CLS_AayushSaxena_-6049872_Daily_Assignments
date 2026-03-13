package MappingDemo.Association_Mapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class app2_backend {

	EntityManagerFactory emf;
	EntityManager em;

	public app2_backend() {
		emf = Persistence.createEntityManagerFactory("JPA-PU");
		em = emf.createEntityManager();
	}

	public void insertData() {

		em.getTransaction().begin();

		Department d1 = new Department();
		d1.setDeptid(101);
		d1.setDeptname("SCI");
		d1.setDmanager("MANAGER1");

		Employee e1 = new Employee();
		e1.setDept("SCI");
		e1.setEname("Vale");
		e1.setSalary(23946.12);
		e1.setPhoneno(9876543210L);
		e1.setDepartment(d1);

		Employee e2 = new Employee();
		e2.setDept("SCI");
		e2.setEname("Alucard");
		e2.setSalary(28450.75);
		e2.setPhoneno(9876543211L);
		e2.setDepartment(d1);

		Employee e3 = new Employee();
		e3.setDept("SCI");
		e3.setEname("Gusion");
		e3.setSalary(31560.40);
		e3.setPhoneno(9876543212L);
		e3.setDepartment(d1);

		Employee e4 = new Employee();
		e4.setDept("SCI");
		e4.setEname("Layla");
		e4.setSalary(26780.95);
		e4.setPhoneno(9876543213L);
		e4.setDepartment(d1);

		List<Employee> l = new ArrayList<>();
		l.add(e1);
		l.add(e2);
		l.add(e3);
		l.add(e4);
		d1.setList(l);

		em.persist(d1);

		Department d2 = new Department();
		d2.setDeptid(102);
		d2.setDeptname("TECH");
		d2.setDmanager("MANAGER2");

		Employee e5 = new Employee();
		e5.setDept("TECH");
		e5.setEname("Tigreal");
		e5.setSalary(28940.50);
		e5.setPhoneno(9876543214L);
		e5.setDepartment(d2);

		Employee e6 = new Employee();
		e6.setDept("TECH");
		e6.setEname("Eudora");
		e6.setSalary(27110.75);
		e6.setPhoneno(9876543215L);
		e6.setDepartment(d2);

		List<Employee> l2 = new ArrayList<>();
		l2.add(e5);
		l2.add(e6);
		d2.setList(l2);

		em.persist(d2);

		Department d3 = new Department();
		d3.setDeptid(103);
		d3.setDeptname("ART");
		d3.setDmanager("MANAGER3");

		Employee e7 = new Employee();
		e7.setDept("ART");
		e7.setEname("Zilong");
		e7.setSalary(26340.80);
		e7.setPhoneno(9876543216L);
		e7.setDepartment(d3);

		Employee e8 = new Employee();
		e8.setDept("ART");
		e8.setEname("Lesley");
		e8.setSalary(29560.45);
		e8.setPhoneno(9876543217L);
		e8.setDepartment(d3);

		List<Employee> l3 = new ArrayList<>();
		l3.add(e7);
		l3.add(e8);
		d3.setList(l3);

		em.persist(d3);

		Department d4 = new Department();
		d4.setDeptid(104);
		d4.setDeptname("MED");
		d4.setDmanager("MANAGER4");

		Employee e9 = new Employee();
		e9.setDept("MED");
		e9.setEname("Angela");
		e9.setSalary(25500.90);
		e9.setPhoneno(9876543218L);
		e9.setDepartment(d4);

		Employee e10 = new Employee();
		e10.setDept("MED");
		e10.setEname("Hayabusa");
		e10.setSalary(32210.65);
		e10.setPhoneno(9876543219L);
		e10.setDepartment(d4);

		List<Employee> l4 = new ArrayList<>();
		l4.add(e9);
		l4.add(e10);
		d4.setList(l4);

		em.persist(d4);

		em.getTransaction().commit();
	}

	public List<Object[]> employeeCount() {

//		Query q = em.createQuery(
//				"SELECT COUNT(e), d.deptname, d.dmanager FROM Employee e JOIN e.department d GROUP BY d.deptname, d.deptid");

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Employee> root = cq.from(Employee.class);
		Join<Employee, Department> joinED = root.join("department");

		cq.multiselect(cb.count(root), joinED.get("deptname"), joinED.get("deptid"));
		cq.groupBy(joinED.get("deptname"), joinED.get("deptid"));

		TypedQuery<Object[]> q = em.createQuery(cq);

		return q.getResultList();
	}

	public List<Employee> searchByDepartment(String dname) {

//		Query q = em.createQuery(
//		"SELECT COUNT(e), d.deptname, d.deptid FROM Employee e JOIN e.department d WHERE d.deptname = :dname GROUP BY d.deptid, d.deptname");

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

		Root<Employee> root = cq.from(Employee.class);
		Join<Employee, Department> joinED = root.join("department");

		Predicate pd = cb.equal(joinED.get("deptname"), dname);

		cq.select(root).where(pd);

		return em.createQuery(cq).getResultList();
	}

	public List<Object[]> searchByPhone(long phone) {

//		Query q = em.createQuery(
//				"SELECT d, e.ename, e.empID FROM Employee e JOIN e.department d WHERE e.phoneno = :phoneno");

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Employee> root = cq.from(Employee.class);
		Join<Employee, Department> joinED = root.join("department");

		Predicate pd = cb.equal(root.get("phoneno"), phone);

		cq.multiselect(joinED, root.get("ename"), root.get("empID")).where(pd);

		return em.createQuery(cq).getResultList();
	}

	public List<Employee> searchBySalary(double salary) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

		Root<Employee> root = cq.from(Employee.class);

		Predicate salPd = cb.gt(root.get("salary"), salary);

		cq.select(root).where(salPd);

		return em.createQuery(cq).getResultList();
	}

	public void close() {
		em.close();
		emf.close();
	}
}