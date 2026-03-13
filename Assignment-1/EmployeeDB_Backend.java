package JDBC_Prac;

import java.sql.*;
import java.util.*;

public class EmployeeDB_Backend {

	private Connection con;

	public EmployeeDB_Backend() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EMPLOYEEDB", "postgres", "1234567890");
	}

	public boolean createTableIfNotExists() throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS EMP (" + "ID INT PRIMARY KEY, " + "ENAME VARCHAR(50), "
				+ "SALARY DOUBLE PRECISION, " + "DEPT VARCHAR(50), " + "PHONENO BIGINT)";
		stmt.executeUpdate(sql);
		stmt.close();
		return true;
	}

	public boolean dropTable() throws SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("DROP TABLE IF EXISTS EMP");
		stmt.close();
		return true;
	}

	public List<Employee> fetchAll() throws SQLException {
		List<Employee> list = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("ID"));
			emp.setEname(rs.getString("ENAME"));
			emp.setSalary(rs.getDouble("SALARY"));
			emp.setDept(rs.getString("DEPT"));
			emp.setPhoneNo(rs.getLong("PHONENO"));
			list.add(emp);
		}
		rs.close();
		ps.close();
		return list;
	}

	public Employee insertEmployee(Employee emp) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO EMP (ID,ENAME,SALARY,DEPT,PHONENO) VALUES (?,?,?,?,?)");
		ps.setInt(1, emp.getId());
		ps.setString(2, emp.getEname());
		ps.setDouble(3, emp.getSalary());
		ps.setString(4, emp.getDept());
		ps.setLong(5, emp.getPhoneNo());
		int rows = ps.executeUpdate();
		ps.close();
		return rows > 0 ? emp : null;
	}

	public double updateSalary(int id, double newSalary) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE EMP SET SALARY=? WHERE ID=?");
		ps.setDouble(1, newSalary);
		ps.setInt(2, id);
		int rows = ps.executeUpdate();
		ps.close();
		return rows > 0 ? newSalary : -1;
	}

	public Employee fetchById(int id) throws SQLException {
		Employee emp = null;
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			emp = new Employee();
			emp.setId(rs.getInt("ID"));
			emp.setEname(rs.getString("ENAME"));
			emp.setSalary(rs.getDouble("SALARY"));
			emp.setDept(rs.getString("DEPT"));
			emp.setPhoneNo(rs.getLong("PHONENO"));
		}
		rs.close();
		ps.close();
		return emp;
	}

	public Employee deleteById(int id) throws SQLException {
		Employee emp = fetchById(id);
		if (emp != null) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM EMP WHERE ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}
		return emp;
	}

	public void close() throws SQLException {
		if (con != null)
			con.close();
	}
}