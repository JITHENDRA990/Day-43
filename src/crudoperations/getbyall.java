package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getbyall {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "jithendra";
	private static final String url = "jdbc:mysql://localhost:3306/student";
	private static  Connection coon;
	private static  PreparedStatement pmst;
public static void main(String[] args) {
		try {

			Scanner scr = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter tablename");
			String sql = "select * from " + scr.next();
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("name : " + rs.getString("name"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("password : " + rs.getString("password"));
			}
			coon.close();
			pmst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
