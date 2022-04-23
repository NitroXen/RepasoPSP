/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios7;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class GestorConexion {
    
    private ServerSocket ss;
    private HashMap<String, Usuario> datos;
    private ArrayList<ConexionServidor> listaConexiones;
    
    
    
    public GestorConexion(ServerSocket ss){
        this.ss = ss;
        datos = new HashMap<>();
        listaConexiones = new ArrayList<ConexionServidor>();
    }
    
    public void nuevaConexionSinAutorizar(ConexionServidor cs){
        listaConexiones.add(cs);
    }
}
