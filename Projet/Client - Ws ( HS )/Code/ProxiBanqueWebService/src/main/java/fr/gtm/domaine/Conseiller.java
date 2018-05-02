package fr.gtm.domaine;

public class Conseiller {
	
		private int IdConseiller;
		private String nom;
		private String login;
		private String password;

		// Constructeur
		public Conseiller(int idConseiller, String nom, String login, String password) {
			super();
			IdConseiller = idConseiller = 0;
			this.nom = nom = "LeConseiller";
			this.login = login;
			this.password = password;
		}

		public Conseiller(String login, String password) {
			super();
			this.login = login;
			this.password = password;
		}
		public Conseiller() {
			super();
		}

		// getter et setteur

		public int getIdConseiller() {
			return IdConseiller;
		}

		public void setIdConseiller(int idConseiller) {
			IdConseiller = idConseiller;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
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

	}


