package data;

import java.sql.*;
import java.util.HashMap;

public class DataRetriever {

	public static ResultSet retreiveDbData() {
		ResultSet rs = null;
		HashMap map = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jasper", "root", "memosa1002");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from tasks;");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

}
