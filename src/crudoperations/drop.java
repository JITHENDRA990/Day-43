package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class drop {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String username="root";
	private static final String password="jithendra";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		try {Scanner scr=new Scanner(System.in);
		Class.forName(Driver);
		System.out.println("*");

		conn = DriverManager.getConnection(url,username,password);
		System.out.println("*");

		System.out.println("enter database name");
		String sql = "drop"+scr.next();
		pmst = conn.prepareStatement(sql);
		int i=pmst.executeUpdate();
		System.out.println("*");

		if(i>0) {
			System.out.println("successfully deleted");
		}
		else {
			System.out.println("error");
		}
		conn.close();
		pmst.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
