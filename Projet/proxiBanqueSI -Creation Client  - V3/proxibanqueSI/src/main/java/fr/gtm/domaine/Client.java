package fr.gtm.domaine;

/**
 * @author Stagiaire
 *
 */
public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String codePostale;
	private String ville;
	private int idConseiller;


	// constructeur

	public Client(int idClient, String nom, String prenom, String email, String adresse, String codePostale,
			String ville, int idConseiller) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codePostale = codePostale;
		this.ville = ville;
		this.idConseiller= idConseiller;
	}

	public Client() {
		super();
	}

	// getteru et setteur

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		idClient = idClient;
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

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
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

	@Override
	public String toString() {
	return "mon client"+ getNom() + " "+ getPrenom();
	}

	
}
