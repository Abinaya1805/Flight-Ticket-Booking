package dbConnection;
import java.sql.*;
public class DBConnection {
	public Connection getDBConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Admin","root","ayanibA@1805");
			return con;
		}
		catch(Exception e) {
			
		}
		return null;
	}
}
