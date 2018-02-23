/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.dao;

import atelierjava.exercice_ferme.entite.Joueur;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Formation
 */
// ALT + SHIFT + F pour indenter
public class JoueurDAO {


    public void ajouter(Joueur j) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(j);
        em.getTransaction().commit();
        
        
        /*
        String a = "coucou";
        String b = "hello";
       // if (a == b) // renvoie toujours FAUX, renvoie TRUE s'il s'agit du même objet, pas sa valeur
        if (a.equals(b)) System.out.println("C'est bien égal."); // Compare le contenu
        */
    }

    public Joueur recherche(String pseudo) { // Fonction qui renvoie un objet de type Joueur, donc avec un return, contrairement au void
        
        // Objet EntityManager pour accéder à notre base de données
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Query query = em.createQuery("SELECT j FROM Joueur j WHERE j.pseudo=:pseudoRecherche"); // C'est nous qui l'appelons pseudoRecherche
        query.setParameter("pseudoRecherche", pseudo);
        
        Joueur j = (Joueur) query.getSingleResult(); // CTRL + ESPACE sur le getSingleResult nous dit ce qu'il renvoie.
        return j;
        
        /* Ce qu'on avait écrit avant pour faire une recherche par pseudo sans sql
        for (Joueur fermeActuelle : joueurs) {
            if (fermeActuelle.getPseudo().equals(pseudo)) {
                 return fermeActuelle;
            }
        }
        return null;
        
       */
    }

    public boolean existe(String pseudo) {
/*
        Joueur f = this.recherche(login); // J'utilise le résultat de ma recherche pour implémenter existe (avant "pseudo" s'appelait "login")
        if (f == null) return false;
        return true; // On n'arrive pas à cette ligne si on return false à la ligne précédente (sortie de la fonction)
*/        
        // 1. Récupère EntityManager
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        // 2. Vérifie 
        Query query = em.createQuery("SELECT COUNT(j) FROM Joueur j WHERE j.pseudo=:pseudoExistant"); // Comme createQuery renvoie du query, on le met dans une variable query
            // SELECT j renvoie un objet joueur complet
            // SELECT COUNT(j) renvoie le nombre de joueurs trouvés, le COUNT renvoie du LONG
        query.setParameter("pseudoExistant", pseudo);
        
        long nbJoueurs = (long) query.getSingleResult(); // getSingleResult me renvoie du un objet donc je dois le convertir en long
        
        if (nbJoueurs > 0) return true;
        return false;
        
    }
    
    public boolean existe(String pseudo, String mdp) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        // Query query = em.createQuery("SELECT j FROM Joueur j WHERE j.pseudo=:pseudoExistant AND j.motDePasse=:mdp");
        Query query = em.createQuery("" // On fait juste ENTREE après le premier guillemet pour que le reste s'ajoute : les " et les +
                + "SELECT COUNT(j) "
                + "FROM Joueur j "
                + "WHERE j.pseudo=:pseudoExistant "
                + "         AND j.motDePasse=:mdp");
        
        query.setParameter("pseudoExistant", pseudo);
        query.setParameter("mdp", mdp);
        
        long nbREA = (long) query.getSingleResult();
        
        if (nbREA == 0) 
            return false;
        
        return true;
        
        // "joueurs" est une liste de joueurs déjà remplie par du code situé plus haut.
        
        // List<Joueur> joueurs = new ArrayList<>();
        /*
        Joueur j = new Joueur();
        j.setPseudo("Thomas");
        j.setMotDePasse("TT");
        joueurs.add(j);
        j.setPseudo("Coucou");
        j.setMotDePasse("CC");
        joueurs.add(j);
        */
//         if j1.getIdentifiant().equals()...

/* Ce qu'il y avait avant la base sql
        
        for (Joueur joueurActuel : joueurs) {
            if (joueurActuel.getPseudo().equals(pseudo) && joueurActuel.getMotDePasse().equals(mdp)) return true;
        }
        return false;

*/


    }

}

/*  3 couches : "modèle MVC"
Vue : nos écrans (par exemple : login)

------------------------
Contrôleur : classes, par exemple : UtilisateurContrôleur (dans lequel on a les fonctions susceptibles d'être déclenchées par des clics)
                                    login();
(le contrôleur va faire des appels de fonctions dans le modèle) (par exemple appelle la classe UtilisateurService)
------------------------
Modèle (coeur de notre application)
        service

                entité
                    utilisateur     Base de donnée      le DAO fait partie du modèle
                                                        (Data Access Object : c'est lui qui accède à la BD (base de données))


(les tests unitaires sont en dehors de tout, mais ils accèdent au service de la même façon quel le contrôleur accède au service)
(l'entité, c'est par exemple "Ferme")
*/