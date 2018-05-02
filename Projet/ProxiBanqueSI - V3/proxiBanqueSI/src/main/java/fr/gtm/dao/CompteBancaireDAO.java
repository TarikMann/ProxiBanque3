package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;
import fr.gtm.domaine.Conseiller;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 *
 */
public class CompteBancaireDAO {
	
	// ======================Propriétés Classe=====================
	private ResultSet rs = null;
	private static String typeCompteEpargne = "Epargne";
	private static String typeCompteCourant = "Courant";
	//============================================================
	
	final static Logger logger = Logger.getLogger(CompteBancaireDAO.class);

	// /**
	// * @param pLibelle: un type de compte
	// * @return: un entier
	// */
	// public int getidTypeCompte(String pLibelle) {
	//
	// // VARIABLES LOCALES
	// int typeCompteid = 0;
	//
	// 
	// // Initialisation de la connection
	// ConnectionSQL.connect();
	// // Requete pour récupérer la clé type_Compte de la table typecompte de la
	// bdd.
	// String sql = "Select typeCompte_id from typecompte where typeCompte_libelle
	// ='" + pLibelle + "'";
	// // + " ";
	// try {
	// // On envoie la requete a la base de données
	// this.rs = ConnectionSQL.getSt().executeQuery(sql);
	// // Om met le curseur sur la première ligne des données
	// this.rs.first();
	// // Affectation des propriétés de l'objet client
	// typeCompteid = this.rs.getInt("typeCompte_id");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return typeCompteid;
	// }// ========================================================

	/**
	 * @param aucun
	 * @return liste des comptes client
	 */
	public ArrayList<CompteBancaire> getAllComptes() {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList<CompteBancaire>();


		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		String sql = "SELECT * FROM compte INNER JOIN typecompte WHERE compte.compte_typeCompte_id = typecompte.typeCompte_id ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				if (this.rs.getString("typeCompte_libelle").equals(typeCompteEpargne)) {
					CompteEpargne compteReturn = new CompteEpargne();
					compteReturn.setTypeCompte(typeCompteEpargne);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					if(logger.isInfoEnabled()){
						logger.info("Connection ok pour l'utilisateur ");
					}
					myListComptesReturn.add(compteReturn);
				} else {
					CompteCourant compteReturn = new CompteCourant();
					compteReturn.setTypeCompte(typeCompteCourant);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					if(logger.isInfoEnabled()){
						logger.info("Connection ok pour l'utilisateur");
					}
					myListComptesReturn.add(compteReturn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.fatal("Une exception est survenue" ,e);
		}
		return myListComptesReturn;
	} // =========================================================================================

	/**
	 * @param pClient objet de type client 
	 * @return liste des comptes bancairse du client
	 */
	public ArrayList<CompteBancaire> getComptesClient(Client pClient) {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList<CompteBancaire>();

		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		String sql = "SELECT * FROM compte INNER JOIN typecompte WHERE compte.compte_typeCompte_id = typecompte.typeCompte_id AND compte_client_id = "
				+ pClient.getId() + " ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				if (this.rs.getString("typeCompte_libelle").equals(typeCompteEpargne)) {
					CompteEpargne compteReturn = new CompteEpargne();
					compteReturn.setTypeCompte(typeCompteEpargne);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					if(logger.isInfoEnabled()){
						logger.info("Connection ok pour l'utilisateur");
					}
					myListComptesReturn.add(compteReturn);
				} else {
					CompteCourant compteReturn = new CompteCourant();
					compteReturn.setTypeCompte(typeCompteCourant);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					if(logger.isInfoEnabled()){
						logger.info("Connection ok pour l'utilisateur");
					}
					myListComptesReturn.add(compteReturn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.fatal("Une exception est survenue" ,e);
		}
		return myListComptesReturn;
	}// ========================================================

	// ================= Méthodes get Compte===================
	/**
	 * Methode permettant de recupérer les informations d'un compte (épargne
	 *         ou courant) à partir de son id.
	 * @param pCompte compte dont on souhaite obtenir les information (contient l'id
	 *            du compte)
	 * @return boolean 
	 * si la requete en bdd ne retourne pas d'exception, false sinon.
	 * 
	 */
	public boolean getCompte(CompteBancaire pCompte) {

		// DECLARATION DES VARIABLES

		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		// creation de la requete
		String sql = "SELECT * FROM compte WHERE compte_id = " + pCompte.getIdCompte() + " ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			// Om met le curseur sur la première ligne des données
			this.rs.first();
			// Affectation des propriétés de l'objet client
			pCompte.setNumCompte(this.rs.getString("compte_numCompte"));
			pCompte.setSoldeCompte(this.rs.getInt("compte_solde"));
			pCompte.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
			pCompte.setIdClient(this.rs.getInt("compte_client_id"));
			if(logger.isInfoEnabled()){
				logger.info("Connection ok pour l'utilisateur");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.fatal("Une exception est survenue" ,e);
		}
		return false;
	}// ========================================================

}
