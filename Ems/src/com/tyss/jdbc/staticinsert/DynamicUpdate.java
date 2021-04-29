package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicUpdate {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");

			String que = "update Employee set name=? where id=?";
			pstmt = conn.prepareStatement(que);
			// setting parameters
			pstmt.setString(1, "bindu");
			pstmt.setInt(2, 3);
			
			pstmt.setString(1, "rakshu");
			pstmt.setInt(2, 2);

			int count = pstmt.executeUpdate();
			System.out.println("update sucessfull......");
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
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

		}
	}
}
