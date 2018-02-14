/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava;

/**
 *
 * @author Formation
 */
public class Fermier {
    
    private String nom;
    private String prenom;
    private String specialite;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    
    @Override
    public String toString() {
        return nom; // Affiche le nom au lieu de l'adresse mémoire
    }
    // On utilisera cette méthode pour afficher le contenu d'objets
    
    
    
    
    // En général, on n'utilise pas les constructeurs (qui ne servent pas ici).
}