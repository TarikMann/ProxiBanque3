README.TXT
======================================================================================
Bienvenue dans les instructions d'installation de votre solution web Proxibanque 3.0
Afin de déployer et de profiter au maximum de Proxibanque 3.0, merci de suivre les indications de ce readme.

Pré-requis de configuration
--------------------------------------------------------------------------------------
- JDK 9 installé sur la machine cible
	Téléchargé depuis: http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Serveur d'application web : tomcat 9.0 
- Serveur WAMP 3.0.4 installé (avec serveur de gestion de base de données : MySql)
- Importer la base de données proxibanquebdd.sql sur PhPMyAdmin 
- Eclipse paramétré sur la JDK 9.0.4
- Maven installé 

Execution sur le serveur d'applications Tomcat
--------------------------------------------------------------------------------------
- lancer le serveur d'applications web en double-cliquant le fichier "startup.bat" du répertoire "bin" d'installation.
- démarrer votre serveur de base de données WAMP en double-cliquant sur le fichier "wampmanager.exe" du répertoire d'installation de votre serveur WAMP.
- dans le dossier < 'proxibanqueWebapp/target/' > , copier le fichier < 'proxibanqueWebapp.war' > < nécessaire ? >
- copier le fichier < proxibanqueWebapp.war > dans le dossier 'webapps' du répertoire d'installation  du serveur tomcat.
- s'assurer que le fichier < proxibanqueSI.war > est bien décompressé dans un répertoire proxibanqueWebapp.
- Ouvrir un Navigateur Web et entrer < localhost:8080/proxibanqueWebapp > dans la barre d'adresse.


Gestion des log générés via le framework Log4j
-------------------------------------------------------------------------------------
- dans le dossier src/main/ressources:
		>>> à la ligne à la suite de "log4j.appender.file.File=" , entrer le chemin d'accès suivant : "trace.log"
		Dans le fichier src/main/java/fr.gtm.dao/connexionSQL.java : changer le chemin d'accès au log4j.properties sur la ligne de code 
			
			changer la ligne suvante : PropertyConfigurator.configure("C:\\Users\\Stagiaire\\Desktop\\Proxi Banque V3.2\\proxiBanqueSI\\src\\main\\resources\\log4j.properties");
			Pour avoir le lien d'acces au fichier log4j.properties de votre ordinateur.
		
Copyright and licensing information
--------------------------------------------------------------------------------------
- les droits de l'application web livrée < "ProxibanqueV2" > sont détenus par :
		Inès HEDI
		Tarik MANNOU
		Mathieu TRICOIRE
- utilisation exclusivement réservée à la société fictive Proxibanque.

Contact information
--------------------------------------------------------------------------------------
- contacter la société fictive GTM Etudiants pour support.