/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.view;

import javafx.scene.layout.GridPane;

/**
 *
 * @author Formation
 */
public class EcranJeuView extends GridPane {
    
    private VBoxRessource vbrCarotte = new VBoxRessource(0, "file:C:\\Users\\Formation.M2I-JAV5-04\\Documents\\NetBeansProjects\\AtelierJava\\src\\img\\carotte.png");
    private VBoxRessource vbrChevre = new VBoxRessource(0, "file:C:\\Users\\Formation.M2I-JAV5-04\\Documents\\NetBeansProjects\\AtelierJava\\src\\img\\chèvre.png");
    private VBoxRessource vbrFermier = new VBoxRessource(0, "file:C:\\Users\\Formation.M2I-JAV5-04\\Documents\\NetBeansProjects\\AtelierJava\\src\\img\\fermier.png");
    private VBoxRessource vbrFromage = new VBoxRessource(0, "file:C:\\Users\\Formation.M2I-JAV5-04\\Documents\\NetBeansProjects\\AtelierJava\\src\\img\\fromage.png");
    private VBoxRessource vbrBle = new VBoxRessource(0, "file:C:\\Users\\Formation.M2I-JAV5-04\\Documents\\NetBeansProjects\\AtelierJava\\src\\img\\blé.png");

    public EcranJeuView() {
        this.add(vbrCarotte, 0, 0);
        this.add(vbrBle, 1, 0); // d'abord la colonne, ensuite la ligne. // (child, columnIndex, rowIndex)
        this.add(vbrFermier, 2, 0);
        this.add(vbrFromage, 3, 0);
        this.add(vbrChevre, 4, 0);
    }
    
    
    
}
