/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class ConexionServidor extends Thread {

    private Socket s;
    private GestorConexiones gc;
    private DataInputStream in;
    private DataOutputStream out;

    public ConexionServidor(GestorConexiones gc, Socket s) {
        this.gc = gc;
        this.s = s;
        try {
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error al establecer conexion");
        }

    }

    void cerrarCliente() {
        try{
            s.close();
        }catch(IOException ex){
            System.out.println("Problemas Cerrando el cliente");
        }
    }

    @Override
    public void run() {
        String nombreUser = "";
        try{
            nombreUser = in.readUTF();
            String passwd = in.readUTF();
            Config.AutorizarConexion autorizacion =gc.autorizarNuevaConexion(nombreUser, passwd);
            boolean loginOk=(autorizacion==Config.AutorizarConexion.ok);
            out.writeBoolean(loginOk);
            if(loginOk){
                System.out.println("Conectado "+nombreUser);
                boolean salir = false;
                do{
                    String comando = in.readUTF();
                    switch(comando){
                        case Config.CMD_SALIR:
                            gc.cortarConexion(nombreUser, this);
                            salir = true;
                            break;
                        case Config.CMD_APAGAR:
                            gc.shutdown();
                            salir = true;
                            break;
                        default:
                            out.writeUTF(gc.getInfoUsuario(comando));
                            break;
                    }
                }while(!salir);
            }else{
                out.writeInt(autorizacion.ordinal());   
            }
        }catch(IOException ex){}
    }

}
