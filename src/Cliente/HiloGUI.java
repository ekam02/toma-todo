/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Interface.InterfaceCliente;
import Interface.InterfaceServidor;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorena
 */
public class HiloGUI extends Thread implements Runnable {

    boolean alive = true;
    private final GUIPrincipal gui;
    private final String user;
    private final String nombreSala;
    private final InterfaceServidor intCli;
    private ArrayList listaUsers;
    private boolean esAutorizado;
    private Integer valorFondo;
    private ArrayList listaObjetosUsuarios;
    private String[] listaPirinola;
    private Integer valueCaze;
    

    public HiloGUI(GUIPrincipal gui, String user, String nombreSala, InterfaceServidor intCli) {
        this.gui = gui;
        this.user = user;
        this.nombreSala = nombreSala;
        this.intCli = intCli;
        listaObjetosUsuarios = new ArrayList();
    }
    
    

    public void Detener() {
        this.stop();
    }

    @Override
    public void run() {
        while (alive) {
            try {
                //Instrucciones
                listaUsers = intCli.RecibirLista(nombreSala);
                esAutorizado = intCli.RecibirAutJuego(nombreSala);
                valorFondo = intCli.RecibirCantidadFondoJuego(nombreSala);
                listaObjetosUsuarios = intCli.RecibirListaUsuarios(nombreSala);
                valueCaze = intCli.RecibirCaze(nombreSala);
                listaPirinola = intCli.RecibirPirinola();
                
                demux(listaUsers, esAutorizado, valorFondo, listaObjetosUsuarios, listaPirinola, valueCaze);
                this.sleep(100);
            } catch (RemoteException ex) {
                Logger.getLogger(HiloGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException e) {
            }
        }
    }
    
    public void demux(ArrayList lista, boolean aut, Integer valorFondo, ArrayList listaUsuarios, String[] listaPir, Integer caze){
        if (lista != null){
            gui.MostrarLista(lista);
        }
        
        if (aut != false){
            gui.AutorizarJuego(aut);
        }
        
        if (valorFondo != -1){
            gui.MostrarFondoJuego(valorFondo);
        }
        
        if (listaUsuarios!=null){
            gui.MostrarPuntuacionUsuarios(listaUsuarios);
        }
        
        if (listaPir != null){
            gui.MostrarPirinola(listaPir);
        }
        
        gui.MostrarCaze(caze);
        
    }
}
