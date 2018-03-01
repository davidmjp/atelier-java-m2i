/* Pour afficher des fenêtres :
AWT première librairie fenêtre pour Java (ne s'utilise plus pour Java)
Swing ne s'utilise plus depuis qq années (on ne pouvait faire que de la 2D)
JavaFX est le plus récent (avec 3D)

(Jeu : The witcher3 (jeu en 3D gourmand, on ne va pas l'écrire en Java parce que ça va ramer au niveau processeur) (plutôt en dotnet ou plutôt en C++))


Architecture de JavaFX : 
* Panneaux : positionnement, : BorderPane, VBox, HBox, GridPane (comme une combinaison du VBox et HBox, une grille)
----------------------
BorderPane
----------------------
    |           |
    |           |
    |           |
    |           |
    |           |
    |           |
    |           |
    |           |
-----------------------

------------------------

* Composants : Button, TextField, PasswordField, Label
* Alert

La classe Exception : la classe RuntimeException, et les autres exceptions
alt shift O : raccourci pour ouvrir une classe
Si une fonction déclenche throw
"throw new Exception" ne marche pas
fonctions doivent préciser qu'elles peuvent déclencher toutes les exceptions "throws Exception" sauf les RunetimeException
pas obligé de faire un throws pour les RuntimeException


*/

package atelierjava.exercice_ferme.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane; // layout : disposition // Layout Hbox (les boutons s'affichent à l'horizontale, sur une ligne) / Vbox (boîte verticale) / BorderPane
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Formation
 */
public class NewFXMain extends Application {
    
    private Button bInscription = new Button("Inscription");
    private Button bConnexion = new Button("Connexion");
    
    private Label lInscriptionOuConnexion = new Label(""); // Vide pour ensuite afficher "Inscription" ou "Connexion" à droite des boutons
    
    @Override
    public void start(Stage primaryStage) { // On a effacé tout ce qu'il y avait avant "scene"
        
        BorderPane root = new BorderPane(); // Pane = panneau
        // root est le BorderPane qui se trouve dans ma fenêtre
        
        HBox barreOutils = new HBox();
        barreOutils.getChildren().add( bInscription );
        barreOutils.getChildren().add( bConnexion );
        barreOutils.getChildren().add(lInscriptionOuConnexion );
        
        
        // Inscription
        bInscription.setOnAction(e -> {
            lInscriptionOuConnexion.setText(" ** Inscription **");
            root.setCenter(new FormulaireJoueurView(root, false)); // "node" peut être un "pane" ou un bouton.
        } ); // Programmation lambda
        
        /* ce qu'il ya  entre les { } est la fonction qui va traiter le clic sur le bouton. 
        setOnAction prend un objet de type EventHandler
        handler veut dire gestionnaire
        Décomposé : un new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) { ...         }
        } );
        On peut faire la même chose en utlisant une fonction lambda : e -> { ...}
                */
        
        
        // Connexion
         bConnexion.setOnAction(e -> {
            lInscriptionOuConnexion.setText(" ** Connexion **");
            root.setCenter(new FormulaireJoueurView(root, true)); // je passe le BorderPane()
        } );
        
        root.setTop(barreOutils);
        
        root.setBottom(new Label("Copyright 2018 M2i") );
//         root.setAlignment(barreOutils, Pos.BOTTOM_RIGHT);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("David");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); // Appelle la fonction start ci-dessus
    }
    
}
