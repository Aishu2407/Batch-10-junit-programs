package com.tyss.junit.programs;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

import com.tyss.junit.assignment1.JdbcClass;

public class JdbcClassTest {

	@Test
	void testInsert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/storeddata?user=root&password=root");
			JdbcClass jc = new JdbcClass();
			jc.insert(1, "Hruthik");
//	     assertEquals(1, i);
			String query = "select * from student";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			assertEquals(1, rs.getInt(1));
			assertEquals("Hruthik", rs.getString(2));
			con.close();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testUpdate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storeddata?user=root&password=root");
					
			JdbcClass jc = new JdbcClass();
			jc.update(1, "aish");
//	    assertEquals(1, i);
			String query = "select * from student";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			assertEquals("aish", rs.getString(2));
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	
	
	@Test
	void testDelete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/storeddata?user=root&password=root");
			JdbcClass jc = new JdbcClass();
			jc.delete(1);
//	     assertEquals(1, i);
			String query = "select * from student";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			assertEquals(rs.next(), false);
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
