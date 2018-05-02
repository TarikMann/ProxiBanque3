package fr.gtm.domaine;

public class Conseiller extends Personne {

	// Propriétés Classe

	private int id;
	String login;
	String password;

	// =======constructeur=======
	public Conseiller() {
		super();

	}

	//Get and

	

	public Conseiller(int id, String nom,String prenom, String login, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// =======ToString method=======
	public String toString() {
		return "Conseiller [ id : " + this.getId() + "--" + " prenom : " + this.getPrenom() + "--" + "nom :" + this.getNom()
				+ "]";
	}
	// =============================
}
