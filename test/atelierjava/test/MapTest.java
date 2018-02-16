/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.test;

import java.util.HashMap;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formation
 */
public class MapTest {
    
    @Test
    public void mapOK() {
        HashMap<String, String> paysCapitales = new HashMap<>();
        paysCapitales.put("France", "Paris");
        paysCapitales.put("Japon", "Tokyo");
        paysCapitales.put("Angleterre", "Londres");
        
        System.out.println(paysCapitales.get("Japon"));
        
        System.out.println(paysCapitales.keySet()); // Retourne la liste des clés (des pays)
        
        Set<String> cles = paysCapitales.keySet(); // Ne pas confondre Set avec HashSet
        System.out.println(cles);
        for (String pays : cles) {
            System.out.println(pays + " -->> " + paysCapitales.get(pays));
        }
        
        
        
        System.out.println(paysCapitales.values()); // Retourne la liste des valeurs (des capitales)
        
        System.out.println(paysCapitales.toString()); // Retourne clé=valeur
        System.out.println(paysCapitales.entrySet()); // même chose
        System.out.println(paysCapitales); // même chose
        
        // System.out.println(paysCapitales.);
        
        // putAll ajoute une map dans une autre
        
    }
    
}
