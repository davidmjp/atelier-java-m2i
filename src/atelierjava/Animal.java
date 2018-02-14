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
public class Animal {
    
    static int nbAnimaux = 0;
    
    int tailleEnCm;
    double poidsEnKg;
    String genre;
    String espece;

    
    // Clic DROIT : INSERT CODE : OVERRIDE METHOD
    @Override
    public String toString() {
        // return this.espece + this.poidsEnKg;
        
        String res = this.espece;
        return res;
    }
    
    
    
//    Animal parent; // si les animaux descendent les uns des autres, un animal a un parent
           
    public Animal() {
            nbAnimaux++;
        }

    
    /* le sens d'une fonction statique c'est qu'elle peut être appelée en dehors de toute instance
    En Java, les variables et les fonctions sont toujours dans une classe. En orienté objet, on n'a que des classes et des objets.
    la fonction n'exite pas en dehors d'une classe
*/
    
    
    public void afficher() {  // affiche mais ne renvoie rien (pas de return)
        System.out.println(espece + " pèse " + poidsEnKg + "kg.");
        
    }
    
}
