package fr.gtm.presentation;

import fr.gtm.domaine.Client;
import fr.gtm.service.ClientService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "clientBean")
public class clientBean {

	// ATTRIBUTS-----------------------------
	private int idClient;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private int idConseiller;

	// CONSTRUCTEUR NO-ARG-----------------------------
	public clientBean() {
		super();
	}

	// GETTERS SETTERS-----------------------------
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	// METHODES-------------------------------------------------------

	public String creerClient() { // TODO modifier le retour

		// instanciation de la couche service
		ClientService clientService = new ClientService();
Client monClient = new Client(0,getNom(),getPrenom(),getAdresse(),getCodePostal(),getVille(),getEmail(),4);
System.out.println(monClient);
		int reponserService = clientService.creerClient(monClient);
		
		// appel à la couche service
		if (reponserService > 0 ) {
			
			return "validation";
		}else
		return "erreur";
	}
}
