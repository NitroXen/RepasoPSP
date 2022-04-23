/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 7);
            
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            System.out.println(in.readUTF());
            out.writeUTF("recibido del Cliente");
            
        } catch (IOException e) {
            System.out.println("Error en la conexion: no enlazado");
        }

    }
}
