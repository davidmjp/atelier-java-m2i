/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.entite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Formation
 */
@Entity
public class Ressource implements Serializable {
    
    public enum TypeRessource { // Le nom de l'enum commence par une majuscule, comme celui d'une classe
        CHEVRE, // tout en majuscule avec des underscore (certification iso en entreprise) 
        BLE,
        CAROTTE,
        FERMIER,
        FROMAGE
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY au lieu de AUTO (qui fait qch d'un peu tiré par les cheveux)
    private Long id;    
    
    @Enumerated(value = EnumType.STRING) // Permet de transformer les numéros attribués à chaque élément de la liste ENUM par leurs noms.
    private TypeRessource designation; // ex : = TypeRessource.CULTURE_BLE;
    
    private String nom;
    
    // Le mapping définit la structure de la base
    @ManyToOne // L'ordre n'a pas d'importance, mais les @ doivent être au-dessus du jouer.
    @JoinColumn(name = "joueur_id") // Colonne avec une contrainte forein key dessus (clé étrangère) + Nom de la colonne qu'il va créer dans ressources
    private Joueur joueur;

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

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atelierjava.exercice_ferme.entity.Ressource[ id=" + id + " ]";
    }
    
}
