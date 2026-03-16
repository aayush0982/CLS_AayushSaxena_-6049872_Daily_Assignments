package Assignment_5and6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Assignment_5_and_6.springcorebeans.Employee6;

public class App6 {
	public static void main(String[] args) {
		System.out.println("-----Starting Application-----");
		System.out.println();

		ApplicationContext ac = new ClassPathXmlApplicationContext("assignConf.xml");

		Employee6 emp = (Employee6) ac.getBean("emp6");

		System.out.println("Employee details");
		System.out.println(emp);  

		System.out.println();
		System.out.println("----Closing Application-----");
		((AbstractApplicationContext) ac).close();
	}
}