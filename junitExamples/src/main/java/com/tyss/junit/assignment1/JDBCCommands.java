package com.tyss.junit.assignment1;

import java.sql.*;
interface My{
boolean add();
boolean delete();
boolean update();
boolean select();
}
public class JDBCCommands {
public boolean add(String str, String st) {
int effect=0;
try {


	Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
String query="insert into  credentials values(?,?)";
PreparedStatement ppt=con.prepareStatement(query);
ppt.setString(1,str);
ppt.setString(2,st);

effect=ppt.executeUpdate();

}catch(Exception e) {
e.printStackTrace();
}
if(effect==0) {
return false;

}
return true;
}
public boolean update(String str, String st) {
int effect=0;
try {


	Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
String query="update credentials set password=? where user_name=?";
PreparedStatement ppt=con.prepareStatement(query);
ppt.setString(1,st);
ppt.setString(2,str);

effect=ppt.executeUpdate();

}catch(Exception e) {
e.printStackTrace();
}
if(effect==0) {
return false;

}
return true;
}
public boolean delete(String str) {
int effect=0;
try {


	Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
String query="delete from credentials where  user_name=?";
PreparedStatement ppt=con.prepareStatement(query);
ppt.setString(1,str);


effect=ppt.executeUpdate();

}catch(Exception e) {
e.printStackTrace();
}
if(effect==0) {
return false;

}
return true;
}
public boolean select(String str) {
ResultSet rs=null;
try {


	Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
String query="select  password from credentials where  user_name=?";
PreparedStatement ppt=con.prepareStatement(query);
ppt.setString(1,str);


rs=ppt.executeQuery();

}catch(Exception e) {
e.printStackTrace();
}
if(rs==null) {
return false;

}
return true;


}
}