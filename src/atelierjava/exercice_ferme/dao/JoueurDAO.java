
package atelierjava.exercice_ferme.dao;

import atelierjava.exercice_ferme.entite.Joueur;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class JoueurDAO {

    public Joueur rechercher(long idJoueur) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Joueur j = em.find(Joueur.class, idJoueur); // variable (public) static .class dans object qui correspond au nom de la classe actuelle
        return j;
    }
            
            
            
    public void ajouter(Joueur j) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(j);
        em.getTransaction().commit();
        
    }

    public Joueur recherche(String pseudo) { // Fonction qui renvoie un objet de type Joueur, donc avec un return, contrairement au void
        
        // Objet EntityManager pour accéder à notre base de données
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Query query = em.createQuery("SELECT j FROM Joueur j WHERE j.pseudo=:pseudoRecherche"); // C'est nous qui l'appelons pseudoRecherche
        query.setParameter("pseudoRecherche", pseudo);
        
        Joueur j = (Joueur) query.getSingleResult(); // CTRL + ESPACE sur le getSingleResult nous dit ce qu'il renvoie.
        return j;
        
    }

    public boolean existe(String pseudo) {
    
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
    
    public Joueur rechercher(String pseudo, String mdp) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("" // On fait juste ENTREE après le premier guillemet pour que le reste s'ajoute : les " et les +
                + "SELECT j "
                + "FROM Joueur j "
                + "WHERE j.pseudo=:pseudoExistant "
                + "         AND j.motDePasse=:mdp");
        
        query.setParameter("pseudoExistant", pseudo);
        query.setParameter("mdp", mdp);
        
        Joueur j = (Joueur) query.getSingleResult();
        
        return j;
        
    }

}
