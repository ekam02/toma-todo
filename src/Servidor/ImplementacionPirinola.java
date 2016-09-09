/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Interface.InterfaceCliente;
import Interface.InterfaceServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lorena
 */
public class ImplementacionPirinola extends UnicastRemoteObject implements InterfaceServidor {

    private final ArrayList<Jugador> listGamer;
    private final ArrayList<Juego> listaJuego;
    private final ArrayList<Sala> listaSalas;
    private String[] listaPirinolaOpciones;
    Integer valorFondo = 0;
    Random rnd;
    String[] arreglo;
    private int aleatorio = 0;

    public ImplementacionPirinola() throws RemoteException {
        super();
        listGamer = new ArrayList<Jugador>();
        listaJuego = new ArrayList<Juego>();
        listaSalas = new ArrayList<Sala>();
        listaPirinolaOpciones = new String[]{"Pon 1", "Pon 2", "Todos ponen", "Toma 1", "Toma 2", "Toma todo"};
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
    public boolean RecibirAutJuego(String nombreSala) throws RemoteException {
        boolean aut = false;
        for (int i = 0; i < listaJuego.size(); i++) {
            if (nombreSala.equals(listaJuego.get(i).getNombreSala())) {
                aut = listaJuego.get(i).isAut();
            }
        }
        return aut;
    }

    @Override
    public Integer RecibirCantidadFondoJuego(String nombreSala) throws RemoteException {
        int fondo = 0;

        for (int i = 0; i < listaSalas.size(); i++) {
            if (nombreSala.equals(listaSalas.get(i).getNombreSala())) {
                fondo = listaSalas.get(i).getAcumSala();
            }
        }

        return fondo;
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

    @Override
    public String[] RecibirPirinola() throws RemoteException {

        return arreglo;
    }

    @Override
    public Integer RecibirCaze(String nombreSala) {
        Integer valorCaze = 0;

        for (int i = 0; i < listaSalas.size(); i++) {
            if (nombreSala.equals(listaSalas.get(i).getNombreSala())) {
                valorCaze = listaSalas.get(i).getCazeSala();
                break;
            }
        }

        return valorCaze;
    }

//Métodos para enviar al servidor
    @Override
    public void EntrarSala(String nombreSala, String nick, String pass, Integer num) throws RemoteException {
        Jugador gamer = new Jugador(nick, pass, nombreSala, num);
        listGamer.add(gamer);
    }

    @Override
    public void Jugar(String nombreSala, boolean res) throws RemoteException {
        Juego game = new Juego(nombreSala, res);
        listaJuego.add(game);
    }

    @Override
    public boolean RegistrarFondoUsuario(Integer value, String user) throws RemoteException {
        Jugador gamer = null;
        boolean esRegistradoFondo = false;
        for (int i = 0; i < listGamer.size(); i++) {
            gamer = listGamer.get(i);
            if (gamer.getUser().equals(user)) {
                Integer acum = gamer.getAcum();
                gamer.setAcum(acum + value);
                esRegistradoFondo = true;
                break;
            }
        }
        return esRegistradoFondo;
    }

    @Override
    public void RegistrarFondoJuego(String nombreSala, Integer value, Integer caze) throws RemoteException {

        System.out.println("Entro sala");
        Sala salas;
        int i;
        for (i = 0; i < listaSalas.size(); i++) {
            salas = listaSalas.get(i);
            if (salas.getNombreSala().equals(nombreSala)) {
                Integer acum = salas.getAcumSala();
                salas.setAcumSala(acum + value);
            }
        }
        if (i == 0) {
            System.out.println("No hay sala");
            Sala sala = new Sala(nombreSala, value, caze);
            listaSalas.add(sala);
        }
    }

    @Override
    public void GirarPirinola(String user, String nombreSala) throws RemoteException {
        int n = AleatorioRecursivo();
        for (int i = 0; i < listaPirinolaOpciones.length; i++) {
            if (i == n) {
                for (int j = 0; j < listGamer.size(); j++) {
                    if (user.equals(listGamer.get(j).getUser())) {
                        arreglo[0] = nombreSala;
                        arreglo[1] = listaPirinolaOpciones[i];
                        if (j + 1 == listGamer.size()) {
                            arreglo[2] = listGamer.get(0).getUser();
                        } else {
                            arreglo[2] = listGamer.get(j + 1).getUser();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void AbandonarJuego(String user) throws RemoteException {
        for (int i = 0; i < listGamer.size(); i++) {
            if (listGamer.get(i).getUser().equals(user)) {
                listGamer.remove(i);
                break;
            }
        }
    }

    @Override
    public void SalirJuego(String nombreSala) throws RemoteException {
        for (int i = 0; i < listaJuego.size(); i++) {
            if (listaJuego.get(i).getNombreSala().equals(nombreSala)) {
                listaJuego.remove(i);
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
}
