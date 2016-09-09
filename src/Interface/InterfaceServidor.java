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
public interface InterfaceServidor extends java.rmi.Remote{
    public void EntrarSala(String nombreSala, String nick, String pass, Integer acum) throws RemoteException;
    public void Jugar(String nombreSala, boolean res) throws RemoteException;
    public boolean RegistrarFondoUsuario(Integer value, String user) throws RemoteException;
    public void RegistrarFondoJuego(String nombreSala, Integer value, Integer caze) throws RemoteException;
    public void GirarPirinola(String user, String nombreSala) throws RemoteException;
    public void AbandonarJuego(String user) throws RemoteException;
    public void SalirJuego(String nombreSala) throws RemoteException;
    public void QuitarSala(String nombreSala) throws RemoteException;
    
    public ArrayList RecibirLista(String nombreSala) throws RemoteException;
    public boolean RecibirAutJuego(String nombreSala) throws RemoteException;
    public Integer RecibirCantidadFondoJuego(String nombreSala) throws RemoteException;
    public ArrayList RecibirListaUsuarios(String nombreSala) throws RemoteException;
    public Integer RecibirCaze(String nombreSala) throws RemoteException;
    public String[] RecibirPirinola() throws RemoteException;
    

    

    
}
