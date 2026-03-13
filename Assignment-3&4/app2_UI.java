package MappingDemo.Association_Mapping;

import java.util.List;
import java.util.Scanner;

public class app2_UI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		app2_backend backend = new app2_backend();

		int choice;

		do {

			System.out.println("\n===== MENU =====");
			System.out.println("1 Insert Data");
			System.out.println("2 Employee Count by Department");
			System.out.println("3 Search Employees by Department");
			System.out.println("4 Search Employee by Phone");
			System.out.println("5 Search Employee by Salary");
			System.out.println("6 Exit");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				backend.insertData();
				System.out.println("Data Inserted");
				break;

			case 2:
				List<Object[]> list = backend.employeeCount();

				for (Object[] row : list) {
					Long count = (Long) row[0];
					String deptName = (String) row[1];
					Integer deptId = (Integer) row[2];
					System.out.println(count + " " + deptName + " " + deptId);
				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Department Name:");
				String dname = sc.nextLine();

				List<Employee> empList = backend.searchByDepartment(dname);

				if (empList.isEmpty()) {
					System.out.println("No employees found");
				} else {
					for (Employee e : empList) {
						System.out.println(e);
					}
				}
				break;

			case 4:
				System.out.println("Enter Phone Number:");
				long phone = sc.nextLong();

				List<Object[]> phoneList = backend.searchByPhone(phone);

				if (phoneList.isEmpty()) {
					System.out.println("Not found");
				} else {
					for (Object[] o : phoneList) {
						Department d = (Department) o[0];
						String name = (String) o[1];
						Integer id = (Integer) o[2];
						System.out.println(d.getDeptname() + " " + name + " " + id);
					}
				}
				break;

			case 5:
				System.out.println("Enter Salary:");
				double salary = sc.nextDouble();

				List<Employee> salaryList = backend.searchBySalary(salary);

				if (salaryList.isEmpty()) {
					System.out.println("No employees found");
				} else {
					for (Employee e : salaryList) {
						System.out.println(e);
					}
				}
				break;

			case 6:
				System.out.println("Application Ended");
				backend.close();
				break;

			default:
				System.out.println("Invalid Choice");

			}

		} while (choice != 6);

		sc.close();
	}
}