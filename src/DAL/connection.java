package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	protected Connection con;
	public Connection openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/nhanviendtb";
			String username = "root";
			String pass = "";
			con=DriverManager.getConnection(url, username, pass);
			
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void closeConnection() {
		try {
			if (con!= null)
				con.close();
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println(ex);
		}
	}
	
}
