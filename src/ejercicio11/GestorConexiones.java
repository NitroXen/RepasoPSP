/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class GestorConexiones {
    
    private ServerSocket ss;
    private HashMap<String, Usuario> datos;
    private ArrayList<ConexionServidor> listaConexiones;
    
    public GestorConexiones(ServerSocket ss){
        this.ss =ss;
        datos = new HashMap<>();
        listaConexiones = new ArrayList<>();
    }
    
    Config.AutorizarConexion autorizarNuevaConexion(String nombreUser, String passwd){
        if(!credencialesOK(nombreUser, passwd))return Config.AutorizarConexion.CredencialesIncorrectas; 
        
        Usuario user = datos.get(nombreUser);
        if(user==null)datos.put(nombreUser, new Usuario(nombreUser));
        else{
            if(user.isOnline())return Config.AutorizarConexion.UsuarioYaConectado;
            user.login();
        }
        return Config.AutorizarConexion.ok;
    }
    
    private boolean credencialesOK(String usuario, String passwd){
        return passwd.equalsIgnoreCase(usuario + usuario.length());
    }
    
    String getInfoUsuario(String nombreUser){
        Usuario user = datos.get(nombreUser);
        if(user!=null)return user.toString();
        return "Usuario no encontrado";
    }
    
    void cortarConexion(String nombreUser,ConexionServidor cs){
        setUsuarioOFFLINE(nombreUser);
        cs.cerrarCliente();
        listaConexiones.remove(cs);
    }
    
    private void setUsuarioOFFLINE(String nombreUser){
        Usuario user = datos.get(nombreUser);
        if(user!=null)user.logout();
    }
    
    void shutdown() throws IOException{
        for(ConexionServidor connect:listaConexiones){
            connect.cerrarCliente();
        }
        ss.close();
    }
}
