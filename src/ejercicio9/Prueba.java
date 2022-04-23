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
public class Prueba {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(7);
        System.out.println("Servidor Online");
        Socket s = ss.accept();
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        out.writeUTF("hola mundo");
        
    }
}

class Cli{
    public static void main(String[] args) {
        try{
        Socket s = new Socket("localhost", 7);
        DataInputStream in = new DataInputStream(s.getInputStream());
        
            System.out.println(in.readUTF());
        
        }catch(IOException ex){System.out.println("Error en la conexion: no enlaza");}
    }
}
