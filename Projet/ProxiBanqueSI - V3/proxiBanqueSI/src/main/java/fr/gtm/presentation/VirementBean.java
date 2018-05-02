package fr.gtm.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.CompteBancaireService;
import fr.gtm.service.ConseillerService;

/**
 *@author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 * Permet de gérer les entrées formulaire du virement via un bean
 */

//@ManagedBean(name = "clientbean") // annotation qui permet de donner un nom a un objet (non instancier), nom qui

@ManagedBean // peut etre utiliser dans les pages
@SessionScoped

@ViewScoped
public class VirementBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Client> maListClient;
	private List<CompteBancaire> maListCompte;
	private List<CompteBancaire> maListCompteCrediteur;
	private String selectedClient;
	private Client monNewClient;
	private float valSomme;

	public VirementBean() {
		super();
	}

	public List<CompteBancaire> getMaListCompte() {
		return maListCompte;
	}

	public void setMaListCompte(List<CompteBancaire> maListCompte) {
		this.maListCompte = maListCompte;
	}

	public String getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(String selectedClient) {
		this.selectedClient = selectedClient;
	}

	public List<Client> getMaListClient() {
		return maListClient;
	}

	public void setMaListClient(List<Client> maListClient) {
		this.maListClient = maListClient;
	}

	public Client getMonClient() {
		return monNewClient;
	}

	public void setMonClient(Client monNewClient) {
		this.monNewClient = monNewClient;
	}

	public List<CompteBancaire> getMaListCompteCrediteur() {
		return maListCompteCrediteur;
	}

	public void setMaListCompteCrediteur(List<CompteBancaire> maListCompteCrediteur) {
		this.maListCompteCrediteur = maListCompteCrediteur;
	}

	public float getValSomme() {
		return valSomme;
	}

	public void setValSomme(float valSomme) {
		this.valSomme = valSomme;
	}

	/**
	 *  Initialisation des attributs
	 */
	@PostConstruct
	public void init() {
		Conseiller monConseiller = new Conseiller();

		// List<Client> maListClient = new ArrayList<Client>();
		ClientService monClientService = new ClientService();
		CompteBancaireService monCompteService = new CompteBancaireService();
		maListClient = monClientService.getCLientsConseiller(monConseiller);
		maListCompte = monCompteService.getAllComptes();

		System.out.println("BeanClient : " + maListClient);
		System.out.println("BeanComptes : " + maListCompte);
		System.out.println("BenConseiller: " + monConseiller.getNom());

		monNewClient = new Client();
		System.out.println("Init : " + monNewClient);

	}

	/**
	 * @param a String montant du virement 
	 * @param b String numéro de compte créditeur
	 * @param c String numéro de compte débiteur
	 * @return affichage d'une vue
	 */
	public Object virement(String a, String b, String c) {
		System.out.println(a + b + c);
		// ClientService monClientService = new ClientService();
		// boolean reponseDelete = monClientService.deleteClient(monClient);
		return "AfficherClient.xhtml?faces-redirect=true";
	}

}
