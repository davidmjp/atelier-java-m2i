/*
*********************************************************** J'UTILISE FormulaireJoueurView.java à la place !
 */
package atelierjava.exercice_ferme.view;

import atelierjava.exercice_ferme.service.JoueurService;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Formation
 */
public class ConnexionView extends GridPane {

    private Label lPseudo = new Label("Pseudo");
    private TextField tfPseudo = new TextField(); // Si je mets du texte dedans, il sera déjà affiché.
    private Label lMdp = new Label("Mot-de-passe");
    private PasswordField pfMdp = new PasswordField();
    private Button bConnexion = new Button("Envoyer");

    public ConnexionView(BorderPane borderPaneDuParent) {
        this.add(lPseudo, 0, 0);
        this.add(tfPseudo, 1, 0);
        this.add(lMdp, 0, 1);
        this.add(pfMdp, 1, 1);
        this.add(bConnexion, 1, 2);

        bConnexion.setOnAction(e -> {
            try {
                String pseudo = tfPseudo.getText();
                String mdp = pfMdp.getText();

                JoueurService service = new JoueurService();
                service.connexion(pseudo, mdp);

                borderPaneDuParent.setCenter(new Label("Connexion Réussie"));
            } catch (Exception erreur) { // Pour ratisser large, toutes les erreurs

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Erreur");
                alert.setHeaderText("Il s'est produit une erreur.");
                alert.setContentText(erreur.getMessage());
                alert.showAndWait();
            }

        });

    }

}
