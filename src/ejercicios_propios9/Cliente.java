/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios9;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4999);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            
            boolean salir = false;
            
            
            System.out.println(in.readUTF());
            if(sc.next().charAt(0) == 's'){
                out.writeBoolean(true);
            }else{
                salir = true;
                out.writeBoolean(false);
                
            }
            while(!salir){
                
                String chat = sc.nextLine();
                out.writeUTF(chat);
                if(chat.equals("")){
                    salir = true;
                }
                
                System.out.println(in.readUTF());
            }
            
            s.close();
            in.close();
            out.close();
            
        } catch (IOException e) {
        }
    }

}
