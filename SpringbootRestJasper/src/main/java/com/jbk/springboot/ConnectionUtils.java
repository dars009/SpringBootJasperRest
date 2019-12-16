package com.jbk.springboot;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class ConnectionUtils {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			System.out.println("Connect DB");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
	}
	
	public static void main(String[] args) {
		ConnectionUtils.getConnection();
	}
}
