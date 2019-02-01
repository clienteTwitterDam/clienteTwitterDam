/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adolfolaviana
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String encriptado = LogicaEncriptacion.encriptar("Esto es una prueba");
            System.out.println(encriptado);
            String desencriptado = LogicaEncriptacion.desencriptar(encriptado);
            System.out.println(desencriptado);
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
