/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios7;

/**
 *
 * @author Admin
 */
public class Usuario {
    private String nombre;
    private int conexiones = 0;
    private boolean online;
    
    public Usuario(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre() {return nombre;}
    public boolean isOnline(){
        return online;
    }
    
    
    public void login(){
        conexiones++;
        online= true;
    }
    
    public void logout(){
        online = false;
    }

    @Override
    public String toString() {
        return (online?"ONLINE ":"OFFLINE ")+nombre+""+conexiones+" conexiones";
    }
    
    
}
