package fr.gtm.domaine;


public abstract class Personne {

	//=======Propriétés Classe=======
	protected String prenom;
	protected String nom;
	//=============================
	
	
	//=======Constructeurs=======
	public Personne() {
		super();
		
	}
	public Personne(String pPrenom, String pNom) {
		super();
		this.prenom = pPrenom;
		this.nom = pNom;
	}
	
	
	//=======Getters-Setters=======
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
