package fr.gtm.service;

import fr.gtm.dao.ClientDAO;
import fr.gtm.domaine.Client;

public class ClientService {

	public int creerClient(Client client) {

		// instanciation de la couche DAO
		ClientDAO clientDao = new ClientDAO();
		// appel à la méthode create()couche dao
		return clientDao.createClient(client);
	}
}
