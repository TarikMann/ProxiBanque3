package fr.gtm.domaine;

/**
 * @author Mehdi-Tarik Classe correspondant aux clients de la banque.
 */
public class Client extends Personne {

	// Attribut
	private int id;
	private String adresse;
	private String cdPostal;
	private String ville;
	private String email;
	private int idConseiller;

	// Constructeurs

	public Client() {

	}

	public Client(int id, String pPrenom, String pNom, String adresse, String cdPostal, String ville, String email,
			int idConseiller) {
		super(pPrenom, pNom);
		this.id = id;
		this.adresse = adresse;
		this.cdPostal = cdPostal;
		this.ville = ville;
		this.email = email;
		this.idConseiller = idConseiller;
	}

	public Client(String pPrenom, String pNom) {
		super(pPrenom, pNom);
		// TODO Auto-generated constructor stub
	}

	// get and Set

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCdPostal() {
		return cdPostal;
	}

	public void setCdPostal(String cdPostal) {
		this.cdPostal = cdPostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String toString() {
		return "CLient [ id : "+this.getId() + " prenom : " + this.getPrenom() + "--" + "nom :" + this.getNom() + "]";
	}
	// =============================
}
