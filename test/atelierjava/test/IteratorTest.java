/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.test;

import java.util.HashSet;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formation
 */
public class IteratorTest {
    
    @Test
    public void iteratorOK() {
        HashSet<String> set = new HashSet<>();
        set.add("rouge");
        set.add("jaune");
        set.add("vert");
        
/*        set.iterator();
        
  */
        // System.out.println(set);
        Iterator<String> iterateur = set.iterator();
        
         while(iterateur.hasNext() == true) { //  == true est facultatif
             System.out.println(iterateur.next());
         }
        
        
        
        /*
        String couleur1 = iterateur.next();
        String couleur2 = iterateur.next();
        String couleur3 = iterateur.next();
        if (iterateur.hasNext() == true) { String couleur4 = iterateur.next(); }
        
        System.out.println(couleur1 + couleur2 + couleur3);
        */
       
//        System.out.println(set);
        // A l'intérieur de l'iterator, on va avoir tous nous éléments, mais ça ne respecte pas forcément l'ordre d'entrée.
        
        // Les variables de CLASSES sont initialisées à NULL mais pas les variables de fonctions qu'il faut toujours initialiser.
    }
    
}
