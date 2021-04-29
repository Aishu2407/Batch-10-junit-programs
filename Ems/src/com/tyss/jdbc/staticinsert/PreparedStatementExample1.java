package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample1 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		} catch (Exception e) {
			System.out.println("connection failed");
			e.printStackTrace();
			return;
		}
//3.issue sql query via connection
		String query = "select * from employee where id=?";
		try {
			pstmt = conn.prepareStatement(query);
			String id = args[0];
			int employeeid = Integer.parseInt(id);
			// setting parameter
			pstmt.setInt(1, employeeid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("id");
				String empname = rs.getString("name");

				System.out.println("empid:" + id1);
				System.out.println("empname:" + empname);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}