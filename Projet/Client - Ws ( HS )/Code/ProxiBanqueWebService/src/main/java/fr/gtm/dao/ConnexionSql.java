package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnexionSql {

	
	private static String url = "jdbc:mysql://localhost/proxibanquebddtres";
	private static String login = "root";
	private static String psw = "root";
	private static Connection cn ;
	private static Statement st ;
	
	
	
	
	//Get And Set
	
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		ConnexionSql.url = url;
	}
	public static String getLogin() {
		return login;
	}
	public static void setLogin(String login) {
		ConnexionSql.login = login;
	}
	public static String getPsw() {
		return psw;
	}
	public static void setPsw(String psw) {
		ConnexionSql.psw = psw;
	}
	
	
	
	public static Statement connect() {
		try {
			//Chargement des drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connection au serveur
			cn = DriverManager.getConnection(url, login, psw);
			st = cn.createStatement();
			System.out.println("connection ok !");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	
	
	
	
	
}
