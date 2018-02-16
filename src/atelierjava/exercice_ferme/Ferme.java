
package atelierjava.exercice_ferme; // Pas de MAJ dans le nom du package

import java.util.ArrayList;


/**
 *
 * @author Formation
 */

// On construit top-down, et après on assemble les classes qu'on a ouvertes séparément
// Créer une CLASSE, c'est créer un TYPE. Le nom de la classe se met au singulier.

public class Ferme {
    
    private double budget;
    private String nom;
    private ArrayList<Terrain> ressourcesPossedees = new ArrayList<>();
    private ArrayList<Ressource> terrains = new ArrayList<>();

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Terrain> getRessourcesPossedees() {
        return ressourcesPossedees;
    }

    public void setRessourcesPossedees(ArrayList<Terrain> ressourcesPossedees) {
        this.ressourcesPossedees = ressourcesPossedees;
    }

    public ArrayList<Ressource> getTerrains() {
        return terrains;
    }

    public void setTerrains(ArrayList<Ressource> terrains) {
        this.terrains = terrains;
    }
    
    
}
