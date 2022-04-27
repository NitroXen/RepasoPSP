/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;


import java.io.IOException;
import java.net.*;

/**
 *
 * @author Admin
 */
public class Servidor {
    private static ServerSocket ss;
    public static boolean salir = false;
    private static GestorConexiones gc;
    
    
    public static void cerrar(){
        try{
            ss.close();
        }catch(IOException ex){System.out.println("Servidor abajo");}
    }
    
    public static void main(String[] args) {
        try{
            ss= new ServerSocket(Config.PUERTO);
        }catch(IOException ex){
            System.out.println("Error al iniciar el Servidor");
            return;
        }
        System.out.println("Servidor Online, esperando Conexiones");
        gc = new GestorConexiones(ss);
        while(!salir){
            try{
                Socket s = ss.accept();
                new ConexionServidor(gc, s).start();
            }catch(IOException ex){
                System.out.println("el servidor ha caido");
            return;
            }
        }
        
    }
}
