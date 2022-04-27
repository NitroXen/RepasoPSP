/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class Servidor {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(7);
            System.out.println("Servidor Online");
            Socket s = ss.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            out.writeUTF("Envio del servidor");
            
            System.out.println(in.readUTF());
            
            
        }catch(IOException e){}
    }
}
