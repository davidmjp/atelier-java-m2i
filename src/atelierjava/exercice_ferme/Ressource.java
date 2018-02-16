/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme;

/**
 *
 * @author Formation
 */
public class Ressource {
    
    public enum TypeRessource { // Le nom de l'enum commence par une majuscule, comme celui d'une classe
        ANIMAL_MOUTON, // tout en majuscule avec des underscore (certification iso en entreprise)
        ANIMAL_VACHE, 
        CULTURE_BLE,
        CULTURE_MAIS
    }
    
    private TypeRessource designation; // ex : = TypeRessource.CULTURE_BLE;
    private String nom;

    public TypeRessource getDesignation() {
        return designation;
    }

    public void setDesignation(TypeRessource designation) {
        this.designation = designation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
