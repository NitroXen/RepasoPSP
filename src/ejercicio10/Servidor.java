/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Servidor extends Thread {

    private boolean salir = false;
    private ServerSocket ss;
    private ArrayList<HiloCliente> listaCliente;

    private Servidor() throws IOException {
        System.out.println("Servidor conectado");
        ss = new ServerSocket(4999);

    }

    private void conexion() throws IOException {

        Socket s = ss.accept();

        HiloCliente hc = new HiloCliente(s, this);
        hc.start();
    }

    public void shutdown() throws IOException {
        ss.close();
    }

    @Override
    public void run() {
        try{
            conexion();
        }catch(IOException ex){}
    }

    public static void main(String[] args) throws IOException {

        Servidor server = new Servidor();
        server.start();
    }
}
