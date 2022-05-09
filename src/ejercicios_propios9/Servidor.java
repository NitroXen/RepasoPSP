/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios9;

import java.io.DataInputStream;
import java.io.*;
import java.net.*;
import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class Servidor extends Thread {
    private ServerSocket ss = null;
    private LinkedList<Socket> users = new LinkedList<>();
    private DataInputStream in;
    private DataOutputStream out;
    private final int PUERTO = 4999;

    
    @Override
    public void run(){
        try{
            ss = new ServerSocket(PUERTO);
            System.out.println("Servidor Conectado");
            while(true){
                Socket s = ss.accept();
                in = new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());
                
                new HiloChat(s, in, out).start();
                
                
            }
            
        }catch(IOException e){
            System.out.println("Error en el servidor");
        }
    }
    public static void main(String[] args) {
        new Servidor().start();
    }
    
}
