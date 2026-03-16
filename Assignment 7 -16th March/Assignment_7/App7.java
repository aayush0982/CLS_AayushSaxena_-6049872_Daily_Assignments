package Assignment_7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Assignment_7.sprincorebeans.Department;
//import Assignment_7.sprincorebeans.Employee;

public class App7 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("assignConf.xml");

        Department dept = (Department) ac.getBean("sbu2");

        System.out.println("SBU details");
        System.out.println("sbuCode=" + dept.getSbuID() +
                           ", sbuHead=" + dept.getSbuHead() +
                           ", sbuName=" + dept.getSbuName());

        System.out.println("Employee details:");
        System.out.println(dept.getEmployeeList());

        ((AbstractApplicationContext) ac).close();
    }
}