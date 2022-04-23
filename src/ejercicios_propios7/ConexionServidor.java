/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ConexionServidor {
    private GestorConexion gc;
    private Socket s;
    private DataInputStream in;
    private DataOutputStream out;

    public ConexionServidor(GestorConexion gc, Socket s) {
        this.gc = gc;
        this.s = s;
        try{
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
        }catch( IOException ex){}
        gc.nuevaConexionSinAutorizar(this);
    }
    
    
    
    
}
