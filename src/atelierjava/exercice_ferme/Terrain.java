/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme;

import java.util.ArrayList;

/**
 *
 * @author Formation
 */
public class Terrain {
    private double tailleEnHa;
    private ArrayList<Ressource> ressourcesContenues = new ArrayList<>();

    public double getTailleEnHa() {
        return tailleEnHa;
    }

    public void setTailleEnHa(double tailleEnHa) {
        this.tailleEnHa = tailleEnHa;
    }

    public ArrayList<Ressource> getRessourcesContenues() {
        return ressourcesContenues;
    }

    public void setRessourcesContenues(ArrayList<Ressource> ressourcesContenues) {
        this.ressourcesContenues = ressourcesContenues;
    }
    
    
}
