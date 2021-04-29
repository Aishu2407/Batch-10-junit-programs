package com.tyss.assignment1;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String path = "f:\\properties.txt";
			FileReader reader = new FileReader(path);
			Properties prop = new Properties();
			prop.load(reader);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", prop);

			String que = "insert into employee values(7,'abhi',6000,'me',990088)";
			st = con.createStatement();
			int count = st.executeUpdate(que);
			System.out.println("no of rows affected:" + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
