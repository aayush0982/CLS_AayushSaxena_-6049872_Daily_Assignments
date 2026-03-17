package Assignment_17th_March;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AssignmentConfig.class);

		context.registerShutdownHook();

		EmployeeService empI = context.getBean(EmployeeService.class);

		Scanner sc = new Scanner(System.in);
		int choice = 1;

		while (choice != 0) {

			System.out.println("\n===== EMPLOYEE MENU =====");
			System.out.println("1. Add Employee");
			System.out.println("2. Fetch Employee by ID");
			System.out.println("3. Remove Employee");
			System.out.println("4. Fetch All Employees");
			System.out.println("5. Update Employee");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Salary: ");
				double salary = sc.nextDouble();

				Employee e = new Employee(id, name, salary);
				empI.addEmp(id, e);

				System.out.println("Employee Added!");
			}

			else if (choice == 2) {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();

				Employee e = empI.findByID(id);

				if (e != null)
					System.out.println(e);
				else
					System.out.println("Employee not found!");
			}

			else if (choice == 3) {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();

				empI.removeByID(id);
				System.out.println("Employee Removed!");
			}

			else if (choice == 4) {
				List<Employee> list = empI.fetchAll();

				if (list.isEmpty()) {
					System.out.println("No employees found!");
				} else {
					for (Employee e : list) {
						System.out.println(e);
					}
				}
			}

			else if (choice == 5) {
				System.out.print("Enter ID to update: ");
				int id = sc.nextInt();
				sc.nextLine();

				Employee existing = empI.findByID(id);

				if (existing != null) {
					System.out.print("Enter New Name: ");
					String name = sc.nextLine();

					System.out.print("Enter New Salary: ");
					double salary = sc.nextDouble();

					Employee updated = new Employee(id, name, salary);
					empI.updateById(id, updated);

					System.out.println("Employee Updated!");
				} else {
					System.out.println("Employee not found!");
				}
			}

			else if (choice == 0) {
				System.out.println("Exiting...");
			}

			else {
				System.out.println("Invalid Choice!");
			}
		}

		sc.close();
	}
}