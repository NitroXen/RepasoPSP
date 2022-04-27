/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Cliente {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 4999);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            
            boolean salir = false;
            while(!salir){
                System.out.println("Escribe para retransmitir:");
                String texto = sc.nextLine();
                
                out.writeUTF(texto);
                if(texto.equals(Config.CMD_FIN)){
                    salir = true;
                }
                System.out.println(in.readUTF());
                
            }
            
        }catch(IOException ex){System.out.println("Error en el cliente: no enlaza con el servidor");}
    }
}
