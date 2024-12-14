package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/student";
	private static final String user="root";
	private static final String pass="jithendra";
	private static Connection conn; 
	private static PreparedStatement pmst;

public static void main(String[] args) {
	try {
		Scanner scr=new Scanner(System.in);
		
		Class.forName(Driver);
//		System.out.println("*");
		conn=DriverManager.getConnection(url, user, pass);
//		System.out.println("*");
		String sql="insert into emp(name,email,password) values(?,?,?)";
//		System.out.println("*");
		pmst=conn.prepareStatement(sql);
//		System.out.println("*");
		System.out.println("Enter Name");
		pmst.setString(1, scr.next());
		System.out.println("Enter Email");
		pmst.setString(2, scr.next());
		System.out.println("Enter Password");
		pmst.setString(3, scr.next());
		
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("data is inserted");
		}
		else {
			System.out.println("error");
		}
		
		pmst.close();
		conn.close();
		scr.close();
	} 
	catch (Exception e) {
    e.printStackTrace();
	}
	
}
}