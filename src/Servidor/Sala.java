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
public class Sala implements Serializable{
    String nombreSala;
    Integer acumSala;
    Integer cazeSala;

    public Sala(String nombreSala, Integer acumSala, Integer cazeSala) {
        this.nombreSala = nombreSala;
        this.acumSala = acumSala;
        this.cazeSala = cazeSala;
    }

    public Integer getCazeSala() {
        return cazeSala;
    }

    public void setCazeSala(Integer cazeSala) {
        this.cazeSala = cazeSala;
    }

    public Integer getAcumSala() {
        return acumSala;
    }

    public void setAcumSala(Integer acumSala) {
        this.acumSala = acumSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }
    
    
}
