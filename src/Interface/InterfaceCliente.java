/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author lorena
 */
public interface InterfaceCliente extends java.rmi.Remote{
    public ArrayList RecibirLista(String nombreSala) throws RemoteException;
    public boolean RecibirAutJuego(String nombreSala) throws RemoteException;
    public Integer RecibirCantidadFondoJuego(String nombreSala) throws RemoteException;
    public ArrayList RecibirListaUsuarios(String nombreSala) throws RemoteException;
    public Integer RecibirCaze(String nombreSala) throws RemoteException;
    public String[] RecibirPirinola() throws RemoteException;
}
