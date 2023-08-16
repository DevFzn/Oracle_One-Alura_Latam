package com.alura.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
	
	private final static String driver = "jdbc:mysql://";
	private final static String dbaddr = "192.168.0.8:3306/";
	private final static String params = "?useTimeZone=true&serverTimeZone=UTC";
	private final static String dbname = "control_de_stock";
	private final static String dburl  = driver+dbaddr+dbname+params;
	private final static String dbuser = "alura";
	private final static String dbpass = "alura";
	
	public static void main(String[] args) throws SQLException {
		System.out.println("hola");
		Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
		con.close();
		System.out.println("chao");
	}

}
