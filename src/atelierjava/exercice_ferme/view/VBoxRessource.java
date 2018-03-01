package atelierjava.exercice_ferme.view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VBoxRessource extends VBox {
    
    private Label lNbreRessources = new Label("0");
    private ImageView iImage;
    

    public VBoxRessource(long nbRessource, String urlImage) {
        
        this.iImage = new ImageView(urlImage);
        
        // ImageView iImage = new ImageView(urlImage);
        this.getChildren().add(this.iImage);
        this.getChildren().add(this.lNbreRessources);
        
        /* Une classe est un moule à gâteau, et avec un moule à gâteau, on fait autant de gâteau qu'on veut
        Avec un même moule à gâteau on peut faire un gâteau à la framboise, ou un gâteau à la banane, etc.
        */
        
        this.iImage.setFitWidth(300);
        this.iImage.setPreserveRatio(true);
        
    }
    
}
