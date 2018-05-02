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

//@ManagedBean(name = "clientbean") // annotation qui permet de donner un nom a un objet (non instancier), nom qui
/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 * Permet de faire le lien avec les informations client demandées et leur affichage dans la vue
 * permet l'affichage et la modification du client
 *
 */

@ManagedBean // peut etre utilisé dans les pages
@SessionScoped

@ViewScoped
public class ClientBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Client> maListClient;
	private List<CompteBancaire> maListCompte;
	private List<CompteBancaire> maListCompteCrediteur;
	private String selectedClient;
	private Client monNewClient;

	
	public ClientBean() {
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

	/**
	 * Initialisation des attributs
	 * 
	 */
	@PostConstruct
	public void init() {
		Conseiller monConseiller = new Conseiller();
		monConseiller = (Conseiller) sessionMap.get("monConseiller");
		// List<Client> maListClient = new ArrayList<Client>();
		ClientService monClientService = new ClientService();
		CompteBancaireService monCompteService = new CompteBancaireService();
		maListClient = monClientService.getCLientsConseiller(monConseiller);
		maListCompte = monCompteService.getAllComptes();
		
		sessionMap.put("maListTousCompte", maListCompte);
		System.out.println("BeanClient : " + maListClient);
		System.out.println("BeanComptes : " + maListCompte);
		System.out.println("BenConseiller: " + monConseiller.getNom());

		monNewClient = new Client();
		System.out.println("Init : " + monNewClient);

	}

	// mettre en session
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	/**
	 * methode qui permet de recuperer les informations du client
	 * @param aucun
	 * @return: retour d'un object pour l'affichage en vue
	 * 
	 */
	public Object selectClient() {

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String valRecup = params.get("action");
		System.out.println(valRecup);
		ClientService monClientService = new ClientService();
		CompteBancaireService monCompteService = new CompteBancaireService();
		monNewClient = monClientService.getClient(valRecup);
		maListCompte = monCompteService.getComptesClient(monNewClient);
		System.out.println(monNewClient);
		sessionMap.put("monObjet", monNewClient);
		sessionMap.put("maListCompte", maListCompte);
		System.out.println(maListClient);
		// ClientService monClientService = new ClientService();
		// boolean reponseDelete = monClientService.deleteClient(monClient);
		return "AfficherClient.xhtml?faces-redirect=true";
	}

	 /**
	  * méthode qui modifie les informations client
	 * @param objet leClient 
	 * @return  object pour affichage en vue
	 */
	public Object updateLeClient(Client leClient) {
		 System.out.println("MonClienUpdate" + leClient);
			ClientService monClientService = new ClientService();
			Boolean monNewClient = monClientService.updateClient(leClient);
		 if(monNewClient == true) {
			 
//			  FacesContext context = FacesContext.getCurrentInstance();
//	            context.addMessage("username", new FacesMessage("Modification OK"));
			 return "ListClient.xhtml?faces-redirect=true";
		 }else {
//			  FacesContext context = FacesContext.getCurrentInstance();
//	            context.addMessage("username", new FacesMessage("Erreur de modification"));
			 return "erreur.xhtml?faces-redirect=true";
		 }
		 
		 
			
	//
	// System.out.println(valRecup);
	// ClientService monClientService = new ClientService();
	// monNewClient = monClientService.getClient(valRecup);
	// System.out.println(monNewClient);
	//
	// sessionMap.put("monObjet", monNewClient);

	// ClientService monClientService = new ClientService();
	// boolean reponseDelete = monClientService.deleteClient(monClient);
	// return "AfficherClient.xhtml?faces-redirect=true";
	}

	/**
	 * methode pour supprimer un client
	 * @param monClient objet client 
	 * @return la liste des clients mise à jour 
	 */
	public Object deleteClient(Client monClient) {
		System.out.println(monClient.toString());
		ClientService monClientService = new ClientService();
		boolean reponseDelete = monClientService.deleteClient(monClient);
		if (reponseDelete == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("username", new FacesMessage("Client Supprimer"));

			return "ListCLient";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("username", new FacesMessage("Erreur de Suppression du client"));
			return "ListCLient";
		}
	}
}
