/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjava.exercice_ferme.exception;

/**
 *
 * @author Formation
 */
public class ValidationException extends Exception {

        // ALT+INSERT : insert code, constructeur, Exception(String message) 
    public ValidationException(String message) {
        super(message);
        // le "super" appelle le constructeur de la classe parent
    }
    
    
    
}
