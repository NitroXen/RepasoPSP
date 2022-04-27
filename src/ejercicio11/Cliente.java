/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Cliente {

    public static void main(String[] args) {
        Socket s;
        DataInputStream in = null;
        DataOutputStream out = null;
        Scanner sc = new Scanner(System.in);

        try {
            s = new Socket("localhost", Config.PUERTO);
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error al conectar con el servidor");
        }
        
        try{
            System.out.println("Introduce su usuario");
            String user = sc.nextLine();
            out.writeUTF(user);
            System.out.println("Introduzca la contraseña");
            out.writeUTF(sc.nextLine());
            boolean loginOk=in.readBoolean();
            
            if(loginOk){
                boolean salir = false;
                do{
                    System.out.printf("[%s]>", user);
                    String comando = sc.nextLine();
                    switch(comando){
                        case Config.CMD_SALIR:
                        case Config.CMD_APAGAR:
                            salir = true; break;
                        default:
                            System.out.println(in.readUTF());

                    }
                }while(!salir);
            }else{
                int codRespuestaAutorizacion = in.readInt();
                String error = "error no especificado";
                switch(Config.AutorizarConexion.values()[codRespuestaAutorizacion]){
                    case CredencialesIncorrectas: error = "Usuario y/o contraseña incorecta"; break;
                    case UsuarioYaConectado: error = "Usuario conectado en otra terminal";break;
                }
                System.out.println(error);
            }
            
            
        }catch(IOException ex){System.out.println("La conexion fue finalizada");}
    }
}
