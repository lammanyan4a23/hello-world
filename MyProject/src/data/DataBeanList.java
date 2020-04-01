package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.DataBean;

public class DataBeanList {

	public ArrayList<DataBean> getDataBeanList() throws SQLException, ClassNotFoundException {
		ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jasper", "root", "memosa1002");
		// here sonoo is database name, root is username and password
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from tasks;");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			dataBeanList.add(getDataBean(rs.getString(2), rs.getString(3)));
		}
		con.close();

//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//	      dataBeanList.add(produce("Manisha", "India"));
//	      dataBeanList.add(produce("Dennis Ritchie", "USA"));
//	      dataBeanList.add(produce("V.Anand", "India"));
//	      dataBeanList.add(produce("Shrinath", "California"));

		return dataBeanList;
	}

	private DataBean getDataBean(String name, String country) {
		DataBean bean = new DataBean();
		bean.setName(name);
		bean.setCountry(country);
		return bean;

	}
}
