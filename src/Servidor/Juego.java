/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.Serializable;

/**
 *
 * @author lorena
 */
public class Juego implements Serializable{
    String nombreSala;
    boolean aut;

    public Juego(String nombreSala, boolean aut) {
        this.nombreSala = nombreSala;
        this.aut = aut;
    }

    public boolean isAut() {
        return aut;
    }

    public void setAut(boolean aut) {
        this.aut = aut;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }
    
    
}
