package fr.gtm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.dao.ClientDAO;
import fr.gtm.dao.CompteBancaireDAO;
import fr.gtm.dao.ConnectionSQL;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 * Classe qui fait le lien entre la classe presention à les class dao compte
 *
 */
public class CompteBancaireService {


	/**
	 * Methode permettant d'obtenir tous les compte client
	 * @return: on retourne la liste de tous les compte de la base de donné
	 */
	public ArrayList<CompteBancaire> getAllComptes() {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList <CompteBancaire>();
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO
		myListComptesReturn = maDAOCompte.getAllComptes();
		
		return myListComptesReturn;
	}


	/**
	 * METHODE permettant d'afficher tous les compte d'un client
	 * @param pClient: un object client
	 * @return la liste des compte du client choisis
	 */
	public ArrayList<CompteBancaire> getComptesClient(Client pClient) {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList <CompteBancaire>();
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO
		myListComptesReturn = maDAOCompte.getComptesClient(pClient);
		
		return myListComptesReturn;
	}
	

//	/**
//	 * Methode qui perm
//	 * @param pCompte
//	 * @return
//	 */
//	public boolean getCompte(CompteBancaire pCompte) {
//		// TODO Auto-generated method stub
//		// DECLARATION DES VARIABLES LOCALES
//		CompteBancaireDAO maRefcompteDAO = new CompteBancaireDAO();
//
//		// appel de la couche DAO
//		return maRefcompteDAO.getCompte(pCompte);
//	}
	// ========================================================
	
}
