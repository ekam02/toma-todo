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
public class Jugador implements Serializable{
    
    String user;
    String pass;
    String nombreSala;
    Integer acum;

    public Jugador(String user, String pass, String nombreSala, Integer acum) {
        this.user = user;
        this.pass = pass;
        this.nombreSala = nombreSala;
        this.acum = acum;
    }

    Jugador(String nick, String pass, String nombreSala) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Integer getAcum() {
        return acum;
    }

    public void setAcum(Integer acum) {
        this.acum = acum;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
