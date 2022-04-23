/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios7;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Cliente{
    
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 5000);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            while(true){
                System.out.println(in.readUTF());
                String toSend = sc.nextLine();
                out.writeUTF(toSend);
                if(toSend.equals("Exit")){
                    System.out.println("Closing this Connection: "+ s);
                    s.close();
                    System.out.println("Connection Closed!");
                    break;
                }
                String received = in.readUTF();
                System.out.println(received);
            }
            sc.close();
            in.close();
            out.close();
        }catch(Exception ex){}
    }
    
    
}