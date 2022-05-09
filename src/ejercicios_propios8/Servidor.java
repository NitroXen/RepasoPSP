/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios8;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class Servidor extends Thread {

    ServerSocket ss;
    private final int NUM_MAX_CONEXIONES = 2;
    private static int numConexiones = 0;

    public Servidor() {
        try {
            ss = new ServerSocket(4999);
            System.out.println("Servidor conectado");
        } catch (IOException e) {
            System.out.println("Error en el servidor");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket s = ss.accept();
                new HiloCliente(s, this).start();
                if (numConexiones > NUM_MAX_CONEXIONES) {
                    break;
                }
            }
            ss.close();
        } catch (IOException e) {
        }
    }

    public void add() {
        numConexiones++;
    }

    public void bye() {
        numConexiones--;
    }

    public static void main(String[] args) {
        new Servidor().start();
    }
}

class HiloCliente extends Thread {

    Socket s;
    DataInputStream in;
    DataOutputStream out;
    Servidor ser;
    private boolean salir;
//    private static int num;

    public HiloCliente(Socket s, Servidor ser) {
        this.s = s;
        this.ser = ser;
        salir = false;
        ser.add();
        try {
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        try {

            while (!salir) {

                String resp = in.readUTF();

                if (resp.equals(" ")) {
                    salir = true;
                }
                out.writeUTF(resp);

            }
            cierre();
        } catch (IOException e) {
        }
    }

    private void cierre() throws IOException {
//        num--;
        ser.bye();
        s.close();
        in.close();
        out.close();
    }

    public void controlar() throws IOException {
        out.writeUTF("Continuar?:");

        if (!in.readBoolean()) {
            salir = true;
//            num++;
//            out.writeUTF("Bienvenido!!!! USER = "+ num);
//            if (num > 2) {
////                out.writeUTF("Max de personas en este servidor = 2, Adios");
//                num--;
//                salir = true;
        }

//            out.writeUTF("Saliendo del servidor");
    }
}
