/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.test;

import atelierjava.exercice_ferme.entite.Joueur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formation
 */
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
