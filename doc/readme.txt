CONFIGURATION du PROJET

Configuration sous Intellij
1) Pour le serveur
File -> New -> Project from Version Control -> Git 
url: https://github.com/korolchuk/ModuleSignatureClients.git
choisir un répertoire où mettre le code du serveur.

Il faut démarrer le serveur mysql (avec, par exemple, xampp ou la commande mysqld). 
Puis, il faudra "sourcer" le fichier signature_clients.sql du répertoire doc qui contient la 
création de la base de données et des tables
* soit dans intellij en faisant un run sur le fichier sql
* soit en se connectant à mysql avec la commande mysql.exe -h localhost -u root -p et 
en tapant SOURCE doc/signature_clients.sql
(Il aurait fallu en faire une tâche dans maven)

Avec maven, lancer l'application ClientsApplication avec run (le code va être compilé, une archive sera construite et déployée).

Pour changer les ports, utilisateur/mot de passe de BDD, voir le fichier application.properties dans répertoire resources

2) Pour le client
File -> New -> Project from Version Control -> Git 
url: https://github.com/korolchuk/ModuleSignatureClientsAngular.git
choisir un répertoire où mettre le code du serveur.

Dans le terminal, faire npm install
puis ng serve

Lancer son navigateur, et ouvrir 
http://localhost:4200/clients

Si l'URL d'accès au serveur est différente de http://localhost:8090/signature/ il faudra 
modifier les deux services angular client.service.ts et clients.service.ts pour en tenir compte

Normalement, grâce à l'annotation @CrossOrigin mis dans les controllers de Spring, 
il n'y a plus besoin d'exécuter cette ligne dans un terminal ms-dos (pour 
éviter les problèmes avec les cors) pour lancer le navigateur chrome
"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --user-data-dir="C:/Chrome dev session" --disable-web-security
____________________________________________________________________________
ETAT du PROJET

Nous avons réalisé toutes les fonctionnalités sur la liste des clients 
(affichage, recherche par nom et prénom), 
ainsi que sur les documents d'un client donné 
(upload, download, modification des méta-données - libellé et catégorie -, et destruction).
Nous avons presque toutes les fonctionnalités pour un client donné pour 
les informations principales que ce soit pour 
l'affichage, la création ou la mise à jour d'une fiche client. 
Seuls manquent l'ajout d'un décès à la création/MAJ
d'un client dans la partie serveur (la mise à jour d'un décès existant fonctionne), 
la suppression d'un décès en cas d'erreur, et 
l'ajout/destruction d'autres adresses que la principale (la MAJ fonctionne).
Par manque de temps (et aussi de compréhension), nous n'avons pas réalisé la partie historique.

Routes possibles d'appel du serveur http://localhost:8090/signature
/clients
/client/add
/client/{id}
/client/{id}/update
/client/{id}/documents
/client/{id}/document/upload
/client/{id}/document/{idDoc}/download
/client/{id}/document/{idDoc}/update
/client/{id}/document/{idDoc}/delete
/infoFormulaire

Par manque de temps: 
* Aucun test de validité des données n'a été effectué côté client et côté serveur.
* Aucun test unitaire (quelques squelettes de tests JUnit existent côté serveur) et d'intégration n'a été codé.
* Seul un diagramme de classe des POJOs a été réalisé au début du projet (pour nous aider à construire la base de données,
comme un MCD). Il n'y a pas de Javadoc ou autre documentation. Le code a été peu commenté, 
mais les noms des variables/méthodes sont assez explicites.

Pour continuer ce projet, il faudrait:
- Supprimer le POJO Historique (comme on a fait pour Habitation) car c'est Spring qui 
gère les tables pivots, pour pouvoir commencer à stocker les événements maritaux/PACS
et en faire l'affichage dans l'onglet historique. Le passage des différent états maritaux n'étaient pas 
très clairs, pour nous aussi (comment passer de divorcé à célibataire?) 
- Comprendre comment créer un décès dans la table adéquate ayant comme clé primaire et étrangère
la clé de la table personne. Nous avons un "attempted to assign id from null one-to-one property"
actuellement bien que nous ayons essayé cascade = {CascadeType.ALL}
- Enlever les contraintes qu'on avait mises de non-nullable (dans les tables et dans les POJOs) 
sur les clés étrangères des tables. Actuellement, il est obligatoire d'avoir un pays de 
naissance, une ville de naissance, un statut, etc. Ce choix avait été fait, au début, lors de la 
création/génération des POJOs car nous ne maîtrisions pas bien Spring.
- Faire tous les tests de validation des données côté client et côté serveur. Mettre en place un 
warning si on quitte la création ou la maj d'une fiche client sans l'avoir sauvegardée.
- Coder tous les test unitaires d'accès à la BDD avec JUnit et peut-être faire des tests du front 
avec Sélénium et/ou Cypress. 
- Sûrement changer comment sont stockées les adresses pour ne les mettre que dans le client (et non 
dans le conjoint aussi) et de rajouter un champ pour indiquer si l'adresse est commune ou non.
Actuellement, le client et son conjoint peuvent avoir des adresses différentes. Avoir aussi les deux
formats d'affichage/de maj des adresses.
- Mieux gérer les villes/codes postaux/villes étrangères/pays dans l'affichage, sous angular 
(par exemple, lier le code postal et la ville sélectionnée).
Actuellement, nous avons supprimé le code postal de l'affichage et il est possible d'avoir une ville 
française et une ville étrangère.
