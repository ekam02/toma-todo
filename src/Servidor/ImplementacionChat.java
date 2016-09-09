/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Interface.InterfaceServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lorena
 */
public class ImplementacionChat extends UnicastRemoteObject implements InterfaceServidor {

    private final ArrayList<Jugador> listGamer;
    private final ArrayList<Sala> listaSalas;
    private String[] listaPirinolaOpciones;
    Integer valorFondo = 0;
    Random rnd;
    String[] arreglo;
    private int aleatorio = 0;

    public ImplementacionChat() throws RemoteException {
        super();
        listGamer = new ArrayList<Jugador>();
        listaSalas = new ArrayList<Sala>();
        arreglo = new String[]{"", "", ""};
        rnd = new Random();
    }

    @Override
    public ArrayList RecibirLista(String nombreSala) throws RemoteException {

        ArrayList listaSala = new ArrayList();
        for (int i = 0; i < listGamer.size(); i++) {
            if (nombreSala.equals(listGamer.get(i).getNombreSala())) {
                listaSala.add(listGamer.get(i).getUser());
            }
        }
        return listaSala;
    }

   
    

    @Override
    public ArrayList RecibirListaUsuarios(String nombreSala) {
        ArrayList<Jugador> jugadorSala = new ArrayList<Jugador>();
        for (int i = 0; i < listGamer.size(); i++) {
            if (listGamer.get(i).getNombreSala().equals(nombreSala)) {
                jugadorSala.add(listGamer.get(i));
            }
        }
        return jugadorSala;
    }

    

   //Métodos para enviar al servidor
   
    public void EntrarSala(String nombreSala, String nick, String pass) throws RemoteException {
        Jugador gamer = new Jugador(nick, pass, nombreSala);
        listGamer.add(gamer);
    }

   

    @Override
    public boolean RegistrarFondoUsuario(Integer value, String user) throws RemoteException {
        Jugador gamer = null;
        boolean esRegistradoFondo = false;
        for (int i = 0; i < listGamer.size(); i++) {
            gamer = listGamer.get(i);
            }
        return esRegistradoFondo;
    }

   
        
     @Override
    public void AbandonarJuego(String nick) throws RemoteException {
        for (int i = 0; i < listGamer.size(); i++) {
            if (listGamer.get(i).getUser().equals(nick)) {
                listGamer.remove(i);
                break;
            }
        }
    }

    
    
        
    @Override
    public void QuitarSala(String nombreSala) throws RemoteException {
        for (int i = 0; i < listaSalas.size(); i++) {
            if (listaSalas.get(i).getNombreSala().equals(nombreSala)) {
                listaSalas.remove(i);
            }
        }
    }

    private int AleatorioRecursivo() {
        int n = (int) (rnd.nextDouble() * 6.0);
        if (n == aleatorio) {
            AleatorioRecursivo();
        }
        aleatorio = n;
        return n;
    }

    @Override
    public void RegistrarFondoJuego(String nombreSala, Integer value, Integer caze) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void EntrarSala(String nombreSala, String nick, String pass, Integer acum) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Jugar(String nombreSala, boolean res) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void GirarPirinola(String user, String nombreSala) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void SalirJuego(String nombreSala) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean RecibirAutJuego(String nombreSala) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer RecibirCantidadFondoJuego(String nombreSala) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer RecibirCaze(String nombreSala) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] RecibirPirinola() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
