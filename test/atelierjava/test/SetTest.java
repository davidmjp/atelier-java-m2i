
package atelierjava.test;

import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formation
 */
public class SetTest {
    
    // On enlève le constructeur des classes de test, il ne sert à rien.
    
    @Test
    public void addOK() {
        
        // équivalent de ArrayList, pas de notion d'indice dedans (pas de get(indice)). Ne peut pas se parcourir avec un for avec indice. 
        HashSet<String> set = new HashSet <>();
        // ON NE PEUT PAS AVOIR DEUX FOIS LA MEME VALEUR DANS UNE LISTE HASHSET
        
        
        set.add("vert"); // sensible à la casse
        set.add("rouge");
        set.add("vert"); // N'ajoute pas "vert" parce qu'il existe déjà dans la liste.
        
        System.out.println(set);
        
        for (String coul : set) {
            System.out.println(coul);
        }
        // Le for américain peut m'afficher chaque élément de ma liste parce qu'il utilise l'élément iterator (qu'on retrouve dans les collections dans HashSet et ArrayList)
    }
    
    
}
