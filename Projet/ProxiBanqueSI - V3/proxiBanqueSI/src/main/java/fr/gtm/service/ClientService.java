package fr.gtm.service;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.dao.ClientDAO;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.Conseiller;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 * classe qui fait le loen antre la presentation et la classe dao
 *
 */
public class ClientService {

	/**
	 * @param monConseiller: object conseiller
	 * @return une liste de client par rapport à l'id du conseiller
	 */
	public List<Client> getCLientsConseiller(Conseiller monConseiller) {

		// DECLARATION DES VARIABLES LOCALES
		List<Client> maListClient = new ArrayList<Client>();
		ClientDAO maRefclientDAO = new ClientDAO();
		int monIdConseiller = 4;
		// Appel de la couche DAO
		maListClient = maRefclientDAO.getAllCLients(monConseiller);
		System.out.println("ServiceClient : " + maListClient);
		return maListClient;
	}

	/**
	 * @param pClient : object client qui correspond au client dont on veux recuperer les information
	 * @return : retourne un object client demandeer
	 */
	public Client getClient(String pClient) {
		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefclientDAO = new ClientDAO();

		// appel de la couche DAO
		return maRefclientDAO.getClient(pClient);
	}

	/**
	 * @param pClient: un object client qui contient les information à modifier pour le client
	 * @return : une confirmation ou non de la modification
	 */
	public boolean updateClient(Client pClient) {
		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefclientDAO = new ClientDAO();

		// appel de la couche DAO
		return maRefclientDAO.updateClient(pClient);
	}

	/**
	 * @param pClient: object client qui contient les information du client à supprimer
	 * @return: une confirmation ou non de la suppression
	 */
	public boolean deleteClient(Client pClient) {
		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefclientDAO = new ClientDAO();

		return maRefclientDAO.deleteClient(pClient);

	}
}
