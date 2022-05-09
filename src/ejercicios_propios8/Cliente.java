/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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
            boolean salir = false;
            Scanner sc = new Scanner(System.in);

//                System.out.println(in.readUTF());
//
//                if (sc.next().charAt(0) == 's') {
//                    out.writeBoolean(true);
//                } else {
//                    salir = true;
//                    out.writeBoolean(false);
//                }
//            System.out.println("Welcome to the public chat");

            while (!salir) {

                String comando = sc.nextLine();
                out.writeUTF(comando);
                if (comando.equals(" ")) {
                    salir = true;
                }

                System.out.println(in.readUTF());
            }

        } catch (IOException e) {
            System.out.println("Error en el cliente");
        }
    }
}
