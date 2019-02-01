/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasObjetos;

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
        // TODO code application logic here
        String encriptado = PruebasObjetos.LogicaEncriptacion.encriptar();
        System.out.println(encriptado);
            String desencriptado = null;
        try {
            desencriptado = PruebasObjetos.LogicaEncriptacion.desencriptar(encriptado);
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(desencriptado);
        
    }
    
}
