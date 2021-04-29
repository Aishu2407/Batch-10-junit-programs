package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticSelect {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.get connection via driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			//3.issue sql query via connection
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Employee");
			//4.process the result
			while(rs.next())
			{
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("sal"));
				System.out.println(rs.getString("dept"));
				System.out.println(rs.getInt("phno"));
				System.out.println("_________________");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//5.close all jdbc objects
			finally {
				if(con!=null)
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(stmt!=null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			if(rs!=null)
			try {
			rs.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	}
}

			
		
		
	

		
		
		



