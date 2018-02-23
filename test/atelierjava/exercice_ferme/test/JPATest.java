
package atelierjava.exercice_ferme.test;

import atelierjava.exercice_ferme.entite.Joueur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;


public class JPATest {
    
    @Test
    public void demarreJPA() {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        // em.persist(em); // La fonction persist fait un insert
        em.getTransaction().begin();
        
        Joueur j = new Joueur();
        j.setPseudo("Thomas");
        j.setMotDePasse("1234");
        em.persist(j);
        em.getTransaction().commit();
        
        
        
    }
}
