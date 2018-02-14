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
public class Personne {
    
    private String nom; // private pour que du code extérieur à notre classe ne puisse pas détraquer le fonctionnement de notre classe
    // Le String est un objet, il vaut "null" si on ne met rien dedans.
    private int age;
    
    // byte 1 octet, short 2, int 4, long 8, // float 4 octets, double 8 octets // BigInteger BigDecimal pour travailler avec une grande précision
   
    // ALT + INSERT pour faire sortir tous les getter et setter
    
    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }
    
    
    
    static private int ageMaxi; // j'encapsule mes variables avec "private" pour qu'elles ne puissent pas être modifiées de l'extérieur
    static private int ageMini = -1; // ¨Pour dire que la variable n'a pas encore été initialisée (on garde 0 pour 0 an).

    public static int getAgeMaxi() {
        return ageMaxi;
    }

    public static int getAgeMini() {
        return ageMini;
    }
// pas les set, seulement les get, parce que si on a un set public, le main peut détraquer la valeur de l'âge minimum
    
    // les variables et fonctions qui ne sont pas statiques sont uniquement accessibles à partir d'un objet (créé avec le constructeur)
    // Ce qui est static reste assez marginal
    // les constructeurs sont des raccourcis pour ensuite faire des new, on peut faire un "new" sans constructeur, il est implicite

    public void setAge(int age) {
        // this.age = age;
      
        if (age > ageMaxi) ageMaxi = age;
        if ((ageMini == -1) || (age < ageMini)) ageMini = age; 
        // -1 parce que si on met 0 et qu'il y a un âge de 0, alors le programme pense que la variable n'a pas encore été initialisée.
        
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
   // PAS DE CONSTRUCTEUR ICI
   
    // ageMini = true ? 5 :0
}
