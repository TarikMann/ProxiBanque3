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
@ManagedBean // peut etre utiliser dans les pages
@SessionScoped

@ViewScoped
public class CompteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<CompteBancaire> maListCompte;
	private String selectedClient;
	private Client monNewClient;

	public CompteBean() {
		super();
	}

	public String getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(String selectedClient) {
		this.selectedClient = selectedClient;
	}

	

	public List<CompteBancaire> getMaListCompte() {
		return maListCompte;
	}

	public void setMaListCompte(List<CompteBancaire> maListCompte) {
		this.maListCompte = maListCompte;
	}

	public Client getMonClient() {
		return monNewClient;
	}

	public void setMonClient(Client monNewClient) {
		this.monNewClient = monNewClient;
	}

	@PostConstruct
	public void init() {
		Client monClient = new Client();
		monClient = (Client) sessionMap.get("monObjet");
		System.out.println(monClient);
		// List<Client> maListClient = new ArrayList<Client>();
		CompteBancaireService monCompteService = new CompteBancaireService();
		maListCompte = monCompteService.getComptesClient(monClient);
		System.out.println("BeanClient : " + maListCompte);
	

		monNewClient = new Client();
		System.out.println("Init : " + monNewClient);

	}

	// mettre en session
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

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

		// ClientService monClientService = new ClientService();
		// boolean reponseDelete = monClientService.deleteClient(monClient);
		return "AfficherCompte.xhtml?faces-redirect=true";
	}

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
