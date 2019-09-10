# Projet_6
Créez un site communautaire autour de l’escalade

utilisation de java/jee 8, postgreSQL 9.*, Apache Tomcat 9, Apache Maven. 

la base de donnee :
le backup présent dans le dossier \Projet_6\script ayant le nom ocscalade.backup est sous format tar utilisable avec pgadmin ou pg restore.
creer un role dans postgreSQL au nom de : admin_oscalade
avec pour mot de passe : admin
Si vous souhaitez un autre role et mot de passe, vous pouvez le changer dans le fichier context.xml

pour les fichiers images :
creer un dossier avec le path suivant : c:/tmp
changer dans ocscalade/ocscalade-webapp/src/main/java/fr/banane/projet6/webapp/technical/Static la ligne 19 pour prendre en compte le path sur votre serveur.