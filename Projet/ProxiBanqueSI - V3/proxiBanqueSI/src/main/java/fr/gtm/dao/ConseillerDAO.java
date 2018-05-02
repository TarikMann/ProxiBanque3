package fr.gtm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 * permet de se connecter au informations du conseiller de la base de donnée 
 */
public class ConseillerDAO {

	private ResultSet rs = null;

	final static Logger logger = Logger.getLogger(ConseillerDAO.class);
	
	/** 
	 * methode qui récupère le login et le mot de passe du conseiller
	 * @param pLogin valeur de login entré par l'utilisateur
	 * @param pPassword valeur de password entré par l'utilisateur
	 * @return on renvoit un objet conseiller qui contient les informations du conseiller
	 */
	public Conseiller ConseillerConseillerConnexion(String pLogin, String pPassword) {

		// Declaration des variables locales
		Conseiller conseillerReturn = new Conseiller();

		
		
		// Initialisation de la connection
		Statement st = null;

		st = ConnectionSQL.connect();
		
		// creation de la requete
		String sql = "Select * from conseiller where conseiller_login = '" + pLogin + "' AND conseiller_password = '"
				+ pPassword + "'";
		try {
			// On envoie la requete a la base de données
			this.rs = st.executeQuery(sql);
			// Om met le curseur sur la première ligne des données
			this.rs.first();
			// Affectation des propriétés de l'objet client
			conseillerReturn.setId(this.rs.getInt("conseiller_id"));
			conseillerReturn.setNom(this.rs.getString("conseiller_nom"));
			conseillerReturn.setPrenom(this.rs.getString("conseiller_prenom"));
			conseillerReturn.setLogin(this.rs.getString("conseiller_login"));
			conseillerReturn.setPassword(this.rs.getString("conseiller_password"));
			System.out.println("DAO : "+conseillerReturn);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.fatal("Une exception est survenue"+ conseillerReturn ,e);
		}
		if(logger.isInfoEnabled()){
			logger.info("Connection ok pour l'utilisateur: " + conseillerReturn);
		}
		return conseillerReturn;
	}
	// ========================================================



}
