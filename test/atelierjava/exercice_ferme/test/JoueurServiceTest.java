
package atelierjava.exercice_ferme.test;

import atelierjava.exercice_ferme.dao.JoueurDAO;
import atelierjava.exercice_ferme.entite.Joueur;
import atelierjava.exercice_ferme.exception.PseudoExisteException;
import atelierjava.exercice_ferme.exception.ValidationException;
import atelierjava.exercice_ferme.service.JoueurService;
import org.junit.Test;
import static org.junit.Assert.*;


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
        
    }

    // @Test
    public void inscriptionOK() throws ValidationException, PseudoExisteException {

        JoueurService service = new JoueurService();
        service.inscription("abcd", "1234bB");

    }

    @Test(expected = RuntimeException.class)
    public void inscriptionKO()  throws ValidationException, PseudoExisteException {
        JoueurService service = new JoueurService();
        service.inscription("abcde", "aaaa123");
    }

    // @Test // On ne teste pas le DAO mais le service avec inscription
    // Les DAO et les services sont toujours des variables pas statiques
    public void rechercheOK() {
//        FermeDAO variable = new recherche("hey");
        JoueurDAO variable2 = new JoueurDAO();
    }

    @Test
    public void connexionOK() throws ValidationException, PseudoExisteException  {
        JoueurService service = new JoueurService();
        service.inscription("abcdef", "1234bB");
        service.connexion("abcdef", "1234bB");
    }

    @Test(expected = RuntimeException.class)
    public void connexionKO() {
        JoueurService service = new JoueurService();
        service.connexion("abcdghi", "1234bB");
    }
    
    @Test
    public void rejoindrePartieOK() throws ValidationException, PseudoExisteException {
        JoueurService service = new JoueurService();
        service.inscription("David", "A13vvv");
        Joueur joueur = service.connexion("David", "A13vvv");
        service.rejoindrePartie( joueur.getId() );
    }

}
