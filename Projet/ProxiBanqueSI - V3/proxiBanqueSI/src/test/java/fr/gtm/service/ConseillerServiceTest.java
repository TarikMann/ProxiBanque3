package fr.gtm.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import fr.gtm.dao.ConnectionSQL;
import fr.gtm.domaine.Conseiller;
import junit.framework.TestCase;

public class ConseillerServiceTest extends TestCase {

	@BeforeClass
	public void setUp() {
		// connexion à la base de données :
		ConnectionSQL.getCn();
		ConnectionSQL.connect();
		// initialisation des variables et objets
		String login = "Mandela";
		String password = "Nelson";
		Conseiller conseillerTest = new Conseiller(4, "Mandela", "Nelson", "Mandela", "Nelson");
	}

	// =================================================================
	/**
	 * test de la méthode : ConnexionConseillerService() de la classe
	 * ConseillerService
	 */
	// =================================================================

	@Test
	public void testConnexionConseillerService() {

		// TEST EXECUTION
		// ------------------------------------------------------------
//		Conseiller result = ConseillerService.ConnexionConseillerService(login, password);

		// ASSERT STATEMENTS
		// ------------------------------------------------------------
//		Conseiller expected = conseillerTest;
//		assertEquals(expected, result);
	}

	// =================================================================
	
	@AfterClass
	public void tearDown() {
		// TODO connexion de la base de données :
	}
}
