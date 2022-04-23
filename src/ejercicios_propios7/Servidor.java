/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Servidor_Connectado");
        Socket s = null;
        int numClientes = 0;
        Thread t;
        while (numClientes < 2) {
            try {
                s = ss.accept();
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                t = new ClientHeader(s, in, out);
               
                
                
                
                t.start();
            } catch (Exception ex) {
                s.close();
            }

        }
    }

}

class ClientHeader extends Thread {

    DateFormat date = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat time = new SimpleDateFormat("hh:mm:ss");
    DataInputStream in;
    DataOutputStream out;
    Socket s;

    public ClientHeader(Socket s, DataInputStream in, DataOutputStream out) {
        this.s = s;
        this.in = in;
        this.out = out;
    }
    
    public boolean comprobarEstado(boolean estado){
        return estado;
    }
    

    @Override
    public void run() {
        String received;
        String toReturn;
        while (true) {
            try {
                out.writeUTF("System.out.println(\"Fin del Servidor\");");
                received = in.readUTF();
                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " Exit!");
                    System.out.println("Closing connection!");
                    this.s.close();
                    System.out.println("Connetion Closed");
                    break;
                }
                Date d = new Date();
                switch (received) {
                    case "Date":
                        toReturn = date.format(d);
                        out.writeUTF(toReturn);
                        break;
                    case "Time":
                        toReturn = time.format(d);
                        out.writeUTF(toReturn);
                        break;
                    default:
                        out.writeUTF("Invalid Input!");
                        break;
                }

            } catch (IOException ex) {
            }
        }
        try {
            this.in.close();
            this.out.close();
        } catch (IOException ex) {
        }
    }

}
