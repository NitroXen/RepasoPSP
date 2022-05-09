/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios9;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class HiloChat extends Thread {

    Socket s;
    DataInputStream in;
    DataOutputStream out;
    private boolean salir = false;
    private static int conexiones = 0;

    public HiloChat(Socket s, DataInputStream in, DataOutputStream out) {
        this.s = s;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            out.writeUTF("Continuar?(s,n):");

            if (in.readBoolean()) {
                conexiones++;
                if (conexiones > 2) {
                    conexiones--;
                    salir = true;
                }
            } else {
                salir = true;
            }

            while (!salir) {

                String chat = in.readUTF();

                if (chat.equals("")) {
                    salir = true;
                } else {
                    System.out.println(s.getInetAddress() + ": " + chat);
                }
            }
            conexiones--;
            s.close();
            in.close();
            out.close();

        } catch (IOException e) {
        }
    }

}
