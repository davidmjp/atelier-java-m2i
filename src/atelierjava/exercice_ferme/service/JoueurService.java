/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.service;

import atelierjava.exercice_ferme.dao.JoueurDAO;
import atelierjava.exercice_ferme.entite.Joueur;

/**
 *
 * @author Formation
 */
public class JoueurService {

    /**
     * pseudo : mini 3 lettres, maxi 8 unique
     *
     * mdp : mini 5 lettres, maxi 10 au moins une majuscule et un chiffre
     *
     * @param pseudo
     * @param mdp
     */
    // ALT + SHIFT + O : go to file pour retrouver un fichier du projet
    public void inscription(String pseudo, String mdp) {

        // if (pseudo.length() < 3 || pseudo.length() > 8) {
        if (!pseudo.matches(".{3,8}")) {
            throw new RuntimeException("Le pseudo doit être compris entre 3 et 8 caractères.");
//            System.out.println("Veuillez choisir un mot de passe compris entre 3 et 8 caractères.");
        }

        if (!mdp.matches(".{5,10}")) {
            throw new RuntimeException("Le mot de passe doit être compris entre 3 et 8 caractères.");
        }

        if (!mdp.matches(".*[A-Z].*")) {
            throw new RuntimeException("Le mot de passe requiert une majuscule.");
        }

        if (!mdp.matches(".*[0-9].*")) {
            throw new RuntimeException("Le mot de passe doit contenir au moins un chiffre.");
        }
//        throw new RuntimeException("une erreur a été détectée");

        // pseudo.Character.isLowerCase();
        //    System.out.println(pseudo.chars().filter(Character::isUpperCase).count()); // Voir dans FermeServiceTest
        // Vérifier que le pseudo est encore dispo
        JoueurDAO dao = new JoueurDAO();
        if (dao.existe(pseudo)) {
            throw new RuntimeException("Ce pseudo existe déjà.");
        }

        // Ajoute la ferme en BD
        Joueur ferme = new Joueur();
        ferme.setPseudo(pseudo);
        ferme.setMotDePasse(mdp);
        dao.ajouter(ferme);
    }

    public void connexion(String pseudo, String mdp) {

        JoueurDAO dao = new JoueurDAO();
        if (!dao.existe(pseudo, mdp)) {
            throw new RuntimeException("Echec de connexion");
        }
    }
}
