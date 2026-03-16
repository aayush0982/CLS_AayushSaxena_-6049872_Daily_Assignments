package Assignment_5and6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Assignment_5_and_6.springcorebeans.Employee5;

public class App5 {
	public static void main(String[] args) {
		System.out.println("-----Starting Application-----");
		System.out.println();
		ApplicationContext ac = new ClassPathXmlApplicationContext("assignConf.xml");

		Employee5 emp = (Employee5) ac.getBean("emp5");
		System.out.println("Employee details");
		System.out.println("-----------------");
		System.out.println("Employee ID : " + emp.getEmpid());
		System.out.println("Employee Name: " + emp.getEmpname());
		System.out.println("Employee Salary: " + emp.getEmpsalary());
		System.out.println("Employee BU: " + emp.getEmpdept());
		System.out.println("Employee Age: " + emp.getEmpage());

		System.out.println();
		System.out.println("----Closing Application-----");
		((AbstractApplicationContext) ac).close();
	}
}
