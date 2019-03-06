/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author zapia
 */
public class Usuario {

    String nombre;

    public Usuario(String nombre) {
        this.nombre = "@" + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = "@" + nombre;
    }
}
