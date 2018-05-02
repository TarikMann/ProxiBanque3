package fr.gtm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.domaine.Conseiller;

public class ConseillerDao {

	private ResultSet rs;

	public boolean conseillerConnexion(Conseiller monConseiller) {


		Conseiller conseillerReturn = new Conseiller();
		Statement monStatement =  ConnexionSql.connect();
		
		String sql = "Select * from conseiller where conseiller_login = '" + monConseiller.getLogin() + "' AND conseiller_password = '"
				+ monConseiller.getPassword() + "'";
		try {
			// On envoie la requete a la base de données
			this.rs = monStatement.executeQuery(sql);
			// Om met le curseur sur la première ligne des données
			this.rs.first();
			// Affectation des propriétés de l'objet client
			conseillerReturn.setIdConseiller(this.rs.getInt("conseiller_id"));
			conseillerReturn.setNom(this.rs.getString("conseiller_nom"));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	
	}

}
