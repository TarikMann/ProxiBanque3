package fr.gtm.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.gtm.domaine.Client;


public class ClientDAO {
	
	public int createClient(Client client) {

		// 1. CHARGEMENT DRIVER
		// ========================================================================

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

		// 2. CONNEXION
		// ========================================================================

		// emplacement de la base de données : jdbc:mysql://localhost:3306/proxibanquebdd;

		String url = "jdbc:mysql://localhost:3306/proxibanquebdd";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection connexion = null;

		int resultNbChang = 0;

		try {

			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("connexion réussie");

			// 3. CREATION ET LANCEMENT REQUETE
			// ========================================================================

			// Création de l'objet gérant les requêtes et exécution sans possibilité
			// d'injection
//			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO client ( client_nom=?, client_prenom=?, client_adresse=?, client_cdPostal=?,client_ville=?, client_email=?,client_conseiller_id=?);");
			
			
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO `client`( `client_nom`, `client_prenom`, `client_adresse`, `client_cdPostal`, `client_ville`, `client_email`, `client_conseiller_id`) VALUES (?,?,?,?,?,?,?)");

			
			
	
			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
			preparedStatement.setString(3, client.getAdresse());
			preparedStatement.setString(4, client.getCodePostale());
			preparedStatement.setString(5, client.getVille());
			preparedStatement.setString(6, client.getEmail());
			preparedStatement.setInt(7, client.getIdConseiller());
			System.out.println(preparedStatement);

			System.out.println("Ma requette prepareStatement : " + preparedStatement);
			
			resultNbChang = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("connexion échec" + e.getMessage());

			// 6. FERMETURE DE CONNEXION
			// ========================================================================

		} finally {
			if (connexion != null)
				try {
					// fermeture de la connexion
					connexion.close();
				} catch (SQLException ignore) {
					// si une erreur survient lors de la fermeture, il suffit de l'ignorer.
				}
		}
		return resultNbChang;

	}

}
