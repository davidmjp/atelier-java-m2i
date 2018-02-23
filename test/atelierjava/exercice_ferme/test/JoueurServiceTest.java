/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.test;

import atelierjava.exercice_ferme.dao.JoueurDAO;
import atelierjava.exercice_ferme.service.JoueurService;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formation
 */
public class JoueurServiceTest {

    // https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
    // http://cyberzoide.developpez.com/tutoriels/java/regex/
    // @Test
    public void monTestOK() {
        String pseudo = "terearera";

        String mdp = "A1";
        if (mdp.length() < 3 || mdp.length() > 8) {
            System.out.println("Veuillez choisir un mot de passe compris entre 3 et 8 caractères.");
        }
        if (mdp.chars().filter(Character::isUpperCase).count() == 0) {
            System.out.println("Il faut que votre mot de passe contienne au moins une majuscule.");
        }
        if (mdp.chars().filter(Character::isDigit).count() == 0) {
            System.out.println("Il faut que votre mot de passe contienne au moins un chiffre.");
        }
//        throw new RuntimeException("une erreur a été détectée");

        // pseudo.Character.isLowerCase();
        /*
        // Explication formateur : . pour remplacer n'importe quel caractères, et * pour de 0 à n
              System.out.println(mdp.matches("\\d")); // TRUE si la chaîne ne contient qu'un seul chiffre
              System.out.println(mdp.matches("\\d*")); // TRUE si ne contient que des chiffres.
              System.out.println(mdp.matches("\\d.*")); // TRUE si la chaîne commence par un chiffre (elle peut contenir d'autres caractères)
              System.out.println(mdp.matches(".*\\d.*")); // TRUE si contient au moins un chiffre, même ailleurs qu'au début de la chaîne

              System.out.println(mdp.matches("\\p{javaUpperCase}*")); // TRUE si tous les caractères sont des majuscules
              System.out.println(mdp.matches("\\p{javaUpperCase}.*")); // TRUE si on commence par une majuscule
              System.out.println(mdp.matches(".*\\p{javaUpperCase}.*")); // TRUE si la chaîne contient au moins une majuscule
        
        System.out.println(mdp.matches("[A-Z][0-9]")); // TRUE si contient 1 majuscule et 1 chiffre, dans l'ordre
        System.out.println(mdp.matches(".*[A-Z].*[0-9].*")); // TRUE si trouve une majuscule AVANT un chiffre (quoiqu'il y ait entre les deux)
              
              
              
              System.out.println(mdp.matches(".*\\p{javaUpperCase}&&\\d.*"))
         */
 /*
                      [A-Z]{6} // TRUE pour 6 majuscules
                      [A-Z]{6,10} // entre 6 et 10 majuscules
         */
        // mdp.matches("[0..9]");
    }

     @Test
    public void inscriptionOK() {

        JoueurService service = new JoueurService();
        service.inscription("abcd", "1234bB");

    }

     @Test(expected = RuntimeException.class)
    public void inscriptionKO() {
        JoueurService service = new JoueurService();
        service.inscription("abcde", "aaaa123");
    }

//    @Test // On ne teste pas le DAO mais le service avec inscription
    // Les DAO et les services sont toujours des variables pas statiques
    public void rechercheOK() {
//        FermeDAO variable = new recherche("hey");
        JoueurDAO variable2 = new JoueurDAO();
    }

    @Test
    public void connexionOK() {
        JoueurService service = new JoueurService();
        service.inscription("abcdef", "1234bB");
        service.connexion("abcdef", "1234bB");
    }

    @Test(expected = RuntimeException.class)
    public void connexionKO() {
        JoueurService service = new JoueurService();
        service.connexion("abcdghi", "1234bB");
    }

}
