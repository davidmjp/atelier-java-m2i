/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.view;

import atelierjava.exercice_ferme.entite.Joueur;
import atelierjava.exercice_ferme.service.JoueurService;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Formation
 */
public class FormulaireJoueurView extends GridPane {

    // 3 façons pour faire le constructeur : taper ecr.. et compléter / clic droit insert code / alt+insert
    // On va toujours préfixer le nom de la variable avec la première lettre du type du composant
    private Label lPseudo = new Label("Pseudo");
    private TextField tfPseudo = new TextField(); // Si je mets du texte dedans, il sera déjà affiché.
    private Label lMdp = new Label("Mot-de-passe");
    private PasswordField pfMdp = new PasswordField();
    private Button bConnexion = new Button("Connexion");
    private Button bInscription = new Button("Inscription"); // On fait d'abord un espace après "new", puis un ctrl+espace
    // tous les composants visuels JavaFX sont des "node", ils extend "node"

    // private Label lInscription = new Label("*Inscription*");
    // private Label lConnexion = new Label("*Connexion*");
    public FormulaireJoueurView(BorderPane borderPaneDuParent, boolean ceciEstUnPanneauDeConnexion) { // Le this est optionnel, on peut appeler le add directement parce que l'objet actuel est un GridPane
        // (NewFXMain newFXMain) référence à la classe qui appelle
        this.add(lPseudo, 0, 0);
        this.add(tfPseudo, 1, 0);
        this.add(lMdp, 0, 1);
        this.add(pfMdp, 1, 1);
        if (ceciEstUnPanneauDeConnexion == true) {
            this.add(bConnexion, 1, 2);
        } else {
            this.add(bInscription, 1, 2);
        }

        /*  BorderPane root = new BorderPane();
        HBox barreOutils = new HBox();
        barreOutils.getChildren().add( lConnexion );
        // barreOutils.getChildren().setText */
        // add(lConnexion, 2, 0);
        // NewFXMain.lInscription.setText(" ** Connexion **");
        bInscription.setOnAction(e -> {
            try {
                JoueurService js = new JoueurService();

                if (ceciEstUnPanneauDeConnexion == true) {
                    Joueur joueurTrouve = js.connexion(tfPseudo.getText(), pfMdp.getText());
                    System.out.println("Joueur trouvé : " + joueurTrouve);

                    // borderPaneDuParent.setCenter(new Label("Connexion réussie"));
                } else {
                    js.inscription(tfPseudo.getText(), pfMdp.getText());

                    // Remplace le centre du parent par un texte vide
                    borderPaneDuParent.setCenter(new Label("Inscription réussie"));
                }
            } catch (Exception exception) {
                // System.out.println("!!! ERREUR !!!" + exception.getMessage());
                // this.add(new Label(exception.getMessage()), 0, 3); // S'il y a plusieurs messages, ils s'affichent les uns au-dessus des autres. Si je mets en ligne 4, ça reste en ligne 3 (parce qu'elle est vide)
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Il s'est produit une erreur.");
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            } // On peut mettre plusieurs catch
        });

        /* Le RuntimeException extends Exception.
        throw new RuntimeException
        
        Exception
        Java saute directement dans le catch dès qu'il y a une erreur, donc à la première erreur rencontrée dans cette classe ou une autre appelée, une sous-fonction lointaine, etc.
        Ici me renvoie dans "exception" mon message prévu dans throw new RuntimeException
         */
        bConnexion.setOnAction(e -> {
            try {
                String pseudo = tfPseudo.getText();
                String mdp = pfMdp.getText();

                JoueurService service = new JoueurService();
                service.connexion(pseudo, mdp);

                // borderPaneDuParent.setCenter(new Label("Connexion Réussie"));
                // Affiche l'écran de jeu :
                borderPaneDuParent.setCenter(new EcranJeuView());

            } catch (Exception erreur) { // Pour ratisser large, toutes les erreurs

                Alert alert = new Alert(Alert.AlertType.WARNING);
                

                alert.setTitle("Erreur");
                alert.setHeaderText("Message d'erreur:");
                alert.setContentText( erreur.getMessage() );
                
                erreur.printStackTrace(); /* Permet de récupérer toute une liste d'erreurs à partir de laquelle je peux cliquer sur des liens me renvoyant dans mon programme.
                                            Les erreurs remontent, on doit repérer la première classe qui nous appartient (du haut vers le bas) pour savoir d'où vient l'erreur.
                                           */
                alert.showAndWait();
            }

        });

    }

}
