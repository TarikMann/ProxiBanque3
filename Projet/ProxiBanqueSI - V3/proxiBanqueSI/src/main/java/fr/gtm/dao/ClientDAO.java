package fr.gtm.dao;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.log4j.Logger;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou classe permettant l'acces a
 *         la Dao par la methode du CRUD
 */
public class ClientDAO {

	final static Logger logger = Logger.getLogger(ClientDAO.class);

	private ResultSet rs = null;

	/**
	 * methode permettant l'affichage la liste des clients du conseiller
	 * 
	 * @param monConseiller
	 *            : objet contenant les informations du conseiller souhaitant la
	 *            liste de ces client
	 * @return :la liste des clients
	 */
	public List<Client> getAllCLients(Conseiller monConseiller) {

		// DECLARATION DES VARIABLES LOCALES
		List<Client> maListClient = new ArrayList<Client>();

		// Initialisation de la connection + declaration
		ConnectionSQL.connect();

		// creation de la requete
		String sql = "SELECT * FROM client WHERE client_conseiller_id = " + monConseiller.getId() + "";
		try {
			// On envoit la requete a la base de donn�es et on r�cup�re le resultat
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				Client monClient = new Client();
				// Affectation des propri�t�s de l'objet client
				monClient.setId(this.rs.getInt("client_id"));
				monClient.setPrenom(this.rs.getString("client_prenom"));
				monClient.setNom(this.rs.getString("client_nom"));
				monClient.setAdresse(this.rs.getString("client_adresse"));
				monClient.setCdPostal(this.rs.getString("client_cdPostal"));
				monClient.setVille(this.rs.getString("client_ville"));
				monClient.setEmail(this.rs.getString("client_email"));
				monClient.setIdConseiller(this.rs.getInt("client_conseiller_id"));
				System.out.println("BenClient : " + monClient);
				maListClient.add(monClient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �quivaut � logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e);
		}
		System.out.println("DAO : " + maListClient);
		if (logger.isInfoEnabled()) {
			logger.info("Connection ok pour l'utilisateur ");
		}
		return maListClient;
	}

	/**
	 * methode permettant l'affichage des informations d'un des client du conseiller
	 * 
	 * @param pClient
	 *            : objet client
	 * @return : integralit� des informations d'un client
	 */

	public Client getClient(String pClient) {

		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		String sql = "SELECT * FROM client WHERE client_id = " + pClient + " ";
		try {

			Client leClientRecupererDeLaBdd = new Client();
			// On envoie la requete a la base de donn�es
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			// Om met le curseur sur la premi�re ligne des donn�es
			this.rs.first();
			// Affectation des propri�t�s de l'objet client
			leClientRecupererDeLaBdd.setId(this.rs.getInt("client_id"));
			leClientRecupererDeLaBdd.setNom(this.rs.getString("client_nom"));
			leClientRecupererDeLaBdd.setPrenom(this.rs.getString("client_prenom"));
			leClientRecupererDeLaBdd.setAdresse(this.rs.getString("client_adresse"));
			leClientRecupererDeLaBdd.setCdPostal(this.rs.getString("client_cdPostal"));
			leClientRecupererDeLaBdd.setVille(this.rs.getString("client_ville"));
			leClientRecupererDeLaBdd.setEmail(this.rs.getString("client_email"));
			leClientRecupererDeLaBdd.setIdConseiller(this.rs.getInt("client_conseiller_id"));
			if (logger.isInfoEnabled()) {
				logger.info("Connection ok pour l'utilisateur ");
			}
			return leClientRecupererDeLaBdd;
		} catch (SQLException e) {
			e.printStackTrace();
			// �quivaut � logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e);
		}
		if (logger.isInfoEnabled()) {
			logger.info("Connection ok pour l'utilisateur ");
		}
		return null;
	}

	/**
	 * methode permettant la mise � jour d'un client
	 * 
	 * @param pClient
	 *            : objet client
	 * @return : mise � jour effectu�e
	 */
	public boolean updateClient(Client pClient) {
		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = "update client set client_nom = '" + pClient.getNom() + "', client_prenom = '"
				+ pClient.getPrenom() + "',client_adresse = '" + pClient.getAdresse() + "', client_cdPostal = '"
				+ pClient.getCdPostal() + "', client_ville = '" + pClient.getVille() + "', client_email = '"
				+ pClient.getEmail() + "' where client_id = " + pClient.getId() + " ";
		try {
			// On envoie la requete a la base de donn�es
			int iInsert = ConnectionSQL.getSt().executeUpdate(sql);
			if (logger.isInfoEnabled()) {
				logger.info("Connection ok pour l'utilisateur ");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			// �quivaut � logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e);
		}
		if (logger.isInfoEnabled()) {
			logger.info("Connection ok pour l'utilisateur ");
		}
		return false;
	}

	/**
	 * methode permettant la supression d'un client
	 * 
	 * @param pClient
	 *            : objet client
	 * @return : boolean
	 */
	public boolean deleteClient(Client pClient) {

		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = "delete from client where client_id = " + pClient.getId();
		try {
			// On envoie la requete a la base de donn�es
			ConnectionSQL.getSt().executeUpdate(sql);
			if (logger.isInfoEnabled()) {
				logger.info("Connection ok pour l'utilisateur ");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			// �quivaut � logger.log(Level.FATAL, "Une exception est survenue", e);
			logger.fatal("Une exception est survenue", e);
		}
		if (logger.isInfoEnabled()) {
			logger.info("Connection ok pour l'utilisateur ");
		}
		return false;
	}
}
