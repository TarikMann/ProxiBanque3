package fr.gtm.presentation;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ConseillerService;

/**
 * @author Hedi Ines, Mathieu Tricoire, Tarik Mannou
 * permet la communicationn  entre le front et le back
 *
 */
@ManagedBean(name = "conseillerbean") // annotation qui permet de donner un nom a un objet (non instancier), nom qui
										// peut etre utiliser dans les pages
@SessionScoped
public class ConseillerBean {
	
	private String login;
	private String password;
	// Constructeur

	public ConseillerBean() {
		super();
	}

	public ConseillerBean(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	// Get and Set

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

	// mettre en session
	/**
	 * mise en session des informations du conseiller
	 */
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	
	/**
	 * Methode qui permet l'authentification du conseiller
	 * @param aucun
	 * @return: retour d'un object
	 */
	public Object ConnexionBean() {
		
		ConseillerService monConseillerService = new ConseillerService();
		Conseiller monConseiller = new Conseiller() ;;
		monConseiller = monConseillerService.ConnexionConseillerService(getLogin(), getPassword());
		System.out.println("Bean : "+ monConseiller);
		System.out.println("Login : "+getLogin() + "  >>  " + monConseiller.getLogin());
		System.out.println("MDP :  "+getPassword() + "  >>  " + monConseiller.getPassword());
		
		sessionMap.put("monConseiller", monConseiller);
		
		 if(getLogin().equalsIgnoreCase(monConseiller.getLogin()) && getPassword().equals(monConseiller.getPassword()))
	        {
	            return "ListClient.xhtml?faces-redirect=true";
	        }
	        else
	        {
	            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("username", new FacesMessage("Invalid UserName and Password"));
	            return "login";
	        }
		
		
		
	
	}

}
