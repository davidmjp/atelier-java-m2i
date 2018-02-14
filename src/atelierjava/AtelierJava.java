/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava;

import java.util.ArrayList;

/**
 *
 * @author Formation
 */
public class AtelierJava {

        
        /* Clic droit sur AtelierJava : "Build" qui construit les dossiers "bild" et "dist"
        Dans le dossier build/ classes / AtelierJava avec des fichiers .class qui sont des fichiers compilés par le "build"
        Le .java est du code source qui doit être compilé par du JDK
        NetBeans a exécuté la commande Javac (java compilor) sur mon code source qui génère le fichier .class
        Sans NetBeans : 
        
        fichier source atelierjava.java dans src
        
        JRE contient la commade java qui permet d'exécuter des fichiers .class déjà compilés par javac
        
        un .jar est un java archive (dans le dossier "dist")
        
        (ide : environnement de développement, ici NetBeans, qui utilise javac pour compiler)
        
        On peut renommer un .jar en .zip pour le décompresser et voir ce qu'il y a dedans.
        
        Java n'est pas un langage de script, c'est un langage compilé.
        
        Le JRE est un pseudo système d'exploitation sur lequel vont tourner nos class et nos jar
        
        (arduino, Radsberry petits ordinateurs linux à 30 euros ?)
        
        On peut avoir un "main" dans chaque classe, dans le cas d'un "jeu de tests"e, on fait des "main" pour pouvoir tester chaque fonction séparément
        Clic droit sur le projet, properties, main classes, d'où on peut choisir quelle classe "main" sera la principale
        
        AtelierJava.main(args); // pas besoin de new pour une fonction statique
        Le point d'entrée est le nom de la classe qui se trouve dans le manifeste, après qu'importe qu'on appelle des fonctions "main" dans d'autres classes. Statiques, on peut les appeler de n'importe où.
        
        un public static main comme point d'entrée est obligatoire, on ne peut pas partir de n'importe quelle fonction comme point d'entrée
        
        on peut définir des points d'entrée unitaires, tests unitaires pour tester une ou des fonctions en particulier, qui ne dépendent pas les unes des autres
        
        On peut avoir différents types de points d'entrée : 
            - main (défini dans le manifest)
            - @Test  (@ pour les Framework)
            - Web : les fonctions contrôleur, des contrôleurs (qui sont toujours des points d'entrée mais ça fonctionne techniquement différemment)
        
        new file / unit tests / jUnit Test / nom du package en minucules, de la classe qui commence par une majuscule 
        
        Le Java n'est pas utilisé pour de la performance, mais pour de la robustesse
        (certaines zones de mémoires ne sont pas libérées)
        
        Variables de classe qu'on appelle aussi attributs ou propriétés
        
    CTRL + Shift + C pour faire une ligne de commentaire
    
    
        
       */   
    
    
    
        Animal cochon; // Devient un attribut, une propriété de ma classe si je le définis ici
        // Les variables d'un objet appartiennent à l'intance de l'objet et pas à la classe
    
    public static void mainAnimaux1(String[] args) {
        
        
//        Animal cochon = new Animal();

        Animal a1 = new Animal(); // à chaque fois que je fais un new, on appelle le constructeur et nbAnimaux va être incrémenté
        a1.poidsEnKg = 12;
        a1.espece = "cochon";
        a1.genre = "sus";
        
        Animal a2 = new Animal();
        a2.poidsEnKg = 2000;
        a2.espece = "girafe";
        a2.genre = "giraffa";
        
       /* a1.afficher();
        a2.afficher();
        */
        System.out.println(a1);
        System.out.println(a2);
        
    }
    
    
    public static void mainFerme(String[] args) {
        Fermier f1 = new Fermier();
        Fermier f2 = new Fermier();
        
        f1.setNom("Monsieur1");
        f2.setNom("Monsieur2");
        
        System.out.println(f1);
        System.out.println(f2);
        
        // ça retourne : atelierjava.Fermier@6d06d69c  sauf si j'ovverride le toString() dans fermier.java
       
        
    }
        
        // System.out.println("Un " + a1.espece + " qui pèse " + a1.poidsEnKg + "kg, et une " + a2.espece + " qui pèse " + a2.poidsEnKg + "kg. Ce qui fait " + Animal.nbAnimaux + " animaux.");
        
        // renvoie : atelierjava.Animal@6d06d69c   qui est l'équivalent de son adresse mémoire
        // class.variablestatic : Animal.nbAnimaux
        
        
    
    
    public static void mainVariablesStatiques(String[] args) {
        Personne p1 = new Personne();
        p1.setNom("Guillaume");
        p1.setAge(20);
        
        Personne p2 = new Personne();
        p2.setNom("Maxence");
        p2.setAge(10);
        
        Personne p3 = new Personne();
        p3.setNom("Maël");
        p3.setAge(0);        
        
        /* On veut traiter cette partie dans le setAge avec une variable static
        if ((p1.getAge() > p2.getAge()) && (p1.getAge() > p3.getAge())) System.out.println(p1.getAge() + " est l'âge maximum.");
        if ((p2.getAge() > p1.getAge()) && (p2.getAge() > p3.getAge())) System.out.println(p2.getAge() + " est l'âge maximum.");
        if ((p3.getAge() > p1.getAge()) && (p3.getAge() > p2.getAge())) System.out.println(p3.getAge() + " est l'âge maximum.");
        */
        
        
        System.out.println("L'âge minimum est : " + Personne.getAgeMini() + " ans, et l'âge maximum est : " + Personne.getAgeMaxi() + " ans.");
        
       
    }
    
    public static void main(String[] args) {
        String[] tab = new String[3];
        tab[0] = "Veau";
        tab[1] = "Vache";
        tab[2] = "Cochon";
      //  tab[3] = "Cheval";
      
      String[] tab2 = new String[4];
      for(int i=0; i<tab.length; i++) {
          tab2[i] = tab[i];
      }
      tab2[tab2.length-1] = "Croco";
      
      
       //  ArrayList liste = new ArrayList(); Je type ma liste pour l'utilisation du 2ème FOR :
       ArrayList<String> liste = new ArrayList<>(); // Je peux écrire deux fois <String> ou la 2ème fois <>
       
       
      // Il faut cliquer sur CTRL + ESP après avoir écrit ArrayList pour importer cette classe. L'import se fait en haut de ce fichier.
      
      liste.add("Rouge");
      liste.add("Vert");
      liste.add("Jaune");
      
      for (int i=0; i<liste.size(); i++) { // tant que i est plus petit que la taille de ma liste (3)
          System.out.println(liste.get(i));
      }
      
      // FOR version moderne :
      for (String couleur : liste) { // Je vais itérer sur chaque élément de ma collection "liste". Avant chaque itération, ma variable "couleur" va contenir l'élément de la liste
          System.out.println(couleur);
      }
      
      
      liste.forEach(i->System.out.println(i));

        System.out.println(liste);
    }
}
