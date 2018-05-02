package fr.gtm.domaine;

public class Conseiller {

	private int idConseiller;
	private String nom;
	private String Login;
	private String password;

	// constructeur

	public Conseiller(int idConseiller, String nom, String login, String password) {
		super();
		this.idConseiller = idConseiller;
		this.nom = nom;
		Login = login;
		this.password = password;
	}

	public Conseiller() {
		super();
	}

	// getteur et setteur
	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
