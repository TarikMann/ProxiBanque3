package fr.gtm.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.dao.ConnectionSQL;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;
import junit.framework.TestCase;

public class ClientServiceTest extends TestCase {

	@BeforeClass
	public void setUp() {
		// connexion à la base de données :
		ConnectionSQL.getCn();
		ConnectionSQL.connect();
		// une série de clients test :
		Client clientTest1 = new Client();
		Client clientTest2 = new Client();
		Client clientTest3 = new Client();
		// TODO un conseiller test :
		Conseiller conseillerTest1 = new Conseiller();
		// TODO creer la liste de clients vide :
		List<Client> listeClientTest1 = new ArrayList<Client>();
		// TODO integrer les clients test crees a la liste attendue (expected) :
		listeClientTest1.add(clientTest1);
		listeClientTest1.add(clientTest2);
		listeClientTest1.add(clientTest3);
	}

	// =================================================================
	/**
	 * test de la méthode : getCLientsConseiller() de la classe ClientService
	 */
	// =================================================================

	@Test
	public void testGetCLientsConseiller() {
		// TEST EXECUTION
		// ------------------------------------------------------------
//		Conseiller result1 = ClientService.getCLientsConseiller(conseiller1);
		// ASSERT STATEMENTS
		// ------------------------------------------------------------
//		List<Client> expected = listeClientTest1;
//		assertEquals(expected, result1);
	}

	// =================================================================
	/**
	 * test de la méthode : getClient() de la classe ClientService
	 */
	// =================================================================

	@Test
	public void testGetClient() {
		// TEST EXECUTION
		// ------------------------------------------------------------
//		Client result2 = ClientService.getClient(client1);
		// ASSERT STATEMENTS
		// ------------------------------------------------------------
//		Client expected = client1;
//		assertEquals(expected, result2);
	}

	// =================================================================
	/**
	 * test de la méthode : deleteClient() de la classe ClientService
	 */
	// =================================================================

	@Test
	public void testDeleteClient() {

		// TEST EXECUTION
		// ------------------------------------------------------------
//		Client result3 = ClientService.deleteClient(client1);
		// ASSERT STATEMENTS
		// ------------------------------------------------------------
//		Client expected = client1;
//		assertEquals(expected, result3);
	}

	// =================================================================
	
	@AfterClass
	public void tearDown() {
		// TODO deconnexion de la base de données :
	}
}
