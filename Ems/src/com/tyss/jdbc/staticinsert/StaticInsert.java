package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





public class StaticInsert {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
	try {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(driver);
	
	//2.get connection via driver
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
	
	//3.issue sql query via connection
	
	String query="insert into Employee values(5,'aish',2500,'devop',9972706)";
	stmt=con.createStatement();
	
	//4.process the result
	int count=stmt.executeUpdate(query);
	System.out.println("no of rows affected :"+count);
	
	
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
	




	}

	}
}
