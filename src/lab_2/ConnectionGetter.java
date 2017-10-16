package lab_2;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionGetter {
	public static Connection getConnection() {
		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/lab2";
		String user = "root";
		String password = "xjl970928";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
