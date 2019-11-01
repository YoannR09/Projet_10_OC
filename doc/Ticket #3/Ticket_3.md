##  Ticket n°3
   
### Test unitaires :


   - Ajouts des méthodes getDao() et getLogger() pour pouvoir créer un fake.
   
   ![automated like clockwork](image/methode.png)
   
   - Mise en place des mocks et stubs.
   
   ![automated like clockwork](image/mock_stub.png)
   
   - Création du fake dans la classe de test avec les mocks.
   
   ![automated like clockwork](image/fake.png)
   
   - Test des méthodes et vérification des exceptions.
   
   ![automated like clockwork](image/test.png)
   
   
   
### Test d'intégrations : 
 
   - Création d'une collection sur Postman : https://www.getpostman.com/collections/089e535339b4f4936f3e
   
      ![automated like clockwork](image/collection.png)
  
   - Intégration des tests pour les requetes de la collection.
   
      ![automated like clockwork](image/collection_test.png)
   
   - Création du fichier de la collection en json pour pouvoir
   lancer le test via Travis CI.
   
      ![automated like clockwork](image/collection_json.png)
   
   - Installation de node.js en local pour vérifier les test d'intégrations.
   - Installation de newman pour lancer les tests de la collection.
   
   - Vérification des tests via newman :
   
      ![automated like clockwork](image/newman.png)
   
   - Ajout d'un fichier travis ci qui lance la collection de test postman avec newman.
   (Les microservices ne sont pas encore mis en ligne, travis ci ne peut donc
   pas récupérer les données avec les requetes.)
   
     ![automated like clockwork](image/travis.png)
   
    