package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou classe permettant de se
 *         connecter au serveur mySQL.
 */
public class ConnectionSQL {

	// =============Propriétés Classe=============
	private static String url = "jdbc:mysql://localhost/proxibanquebdd";
	private static String login = "root";
	private static String psw = "root";
	private static Connection cn = null;
	private static Statement st = null;
	// ===========================================

	/**
	 * methode factory pour obtenir un nouveau Logger ou renvoyer le
	 * Logger existant du nom de classe complet - Static 
	 */

	final static Logger logger = Logger.getLogger(ConnectionSQL.class);

	// =============Getters-Setters=============
	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnectionSQL.url = url;
	}

	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		ConnectionSQL.login = login;
	}

	public static String getPsw() {
		return psw;
	}

	public static void setPsw(String psw) {
		ConnectionSQL.psw = psw;
	}

	public static Connection getCn() {
		return cn;
	}

	public static void setCn(Connection cn) {
		ConnectionSQL.cn = cn;
	}

	public static Statement getSt() {
		return st;
	}

	public static void setSt(Statement st) {
		ConnectionSQL.st = st;
	}
	// ===========================================

	// =============Méthode connect=============
	public static Statement connect() {
		PropertyConfigurator.configure(
				"C:\\Users\\Stagiaire\\Desktop\\Proxi Banque V3.2\\proxiBanqueSI\\src\\main\\resources\\log4j.properties");
		try {
			// Chargement des drivers
			Class.forName("com.mysql.jdbc.Driver");

			// Connection au serveur
			cn = DriverManager.getConnection(url, login, psw);
			st = cn.createStatement();
			System.out.println("connection ok !");
			if (logger.isInfoEnabled()) {
				logger.info("Connection ok pour l'utilisateur: " + login);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// équivaut à logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e);
		} catch (SQLException e) {
			e.printStackTrace();
			// équivaut à logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e);
		}
		if (logger.isInfoEnabled()) {
			logger.info("Connection ok pour l'utilisateur: " + login);
		}
		return st;
	}

	// =====================CONNECTION=====================
	public static void getStatement() {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			// équivaut à logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e1);
		}
		Statement monStatement = null;
		try {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquebdd", "root", "");
			monStatement = myCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// équivaut à logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e);
		}
	}

}
