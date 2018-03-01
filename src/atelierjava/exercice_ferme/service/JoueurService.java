
package atelierjava.exercice_ferme.service;

import atelierjava.exercice_ferme.dao.JoueurDAO;
import atelierjava.exercice_ferme.dao.RessourceDAO;
import atelierjava.exercice_ferme.entite.Joueur;
import atelierjava.exercice_ferme.entite.Ressource;
import atelierjava.exercice_ferme.exception.PseudoExisteException;
import atelierjava.exercice_ferme.exception.ValidationException;


public class JoueurService {

    /**
     * pseudo : mini 3 lettres, maxi 8 unique
     * mdp : mini 5 lettres, maxi 10 au moins une majuscule et un chiffre
     *
     * @param pseudo
     * @param mdp
     */
    
    public void ajouterRessource(long joueurId, Ressource.TypeRessource typeRessource, long quantite) {

        
         // "Long" avec un grand L peut contenir "null", mais "long" force la présence d'une valeur
        // 1. Génère les ressources SI aucune ressource pour ce joueur
        JoueurDAO dao = new JoueurDAO();
        Joueur joueur = dao.rechercher(joueurId);
           
            for(int i = 0; i < quantite; i++) {
                Ressource ressource = new Ressource();
                ressource.setDesignation(typeRessource);
                ressource.setJoueur(joueur);
                joueur.getRessourcesPossedees().add(ressource);
                
                RessourceDAO ressourceDAO = new RessourceDAO();
                ressourceDAO.ajouter(ressource);
                
            }
    }

  
    
    public void rejoindrePartie(long idJoueur) {
       
                   // "Long" avec un grand L peut contenir "null", mais "long" force la présence d'une valeur
        // 1. Génère les ressources SI aucune ressource pour ce joueur
        JoueurDAO dao = new JoueurDAO();
        Joueur joueur = dao.rechercher(idJoueur);
        if ( joueur.getRessourcesPossedees().isEmpty() ) {
            
            // 1. Ajouter 5 carottes
            this.ajouterRessource(idJoueur, Ressource.TypeRessource.CAROTTE, 5);
              
            // 2. Ajouter 5 blés
            this.ajouterRessource(idJoueur, Ressource.TypeRessource.BLE, 5);
            
            // 3. Ajouter 5 chèvres
            this.ajouterRessource(idJoueur, Ressource.TypeRessource.CHEVRE, 5);
            
            // 4. Ajouter 2 fermiers
            this.ajouterRessource(idJoueur, Ressource.TypeRessource.FERMIER, 2);
        }
        
    } 
    
    /* 
    F1 -> F2 -> F3() throws Exception {...    throw new BiquetteEstMorteException();
    Les exceptions sont des classes (constructeur vide possible) qu'on fait remonter de fonction en fonction, parce qu'une fonction ne renvoie qu'1 seule valeur dans son return, ici la fonction s'arrête à l'exception et on n'utilise pas la valeur transmise par la fonction.
    si je fais un try catch, l'exception remonte jusqu'en haut (jusqu'à la classe qui traite la vue)
    throw = remonter / déclencher
    qd on a des exception de métier qui apparaissent dans des fonctions de service
    Les Exception sont considérées plus graves que les RuntimeException, c'est pour ça qu'elles doivent être indiquées avec un throws dans la déclaration de la fonction.
    OU avec le TRY CATCH : si le TRY déclenche une erreur, ça saute dans le CATCH et après le programme continue sans s'arrêter
    try { throw new Exception("....") } catch (Exception ex) {  ... }
    On va créer un Package Exception pour les gérer
    
    Les classes n'héritent pas du constructeur du parent
    
    */
    
    public void inscription(String pseudo, String mdp) throws ValidationException, PseudoExisteException  {
        
        // Pour voir partout où la fonction est utilisée : Clic droit sur "inscription" (le nom de la fonction), "find usages", appuyer sur "find", cliquer sur la flèche vers le bas

        if (!pseudo.matches(".{3,8}")) {
            throw new ValidationException("Le pseudo doit être compris entre 3 et 8 caractères.");
            // throw new RuntimeException("Le pseudo doit être compris entre 3 et 8 caractères.");
        }

        if (!mdp.matches(".{5,10}")) {
            throw new RuntimeException("Le mot de passe doit être compris entre 3 et 8 caractères.");
        }

        if (!mdp.matches(".*[A-Z].*")) {
            throw new RuntimeException("Le mot de passe requiert une majuscule.");
        }

        if (!mdp.matches(".*[0-9].*")) {
            throw new RuntimeException("Le mot de passe doit contenir au moins un chiffre.");
        }


        // Vérifier que le pseudo est encore dispo
        JoueurDAO dao = new JoueurDAO();
        if (dao.existe(pseudo)) {
            throw new PseudoExisteException("Ce pseudo existe déjà.");
            // throw new RuntimeException("Ce pseudo existe déjà.");
        }

        // Ajoute la ferme en BD
        Joueur ferme = new Joueur();
        ferme.setPseudo(pseudo);
        ferme.setMotDePasse(mdp);
        dao.ajouter(ferme);
    }

    public Joueur connexion(String pseudo, String mdp) { // On remplace void par Joueur pour renvoyer tout l'objet pour récupérer l'id

        JoueurDAO dao = new JoueurDAO();
        Joueur j = dao.rechercher(pseudo, mdp);
        
        return j;
    }

}
