package JDBC_Prac;

import java.util.*;
import java.sql.SQLException;

public class EmployeeDB_UI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EmployeeDB_Backend db = null;
		try {
			db = new EmployeeDB_Backend();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Failed to connect to DB: " + e.getMessage());
			sc.close();
			return;
		}

		int choice = 0;

		while (choice != 8) {
			System.out.println("\n1. View All Employees");
			System.out.println("2. Insert Employee");
			System.out.println("3. Update Salary");
			System.out.println("4. Fetch Employee by ID");
			System.out.println("5. Delete Employee");
			System.out.println("6. Create Table if Not Exists");
			System.out.println("7. Drop Table");
			System.out.println("8. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			try {
				switch (choice) {
				case 1:
					List<Employee> all = db.fetchAll();
					for (Employee e : all)
						System.out.println(e.getId() + " " + e.getEname() + " " + e.getSalary() + " " + e.getDept()
								+ " " + e.getPhoneNo());
					break;
				case 2:
					Employee emp = new Employee();
					System.out.print("ID: ");
					emp.setId(sc.nextInt());
					sc.nextLine();
					System.out.print("Name: ");
					emp.setEname(sc.nextLine());
					System.out.print("Salary: ");
					emp.setSalary(sc.nextDouble());
					sc.nextLine();
					System.out.print("Dept: ");
					emp.setDept(sc.nextLine());
					System.out.print("Phone: ");
					emp.setPhoneNo(sc.nextLong());
					sc.nextLine();
					Employee inserted = db.insertEmployee(emp);
					if (inserted != null)
						System.out.println("Inserted: " + inserted.getId());
					break;
				case 3:
					System.out.print("ID: ");
					int uid = sc.nextInt();
					sc.nextLine();
					Employee empToUpdate = db.fetchById(uid);
					if (empToUpdate != null) {
						System.out.print("New Salary: ");
						double newSal = sc.nextDouble();
						sc.nextLine();
						double updated = db.updateSalary(uid, newSal);
						if (updated != -1) {
							Employee updatedEmp = db.fetchById(uid);
							System.out.println(
									updatedEmp.getId() + " " + updatedEmp.getEname() + " " + updatedEmp.getSalary()
											+ " " + updatedEmp.getDept() + " " + updatedEmp.getPhoneNo());
						} else
							System.out.println("Salary update failed");
					} else
						System.out.println("Employee Not Found");
					break;
				case 4:
					System.out.print("ID: ");
					int fid = sc.nextInt();
					sc.nextLine();
					Employee fetched = db.fetchById(fid);
					if (fetched != null)
						System.out.println(fetched.getId() + " " + fetched.getEname() + " " + fetched.getSalary() + " "
								+ fetched.getDept() + " " + fetched.getPhoneNo());
					else
						System.out.println("Employee Not Found");
					break;
				case 5:
					System.out.print("ID: ");
					int did = sc.nextInt();
					sc.nextLine();
					Employee deleted = db.deleteById(did);
					if (deleted != null)
						System.out.println("Deleted: " + deleted.getId() + " " + deleted.getEname());
					else
						System.out.println("Employee Not Found");
					break;
				case 6:
					if (db.createTableIfNotExists())
						System.out.println("Table created or already exists");
					break;
				case 7:
					if (db.dropTable())
						System.out.println("Table dropped successfully");
					break;
				case 8:
					db.close();
					System.out.println("Exited");
					break;
				default:
					System.out.println("Invalid Choice");
				}
			} catch (SQLException e) {
				System.out.println("Database error: " + e.getMessage());
			}
		}

		sc.close();
	}
}