package fr.gtm.ProxiBanqueWebService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.gtm.dao.ConseillerDao;
import fr.gtm.domaine.Conseiller;

@Path("/proxiBanque")
public class MyResource {

	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Conseiller monConseiller) {
		System.out.println("je suis la");

		System.out.println(monConseiller.getLogin());

		ConseillerDao monConseillerDao = new ConseillerDao();

		boolean ResultRequete = monConseillerDao.conseillerConnexion(monConseiller);
		String result = "ok " + ResultRequete;
		System.out.println(ResultRequete);

		String resultat = "Track saved : " + monConseiller;
		System.out.println(resultat);
		return Response.status(201).entity(resultat).build();

	}
}
