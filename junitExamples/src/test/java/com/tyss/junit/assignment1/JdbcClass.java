package com.tyss.junit.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcClass implements JdbcInterface {

	@Override
	public void insert(int uid, String uname) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root@123");
			String query = "insert into student values(?,?);";
			PreparedStatement pm = con.prepareStatement(query);
			pm.setInt(1, uid);
			pm.setString(2, uname);

			pm.execute();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	
	@Override
	public void update(int uid, String uname) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root@123");
			String query = "upadte student set sname=? where sid=?;";
			PreparedStatement pm = con.prepareStatement(query);
			pm.setString(1, uname);
			pm.setInt(2, uid);

			pm.execute();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void delete(int uid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root@123");
			String query = "delete from student where sid=?;";
			PreparedStatement pm = con.prepareStatement(query);

			pm.setInt(1, uid);

			pm.execute();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
