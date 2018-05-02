package fr.gtm.service;

import fr.gtm.dao.ConseillerDAO;
import fr.gtm.domaine.Conseiller;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 * classe qui permet de faire le lien entre les la classe conseiller dao et conseiller presentation
 *
 */
public class ConseillerService {

	/**
	 * Methode qui permet de faire le lien entre la classe conseiller dao et la classe presentation conseiller
	 * @param Login : le login ecrit par l'utilisateur 
	 * @param Password : le mot de passe ecrit par l'utilisateur
	 * @return : un object conseiller 
	 */
	public Conseiller ConnexionConseillerService(String Login, String Password ) {

		//Declaration des variables locales
		Conseiller monConseiller = new Conseiller() ;
		ConseillerDAO monConseillerDAO = new ConseillerDAO();
		
		//Appel de la couche DAO
		monConseiller = monConseillerDAO.ConseillerConseillerConnexion(Login, Password);
		System.out.println("Service : " + monConseiller);
		return monConseiller;
		
		
	}

	
	
}
