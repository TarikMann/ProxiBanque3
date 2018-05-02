package fr.gtm.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.gtm.dao.ConseillerDao;
import fr.gtm.domaine.Conseiller;

@Path("/Authentification")
public class AuthentificationConseiller {

	@GET
	@Path("/it")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Conseiller getTrackInJSON() {
		System.out.println("testtest");
		Conseiller monConseillerTest = new Conseiller();

		monConseillerTest.setIdConseiller(5);
		monConseillerTest.setLogin("Bob");
		monConseillerTest.setNom("bob");
		monConseillerTest.setPassword("bab");
		System.out.println(monConseillerTest.getLogin());
		return monConseillerTest;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Conseiller monConseiller) {

		monConseiller = new Conseiller(2, "tarik", "tarik", "mannou");
		System.out.println(monConseiller.getLogin());

		ConseillerDao monConseillerDao = new ConseillerDao();

		boolean ResultRequete = monConseillerDao.conseillerConnexion(monConseiller);
		String result = "ok " + ResultRequete;
		System.out.println(ResultRequete);

		String resultat = "Track saved : " + monConseiller;
		System.out.println(resultat);
		return Response.status(201).entity(result).build();

	}

}
