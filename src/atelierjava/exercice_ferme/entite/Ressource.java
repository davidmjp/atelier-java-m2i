/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.entite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Formation
 */
@Entity
public class Ressource implements Serializable {
    
    public enum TypeRessource { // Le nom de l'enum commence par une majuscule, comme celui d'une classe
        ANIMAL_MOUTON, // tout en majuscule avec des underscore (certification iso en entreprise)
        ANIMAL_VACHE, 
        CULTURE_BLE,
        CULTURE_MAIS
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY au lieu de AUTO (qui fait qch d'un peu tiré par les cheveux)
    private Long id;    
    
    private TypeRessource designation; // ex : = TypeRessource.CULTURE_BLE;
    private String nom;
    

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
