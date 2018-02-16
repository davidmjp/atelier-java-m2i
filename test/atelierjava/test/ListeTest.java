/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.test;

import java.math.BigInteger;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formation
 */
public class ListeTest {
    
    
    // Clic droit "test file" (Window, IDE Tools, Test Results)
    // @Test
    public void addAvecIndiceOK() {
        
        ArrayList<Integer> nombresPremiers = new ArrayList<>(); // Diamand <> facultatif
        nombresPremiers.add(2);
        nombresPremiers.add(5);
        nombresPremiers.add(1, 3);
        
        for(Integer nb : nombresPremiers) {
            System.out.println(nb);
        }
        
        nombresPremiers.forEach(i->System.out.println(i));
        
    }
    
    
    
    
    // boolean premier = true; 260 rue du faubourg d'arras
    
    
    // @Test
    public void GenereNombresPremiersOK() {
        int k = 0;
        ArrayList<Integer> nombresPremiersAuto = new ArrayList<>();
        for(int i=2; i<1000 ; i++) {
            for (int j=2; j<i; j++) {
                // System.out.println("i : " + i + " j : " + j);
                if (i % j == 0) break;
                k = j;
            }
            if (i == k+1) nombresPremiersAuto.add(i);
            // System.out.println("iS : " + i + " jS : " + k);
            
        }
        
        
        for(Integer nb : nombresPremiersAuto) {
            System.out.println(nb);
        }
        // nombresPremiersAuto.forEach(i->System.out.println(i));
    }
    
    
    // @Test
    public void addOK() {
        ArrayList<String> capitales = new ArrayList<>();
        
        capitales.add("Paris");
        capitales.add("Madrid");
        capitales.add("Rome");
        
        for(String cap : capitales) {
            System.out.println(cap);
        }
        
        
        capitales.forEach(i->System.out.println(i));
    }
    
    // @Test
    public void FactorielleOK() {
        BigInteger k;       
        k = new BigInteger("1");
        ArrayList<BigInteger> factorielleAuto = new ArrayList<>();
        for(int i=0; i<101; i++) {     
            for (int j=1; j<=i; j++) {
               k = k.multiply(new BigInteger(Integer.toString(j))); 
            }
            factorielleAuto.add(k);
            k = new BigInteger("1");
            
        }
        
        
        for(int i=0; i<101; i++) {
            System.out.println(i + " " + factorielleAuto.get(i));
        }
        
    }
        
    
    
        public int factorielle(int n) {
            int res = n;
            for(int i=n-1; i>1; i--) {
                res = res * i;
            }
            return res;
        }
        
        // @Test
        public void factorielleCorrectionOK() {
            int r = factorielle(4);
            System.out.println(r);
        }
    
        // @Test
        public void deleteOK() {
            ArrayList<String> prenoms = new ArrayList<>();
            prenoms.add("Grégoire");
            prenoms.add("Charles");
            prenoms.add("David");
            
            prenoms.add("Charles");
            // prenoms.remove(1);
            // prenoms.remove("Charles"); // Supprime le premier "Charles", mais pas le deuxième.
            
            ArrayList<String> coul1 = new ArrayList<>();
            coul1.add("rouge");
            coul1.add("vert");
            coul1.add("jaune");
            coul1.add("rouge");
            
            ArrayList<String> coul2 = new ArrayList<>();
            coul2.add("vert");
            coul2.add("rouge");
            
            System.out.println(coul1.lastIndexOf("rouge")); // me retourne la position du dernier "rouge" de ma liste
            // coul1.removeAll(coul2);
            
            System.out.println(coul1);
            
            // Le for américain m'interdit de faire des modifications de ma collection à l'intérieur
            
            // CTRL + E supprime la ligne actuelle
            
            /* clear() vide complètement la liste
            le contains renvoie true si trouve l'élément / containsAll si trouve tous les éléments de la deuxième liste
            get renvoie l'élément qu'elle trouve à l'indice donné dans le get
            indexOf : on lui donne la valeur, ça renvoie l'indice / renvoie -1 si pas dans la liste
            lastIndexOf renvoie la position du dernier mot "rouge" (par exemple) recherché dans la liste
            toArray convertit une liste en tableau
            toString renvoie une liste [valeur1, valeur2, ...]
            
            
            
            */
        }
    
}


// src = source

// github.com   davidmjp
